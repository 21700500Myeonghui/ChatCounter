package edu.handong.csee.java.HW3.ChatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReaderForTXT {


	public static void readForTxtData(String fileName)
	{
	   String date=null;
	   String name=null;
	   String message=null;

		try {
			Scanner inputStream=new Scanner(new File(fileName));
			
			for(int i=0;i<3;i++)
			{
				inputStream.nextLine();
		    }
			
			while(inputStream.hasNextLine())
			{
				String line=inputStream.nextLine();
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
					
					date=patternMatching(line,date);
				}
				else if(c=='[')
				{
					for(int i=1;i<100;i++)
					{
						if(line.charAt(i)==']')
							break;
						name+=line.charAt(i);
					}
					
					
					line=line.substring(4);
					if(line.charAt(4)==':')
						line=line.substring(0)+"0"+line.substring(3);
					if(line.charAt(6)==']')
						line=line.substring(0,4)+"0"+line.substring(5);
					if(line.charAt(5)==':'&&line.charAt(7)==']')
						line=line.substring(0,4)+"0"+line.substring(6);
					if(line.compareTo("오전 12")==0)
						line.replaceFirst("12", "00");
				}
				int j;
				for(j=0;j<100;j++)
				{
					if(line.charAt(j)==']')
						break;
				}
				line=line.substring(0,j);
				date=patternMatching(line,date);
				message=line.substring(j+1);
				AddToHashMap.addToHashMap(date,name,message);
					
			}
			
		
		
			
			
			
			inputStream.close();
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}
		
	}
	

	public static String patternMatching(String line,String date)
	{
		Pattern p=Pattern.compile("(^[0-9]*$)");
		Matcher m= p.matcher(line);
		if(m.find())
			date=date+line;
		return date;
	}
}
