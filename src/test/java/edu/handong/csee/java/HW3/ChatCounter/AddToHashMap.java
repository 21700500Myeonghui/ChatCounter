package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;
import java.util.HashMap;

public class AddToHashMap {
	public static ArrayList<Add> arrayList=new ArrayList<Add>();
	
		public static void addToHashMap(String date, String name, String message)
	{
			HashMap<String, String> h2=new HashMap<String,String>();
			String name1;
			int i;
			for( i=0;i<arrayList.size();i++)
			{
				if(arrayList.get(i).getName()==name)
				{
					h2=arrayList.get(i).getdateMessage();
					if(h2.containsKey(date)==true && h2.containsValue(message)==true)
						return;
					else
						arrayList.get(i).setdateMessage(date, message);
				}
			}
			if(i==arrayList.size())
			{
				arrayList.get(i).setName(name);
				arrayList.get(i).setdateMessage(date, message);
				
			}
	}
}