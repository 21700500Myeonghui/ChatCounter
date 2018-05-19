package edu.handong.csee.java.HW3.ChatCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataReader {
	private int date;
	private String name;
	private String message;

	private static String path;

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		try{
			DataReader dataReader = new DataReader();
			dataReader.path ="C:\\ChatCounter";
		    dataReader.getData(path);
		}catch(IOException e)
		{
			System.out.println("error");
		}
		}
	
    private ArrayList<String> getData(String strDir) throws IOException
	{
		File[] files=getListOfFilesFromDirectory(getDataDirectory(strDir));
		ArrayList<String> message=readFiles(files);
		return message;
		
	}

    private File getDataDirectory(String strDir)
    {
    	File f=new File(strDir);
    	return f;
    }
    
    private File[] getListOfFilesFromDirectory (File dataDir)
    {
    	for(File file:dataDir.listFiles())
    	{
    		System.out.println(file.getAbsolutePath());
    	}
    	return dataDir.listFiles();
    }
    
    private ArrayList<String> readFiles(File[] files) throws IOException
    {
    	ArrayList<String> message= new ArrayList<String>();
    	
    	for(int i=0; i<files.length;i++)
    	{
    		Path source=Paths.get(files[i].getPath());
    		message.add(i, Files.probeContentType(source));
    		//System.out.println(message.get(i));
    	}
    	return message;
    }
}
