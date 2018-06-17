package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataReaderForCSVThread implements Runnable {

	ArrayList<String> smallArray=new ArrayList<String>();
	public static ArrayList<String> fullArray=new ArrayList<String>();
	//private ArrayList<String> smallArray=new ArrayList<String>();
	//ArrayList2 arrayList=new ArrayList2();
	String fileName;
	
	public ArrayList<String> getSmallArray() {
		return smallArray;
	}

	public void setSmallArray(ArrayList<String> smallArray) {
		this.smallArray = smallArray;
	}

	ArrayList2 finalList=new ArrayList2();
	
	
	@Override
	public void run() {
	 //ArrayList<String> smallArray=new ArrayList<String>();
		
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
					message=message.trim();
					
					dateMessage=name+','+date+message;
					smallArray.add(dateMessage);
					
					//finalList.getA().add(dateMessage);
					//arrayList.getA().add(dateMessage);
					//DataReaderForTXTThread.nameList2.add(dateMessage);
					
					//dateMessage=date+message;
					//DataReaderForTXTThread.nameList2.add(name);
					//DataReaderForTXTThread.dateMessageList2.add(dateMessage);
					
					//AddToHashMap2.addToHashMap2(name, date, message);
					
					thisLine=br.readLine();
					
				}
				else {
					message=message.substring(1,size-1);
					if(message.equals("사진")==true)
						message="Photo";
					
					message=message.replace("\"\"", "\"");
					message=message.trim();
					
					dateMessage=name+','+date+message;
					smallArray.add(dateMessage);
					//finalList.getA().add(dateMessage);
					
					//arrayList.getA().add(dateMessage);
					//ArrayList2.
					//DataReaderForTXTThread.nameList2.add(dateMessage);
				
					//dateMessage=date+message;
					//DataReaderForTXTThread.nameList2.add(name);
					//DataReaderForTXTThread.dateMessageList2.add(dateMessage);
					//AddToHashMap2.addToHashMap2(name,date,message);
					thisLine=br.readLine();
				
					}
				if(thisLine==null)
					break;
			
			}
			/*for(int k=0;k<smallArray.size();k++)
			{

			      fullArray.add(smallArray.get(k));
				//System.out.println(fullArray.get(k));
			}*/
		
		//fullArray.addAll(smallArray);
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

	public DataReaderForCSVThread ()
	{
		
	}
	
	public DataReaderForCSVThread(String fileName) {
		this.fileName=fileName;
		//Thread worker =new Thread();
		//worker.run();
		//DataReader.threadList.add(worker);
	}
}
