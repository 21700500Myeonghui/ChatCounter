package edu.handong.csee.java.HW3.ChatCounter;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReaderForTXT {
	public static String date2="";
	public static void readForTxtData(String fileName)
	{
	
		try {
			 
			BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName), "UTF8"));
		
			String line;
			for(int i=0;i<3;i++)
				line=br.readLine();
		
			line=br.readLine();
			
			while(true)
			{
				String date="";
				String name="";
			    String message="";
				char c=line.charAt(0);
				if(c=='-')
				{
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
					
					
					if(day.equals("오전")==true)			
		     			{
						time2[0]=changeDigit(time2[0]);
		     					    
					}
					
					if(day.equals("오후")==true)
					{
						int ruru=Integer.parseInt(time2[0]);
						if(ruru<12)
						time2[0]=changeDigit2(ruru);
					}
					date=date+time2[0]+time2[1];
					date=date2+date;
					
				message=line.substring(k+2);
				line=br.readLine();
				if(line==null)
					{if(message.equals("사진")==true)
						message="Photo";
					
					AddToHashMap2.addToHashMap2(name,date,message);
					
					return;}
				
				else if((line.charAt(0)!='-')&& (line.charAt(0)!='['))
				{
					message=message+line;
					line=br.readLine();
				}
				
				if(message.equals("사진")==true)
					message="Photo";			
				
				AddToHashMap2.addToHashMap2(name,date,message);
			
				
				}
				if(line==null)
					break;

					
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

	

	
}
