package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @version java version "9.0.4"
 * @author Lee MyeongHui
 * This class is defined for reading the data in the csv file.
 * The DataReaderFor class has read() method
 */
public class DataReaderForCSV {

	public static void read(String fileName)
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
			
			String thisLine=br.readLine();
			thisLine=br.readLine();
		
			
			while(true)
			{
				String message=null;
				String date=null;
				String name=null;
				String second=null;
							
				 
				String[] ary =thisLine.split(",");
					
				date=ary[0].replaceAll("[^0-9]", "");
				int size3=date.length();
				second=date.substring(size3-2,size3);
				date=date.substring(2,size3-2);
				
									
				int size=ary[1].length();
				name=ary[1].substring(1,size-1);
	
				message=ary[2];
				
				if(ary.length>3)
				{
					for(int j=3;j<ary.length;j++)
						message+=","+ary[j];
				}
				
				
				size=message.length();
				int size2;
				if(message.charAt(size-1)!='"')
				{
					do {
						thisLine=br.readLine();
						message+=thisLine;
						size2=thisLine.length();
					}while(thisLine.charAt(size2-1)!='"');
					size=message.length();
					message=message.substring(1,size-1);
					
					if(message.equals("사진")==true)
						message="Photo";
					
					message=message.replace("\"\"", "\"");
					AddToHashMap2.addToHashMap2(name, date, message);
					
					thisLine=br.readLine();
					
				}
				else {
					message=message.substring(1,size-1);
					if(message.equals("사진")==true)
						message="Photo";
					
					message=message.replace("\"\"", "\"");
				
					AddToHashMap2.addToHashMap2(name,date,message);
					thisLine=br.readLine();
				
					}
				if(thisLine==null)
					break;
			
			}
		
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file"+fileName);
		}
		catch(IOException e)
		{
			System.out.println("error");
		}
		
	}
	

}
