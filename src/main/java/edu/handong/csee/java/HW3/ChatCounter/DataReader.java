package edu.handong.csee.java.HW3.ChatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Thread;

/**
 * @version java version "9.0.4"
 * @author Lee MyeongHui
 * This class is defined to read files from directory paths with threads.
 * The DataReader class has main(), getData(), getDataDirectory(), getListOfFilesFromDirectory() methods
 * The DataReader class has files memeber, ob and ob2 arrayList, mmm static arrayList.
 */
public class DataReader {
	private File[] files;

	static ArrayList<DataReaderForTXTThread> ob=new ArrayList<DataReaderForTXTThread>();
	static ArrayList<DataReaderForCSVThread> ob2=new ArrayList<DataReaderForCSVThread>();

	/**
	 *  This ArrayList type is class String
	 *  its modifier is static and public
	 *  This arrayList stores all messages.
	 */
	public static ArrayList<String> mmm=new ArrayList<String>();


	public static void main(String[] args) throws FileNotFoundException {

		// TODO Auto-generated method stub	
		CliRunner runner=new CliRunner();
		runner.run(args);
		int coreNum = Integer.parseInt(runner.coreNum);

		

		DataReader dataReader = new DataReader();
		try {
			dataReader.getData(runner.inputPath, coreNum);

			for(DataReaderForTXTThread ob3:ob)
			{
				mmm.addAll(ob3.getSmallArray());
			}

			for(DataReaderForCSVThread ob4:ob2)
			{
				mmm.addAll(ob4.getSmallArray());
			}

			for(int b=0;b<mmm.size();b++)
			{
				//System.out.println(";;;;;;;;"+mmm.get(b));
			}
			AddToHashMap2.addToHashMap2();

			ChatMessageCounter.chatMessageCount(runner.outputPath);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("please typing pleas....");
		}

	}

	private void getData(String strDir, int coreNum)
	{

		//getListOfFilesFromDirectory(getDataDirectory(strDir),coreNum);
		files=getListOfFilesFromDirectory(getDataDirectory(strDir),coreNum);
		return;

	}

	private File getDataDirectory(String strDir)
	{
		File f=new File(strDir);
		return f;
	}

	private File[] getListOfFilesFromDirectory(File dataDir, int coreNum)
	{
		ExecutorService executor = Executors.newFixedThreadPool(coreNum);


		for(File file:dataDir.listFiles())
		{
			String fileName=file.getPath();

			if(fileName.contains(".txt")==true) {
				Runnable worker = new DataReaderForTXTThread(fileName);
				executor.execute(worker);
				ob.add((DataReaderForTXTThread)worker);



				//DataReaderForTXT.readForTxtData(fileName);
			}
			else if(fileName.contains(".csv")==true) {

				Runnable worker = new DataReaderForCSVThread(fileName);
				executor.execute(worker);
				ob2.add((DataReaderForCSVThread)worker);


			}


		}
		executor.shutdown();

		while(!executor.isTerminated()) {


		}

		return dataDir.listFiles();
	}


}
//

