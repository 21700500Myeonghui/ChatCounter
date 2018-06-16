package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReaderForCSVThread implements Runnable {

	String fileName;
	@Override
	public void run() {
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
				String dateMessage="";
							
				 
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
					
					dateMessage=date+message;
					DataReaderForTXTThread.nameList2.add(name);
					DataReaderForTXTThread.dateMessageList2.add(dateMessage);
					
					//AddToHashMap2.addToHashMap2(name, date, message);
					
					thisLine=br.readLine();
					
				}
				else {
					message=message.substring(1,size-1);
					if(message.equals("사진")==true)
						message="Photo";
					
					message=message.replace("\"\"", "\"");
				
					dateMessage=date+message;
					DataReaderForTXTThread.nameList2.add(name);
					DataReaderForTXTThread.dateMessageList2.add(dateMessage);
					//AddToHashMap2.addToHashMap2(name,date,message);
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

	
	public DataReaderForCSVThread(String fileName) {
		this.fileName=fileName;
		//Thread worker =new Thread();
		//worker.run();
		//DataReader.threadList.add(worker);
	}
}
