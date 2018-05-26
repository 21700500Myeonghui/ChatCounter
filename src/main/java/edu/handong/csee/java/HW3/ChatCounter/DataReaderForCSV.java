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

	public static String name3="";//
	public static String date3="";//
	public static String message3="";//
	public static String second3="";//
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
				//System.out.println("s"+second);
				date=date.substring(2,size3-2);
				
									
				int size=ary[1].length();
				name=ary[1].substring(1,size-1);
	
				
				
				//size=ary[2].length();
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
					
					if(name3.contains(name)==true&&message3.contains(message)==true&&date3.contains(date)==true&&second3.contains(second)==false)
					{
						System.out.println("22222");
						extraAdd(name,date,message);
					}
					
					
			        System.out.println(date+","+name+","+message);
					AddToHashMap2.addToHashMap2(name, date, message);
				
					date3=date;//
					second3=second;//
					message3=message;//
					name3=name;//
					
					thisLine=br.readLine();
					
				}
				else {
					message=message.substring(1,size-1);
					if(name3.contains(name)==true&&message3.contains(message)==true&&date3.contains(date)==true&&second3.contains(second)==false)
					{
						extraAdd(name,date,message);
						
					}
					System.out.println(date+","+name+","+message);
					AddToHashMap2.addToHashMap2(name,date,message);
					date3=date;//
					second3=second;//
					message3=message;//
					name3=name;//
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
	
	private static void extraAdd(String name, String date, String message)
	{
		String dateMessage=date+message;
		for(int i=0;i<AddToHashMap2.arrayList2.size();i++)
		{
			if(AddToHashMap2.arrayList2.get(i).getName().contains(name)==true)
			{
				Add2 temp=new Add2();
				temp=AddToHashMap2.arrayList2.get(i);
				
				temp.getDateMessageList().add(dateMessage);
			
				AddToHashMap2.arrayList2.add(i, temp);
				System.out.println(AddToHashMap2.arrayList2.get(i).getDateMessageList().size());
				return;
			}
		}
		return;
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