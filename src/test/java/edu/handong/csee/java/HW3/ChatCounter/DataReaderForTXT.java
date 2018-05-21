package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;



public class DataReaderForTXT {


	public static void readForTxtData(String fileName)
	{
	
		try {
			 
			BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName), "UTF8"));
		
			String line;
			for(int i=0;i<3;i++)
			{
				line=br.readLine();
			}
			
			while((line=br.readLine())!=null)
			{
				String date=null;
				String name=null;
			    String message=null;
				char c=line.charAt(0);
				if(c=='-')
				{
					line=line.substring(18);
					if(line.charAt(5)=='월')
						line.replaceFirst(" ", "0");
					if(line.charAt(8)=='일')
						line=line.substring(0,6)+'0'+line.substring(8);
					if(line.charAt(9)=='일'&&line.charAt(7)==' ')
						line=line.substring(0,5)+'0'+line.substring(7);
					
					date=line.replaceAll("[^0-9]", "");
				
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
					
					String rara="";
					int k;
					for(k=0;k<100;k++)
					{if(line.charAt(k)==']')
						break;
					    rara+=line.charAt(k);
					}
					
					String day=rara.substring(0,2);
					String time2[]=rara.split(":");
					time2[0]=time2[0].replaceAll("[^0-9]", "");
					time2[1]=time2[1].replaceAll("[^0-9]", "");
				
					
					if(day=="오전")			
		     			{System.out.println("0");
						time2[0]=changeDigit(time2[0]);
					    System.out.println(time2[0]);
					}
					
					if(day=="오후")
					{
						int ruru=Integer.parseInt(day);
						if(ruru<10)
							time2[0]=changeDigit(time2[0]);
					}
				
					
					
					
					/*if(line.charAt(4)==':')
						line.replaceFirst(" ", "0");
						//line=line.substring(0)+"0"+line.substring(3);
					if(line.charAt(6)==']')
						line.replaceFirst(":", "0");
						//line=line.substring(0,4)+"0"+line.substring(5);
					if(line.charAt(5)==':'&&line.charAt(7)==']')
						line.replaceFirst(":", "0");
						//line=line.substring(0,4)+"0"+line.substring(6);
					
					*/
					/*if(line.contains("오전 12")==true)
					{	line=line.replaceFirst("12", "00");
					System.out.println("ture"+line);
					}*/
					
					
					
					/*
					 * if(line.charAt(4)==':'&&line.charAt(7)==']')
				
					{
						
						/* char x=line.charAt(3);
						String change=changeDigit(x);
						line.replaceFirst(Character.toString(x), change);
					}
					*/
				
				
				/*int j;
				for(j=0;j<100;j++)
				{
					if(line.charAt(j)==']')
						break;
				}
				String line2=line;
				line=line.substring(0,j);
				date=day+time2[0]+time2[1];
				date=line.replaceAll("[^0-9]", "");*/
					
				message=line.substring(k+2);
				System.out.println(message);
			
				
				}
				
				//AddToHashMap.addToHashMap(date,name,message);
				
					
			}
			
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

	/*private static Path Path(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}*/
	private static String changeDigit(String x)
	{
		System.out.println(x);
		String y2="";
		int y=Integer.parseInt(x);
		y=y+12;
		if(y==24)
			y2="00";
		
		return Integer.toString(y);
		
		
	}
	

	
}
