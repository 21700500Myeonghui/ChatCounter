package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
							
				 
				String[] ary =thisLine.split(",");
					
				date=ary[0].replaceAll("[^0-9]", "");
				int size3=date.length();
				date=date.substring(0,size3-2);
				
									
				int size=ary[1].length();
				name=ary[1].substring(1,size-1);
				
				
				//size=ary[2].length();
				message=ary[2];
				
				if(ary.length>3)
				{
					for(int j=3;j<ary.length;j++)
						message+=","+ary[j];
				}
				
				/*String line2=thisLine.substring(0,3);
				if(line2!="2018")
				{
					message+=thisLine;
					int size2=message.length();
					message=message.substring(1,size-1);
					System.out.println(message);
					AddToHashMap.addToHashMap(date,name,message);
					thisLine=br.readLine();

					
					
				}*/
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
				
					AddToHashMap.addToHashMap(date, name, message);
					thisLine=br.readLine();
					
				}
				else {
					message=message.substring(1,size-1);
					
					AddToHashMap.addToHashMap(date,name,message);
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







/*For developers in Windows, you may read files like this with UTF-8 format.
try {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
    while ((thisLine = br.readLine()) != null) { // while loop begins here
       lines.add(thisLine);
       System.out.println(thisLine);
    }
    br.close();
 } catch (IOException e) {
    e.printStackTrace();
 } // end while 
*/