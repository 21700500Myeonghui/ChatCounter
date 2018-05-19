package edu.handong.csee.java.HW3.ChatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataReaderForTXT {

	public void read(String fileName)
	{
		try {
			Scanner inputStream=new Scanner(new File(fileName));
			
			for(int i=0;i<3;i++)
			{
				inputStream.nextLine();
		    }
		
			
			
			
			inputStream.close();
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}
		
	}
}
