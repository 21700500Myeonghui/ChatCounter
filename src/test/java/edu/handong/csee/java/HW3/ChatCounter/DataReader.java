package edu.handong.csee.java.HW3.ChatCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class DataReader {
	private File[] files;

	private static String path;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
			DataReader dataReader = new DataReader();
			dataReader.path ="C:\\ChatCounter";
		    dataReader.getData(path);
		   
		}
	
    private void getData(String strDir)
	{
    	
    	files=getListOfFilesFromDirectory(getDataDirectory(strDir));
		
	}

    private File getDataDirectory(String strDir)
    {
    	File f=new File(strDir);
    	return f;
    }
    
   private File[] getListOfFilesFromDirectory(File dataDir)
    {
    	for(File file:dataDir.listFiles())
    	{
    		String filename=file.getPath();
    		System.out.println("////////////////"+filename); 
    		if(filename.contains(".txt")==true)
    			DataReaderForTXT.readForTxtData(filename);
    		else if(filename.contains(".csv")==true)
    			 DataReaderForCSV.read(filename);
    		//System.out.println(file.getAbsolutePath());
    	}
    	ChatMessageCounter.chatMessageCount();
    	return dataDir.listFiles();
    }
    
	
	
	

    
    
}
