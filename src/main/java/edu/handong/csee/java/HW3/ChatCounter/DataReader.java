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
 * This class is defined to read files from directory paths.
 * The DataReader class has main(), getData(), getDataDirectory(), getListOfFilesFromDirectory() methods
 * The DataReader class has files memeber
 */
public class DataReader {
	private File[] files;
	//public static ArrayList<Thread> threadList=new ArrayList<Thread>();

	//private static String path;

	public static void main(String[] args) throws FileNotFoundException {

		// TODO Auto-generated method stub	
		int coreNum = Integer.parseInt(args[1]);

		CliRunner runner=new CliRunner();
		runner.run(args);

		DataReader dataReader = new DataReader();
		try {
			dataReader.getData(args[3], coreNum);
			/*for(Thread thread:threadList)
			{
				try {
					thread.join();
				}catch(InterruptedException e)
				{
					System.out.println("error");
				}
			}
			*/
			AddToHashMap2.addToHashMap2();
			
			ChatMessageCounter.chatMessageCount(args[5]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("please typing pleas....");
		}
		
		
		//dataReader.path ="C:\\ChatCounter";
		//dataReader.getData(path);

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
			//System.out.println("////////////////"+filename); 
			if(fileName.contains(".txt")==true) {
				//DataReaderForTXTThread2 object1=new DataReaderForTXTThread2(fileName);
				Runnable worker = new DataReaderForTXTThread(fileName);
				executor.execute(worker);
				//DataReaderForTXTThread2 object =new DataReaderForTXTThread2(fileName);			
				
				
				//DataReaderForTXT.readForTxtData(fileName);
			}
			else if(fileName.contains(".csv")==true) {
				//DataReaderForCSVThread object2 =new DataReaderForCSVThread(fileName);
				Runnable worker = new DataReaderForCSVThread(fileName);
				executor.execute(worker);
				//DataReaderForCSV.read(fileName);
				
			}
			
			//System.out.println(file.getAbsolutePath());
		}

		//ChatMessageCounter.chatMessageCount(args[3]);
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {
		
		}

		return dataDir.listFiles();
	}






}


