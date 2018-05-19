package edu.handong.csee.java.HW3.ChatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReaderForCSV {

	public void read(String fileName)
	{
		try {
			Scanner inputStream= new Scanner(new File(fileName));
			String line= inputStream.nextLine();
			
			while(inputStream.hasNextLine())
			{
				line=inputStream.nextLine();
				String[] ary =line.split(",");
				
				Pattern p =Pattern.compile("^[0-9]*$");
				Matcher m= p.matcher(ary[0]);
				
				if(m.find())
				{
					date=Integer.parseInt(ary[0]);
				}
				name=ary[1];
				message=ary[2];
				addtoHashMap();
			}
			inputStream.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file"+fileName);
		}
	}
}
