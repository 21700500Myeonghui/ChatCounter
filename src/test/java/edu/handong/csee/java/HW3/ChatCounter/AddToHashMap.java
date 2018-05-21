package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;
import java.util.HashMap;

public class AddToHashMap {
	public static ArrayList<Add> arrayList=new ArrayList<Add>();
	
		public static void addToHashMap(String date, String name, String message)
	{
			int i;
			for( i=0;i<arrayList.size();i++)
			{
				if(arrayList.get(i).getName()==name)
				{
					if(arrayList.get(i).getDateList().contains(date)==true && arrayList.get(i).getMessageList().contains(message)==true)
						return;
					else
						{arrayList.get(i).setDateList(date);
						arrayList.get(i).setMessageList(message);
						return;
						}
						}
					
					
				}
			
			if(i==arrayList.size())
			{
				arrayList.add(new Add(name,date,message));
				return;
			}
	}
}