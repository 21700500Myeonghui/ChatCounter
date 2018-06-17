package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * @version java version "9.0.4"
 * @author MyeongHui Lee
 * This class was defined to read the csv file with thread.
 * The class has smallArray arrayList, fileName variable.
 * The class has getSmallArray(), setSmallArray(), run(), DataReaderForCSVThread () methods
 *
 */
public class DataReaderForCSVThread implements Runnable {

	ArrayList<String> smallArray=new ArrayList<String>();


	String fileName;

	public ArrayList<String> getSmallArray() {
		return smallArray;
	}

	public void setSmallArray(ArrayList<String> smallArray) {
		this.smallArray = smallArray;
	}



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

	public DataReaderForCSVThread ()
	{

	}

	public DataReaderForCSVThread(String fileName) {
		this.fileName=fileName;

	}
}
