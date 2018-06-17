package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataReaderForTXTThread implements Runnable {
	ArrayList2 fianlList=new ArrayList2();
	
	ArrayList<String> smallArray=new ArrayList<String>();
	public static ArrayList<String> nameList2=new ArrayList<String>();
	public static ArrayList<String> dateMessageList2=new ArrayList<String>();
	public static String date2="";
	String fileName;
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		

		try {

			BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName), "UTF8"));

			String line;
			for(int i=0;i<3;i++)
				line=br.readLine();

			line=br.readLine();

			while(true)
			{   int k=0;
			String date="";
			String name="";
			String message="";
			String dateMessage="";
			char c=line.charAt(0);
			if(c=='-')
			{char b=line.charAt(17);
			if(b=='0') {
				line=line.substring(18);
				if(line.charAt(5)=='월')
					line=line.replaceFirst(" ", "0");
				if(line.charAt(8)=='일')
					line=line.replaceFirst(" ", "0");
				if(line.charAt(9)=='일'&&line.charAt(7)==' ')
					line=line.substring(0,6)+"0"+line.substring(8);

				date=line.replaceAll("[^0-9]", "");
				date2=date;
				line=br.readLine();
			}
			else
			{
				String[] ary=line.split(",");
				String month=changeToMonth(ary[1]);
				String year=ary[2].replaceAll("[^0-9]", "");
				String day=ary[1].replaceAll("[^0-9]", "");
				if(day.length()==1)
					day=changeDigit(day);
				date=year+month+day;
				date2=date;
				line=br.readLine();
			}

			}


			else if(c=='[')
			{
				int i;
				for( i=1;i<100;i++)
				{
					if(line.charAt(i)==']')
						break;
					name+=line.charAt(i);
				}

				line=line.substring(i+3);

				if(line.charAt(0)=='오') {

					String raRa="";
					//int k;
					for(k=0;k<100;k++)
					{if(line.charAt(k)==']')
						break;
					raRa+=line.charAt(k);
					}

					String day=raRa.substring(0,2);
					String time2[]=raRa.split(":");
					time2[0]=time2[0].replaceAll("[^0-9]", "");
					time2[1]=time2[1].replaceAll("[^0-9]", "");


					if(day.equals("오전")==true)			
					{
						time2[0]=changeDigit(time2[0]);

					}

					if(day.equals("오후")==true)
					{
						int ruRu=Integer.parseInt(time2[0]);
						if(ruRu<12)
							time2[0]=changeDigit2(ruRu);
					}
					date=date+time2[0]+time2[1];
					date=date2+date;}
				else {
					String cuCu="";
					for(k=0;k<100;k++)
					{
						if(line.charAt(k)==']')
							break;
						cuCu+=line.charAt(k);

					}
					String[] ar=cuCu.split(":");
					String[] ar2=ar[1].split(" ");
					if(ar2[1].equals("AM")==true)
						ar[0]=changeDigit(ar[0]);
					else
					{
						int ruRu=Integer.parseInt(ar[0]);
						if(ruRu<12)
							ar[0]=changeDigit2(ruRu);

					}
					date=date+ar[0]+ar2[0];
					date=date2+date;

				}

				message=line.substring(k+2);
				line=br.readLine();
				if(line==null)
				{if(message.equals("사진")==true)
					message="Photo";
				
				dateMessage=name+','+date+message;
				smallArray.add(dateMessage);
				
				
				//fianlList.getA().add(dateMessage);
				//arrayList.getA().add(dateMessage);
				//nameList2.add(dateMessage);
				//nameList2.add(name);
				//dateMessageList2.add(dateMessage);
				
				//AddToHashMap2.addToHashMap2(name,date,message);

				return;}

				else if((line.charAt(0)!='-')&& (line.charAt(0)!='['))
				{
					message=message+line;
					line=br.readLine();
				}

				if(message.equals("사진")==true)
					message="Photo";			
				dateMessage=name+','+date+message;
				smallArray.add(dateMessage);
				
			     //fianlList.getA().add(dateMessage);
				//arrayList.getA().add(dateMessage);
				//nameList2.add(dateMessage);
				
				//System.out.println(name);
				
				//nameList2.add(name);
				//dateMessageList2.add(dateMessage);
				
				//AddToHashMap2.addToHashMap2(name,date,message);


			}
			if(line==null)
				break;


			}
			/*for(int k=0;k<smallArray.size();k++)
			{

				DataReaderForCSVThread.fullArray.add(smallArray.get(k));
				//System.out.println(fullArray.get(k));
			}
		*/

		}catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("error");
		}

	}

	public ArrayList<String> getSmallArray() {
		return smallArray;
	}

	public void setSmallArray(ArrayList<String> smallArray) {
		this.smallArray = smallArray;
	}

	private static String changeDigit(String x)
	{
		if(x.length()==1)
			x="0"+x;
		if(x.equals("12")==true)
			x="00";
		return x;
	}
	private static String changeDigit2(int x)
	{

		x+=12;

		return Integer.toString(x);


	}

	private static String changeToMonth(String month)
	{
		if(month.contains("January"))
			return "01";
		else if(month.contains("February"))
			return "02";
		else if(month.contains("March"))
			return "03";
		else if(month.contains("April"))
			return "04";
		else if(month.contains("May"))
			return "05";
		else if(month.contains("June"))
			return "06";
		else if(month.contains("July"))
			return "07";
		else if(month.contains("August"))
			return "08";
		else if(month.contains("September"))
			return "09";
		else if(month.contains("October"))
			return "10";
		else if(month.contains("November"))
			return "11";
		else
			return "12";
	}
 


	public DataReaderForTXTThread()
	{
		
	}

	public DataReaderForTXTThread(String fileName) {
		this.fileName=fileName;
		//Thread worker =new Thread();
		//worker.run();
		//DataReader.threadList.add(worker);
	}
}
