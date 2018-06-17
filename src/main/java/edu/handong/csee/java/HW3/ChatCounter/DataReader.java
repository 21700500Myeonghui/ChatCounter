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
	public static ArrayList<ArrayList<String>> mmm=new ArrayList<ArrayList<String>>();
	ArrayList2 a=new ArrayList2();
	
	
	//DataReaderForTXTThread bbc=new DataReaderForTXTThread();
	//DataReaderForCSVThread csv=new DataReaderForCSVThread();

	ArrayList<ArrayList<String>> finalfinal=new ArrayList<ArrayList<String>>();
	
	public ArrayList2 getA() {
		return a;
	}

	public void setA(ArrayList2 a) {
		this.a = a;
	}

	//private static String path;
	public static ArrayList<String> fullArray=new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException {

		// TODO Auto-generated method stub	
		int coreNum = Integer.parseInt(args[1]);

		CliRunner runner=new CliRunner();
		runner.run(args);
		
		
	    /*ArrayList2 myList=new ArrayList2();
	    
	    ArrayList<String> please=myList.getA();
	    
	    for(int i=0;i<please.size();i++)
	    {
	    	System.out.println(i+" "+please.get(i));
	    }*/
	    
	    
	    
	    

		DataReader dataReader = new DataReader();
		try {
			dataReader.getData(args[3], coreNum);
			
			/*for(int i=0; i<mmm.size();i++)
			{
				ArrayList<String> mmm2=mmm.get(i);
				System.out.println(mmm2);
					/*for(int p=0;p<mmm2.size();p++)
						System.out.println(";;;;;;;;"+mmm2.get(p));
				
				
			}*/
			
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
		
		//ArrayList<ArrayList<String>> middleArrayList =new ArrayList<ArrayList<String>>();
		
		
		
		for(File file:dataDir.listFiles())
		{
			String fileName=file.getPath();
			
			if(fileName.contains(".txt")==true) {
				Runnable worker = new DataReaderForTXTThread(fileName);
				executor.execute(worker);
				
				/*DataReaderForTXTThread object1=new DataReaderForTXTThread();
				mmm.add(executor.));*/
				
			
				
				//DataReaderForTXT.readForTxtData(fileName);
			}
			else if(fileName.contains(".csv")==true) {
				
				Runnable worker = new DataReaderForCSVThread(fileName);
				executor.execute(worker);
				
				/*DataReaderForCSVThread object2=new DataReaderForCSVThread();
				mmm.add(object2.getSmallArray());*/
				//DataReaderForCSV.read(fileName);
				//finalfinal.add(bbc.getSmallArray());
				
			}
			
			
		}
		executor.shutdown();
		
		while(!executor.isTerminated()) {
		
		}

		return dataDir.listFiles();
	}

	public static ArrayList<ArrayList<String>> getMmm() {
		return mmm;
	}

	public static void setMmm(ArrayList<ArrayList<String>> mmm) {
		DataReader.mmm = mmm;
	}






}


