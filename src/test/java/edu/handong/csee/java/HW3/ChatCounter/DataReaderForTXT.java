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
		    System.out.println(line);
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
					System.out.println(date);
					System.out.println(name);
					System.out.println(message);
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
				date=line.replaceAll("[^0-9]", "");
				message=line.substring(j+1);
				System.out.println(date);
				System.out.println(name);
				System.out.println(message);
				AddToHashMap.addToHashMap(date,name,message);
					br.close();
					
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

	private static Path Path(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
