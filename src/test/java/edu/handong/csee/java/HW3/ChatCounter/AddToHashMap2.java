package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

public class AddToHashMap2 {

	public static ArrayList<Add2> arrayList2=new ArrayList<Add2>();
	
	public static void addToHashMap2(String name, String date, String message)
	{
		String dateMessage=date+message;
		int size=arrayList2.size();
		int i=0;
		int count=0;
		
		
		
		
		if(size==0)
			{
			arrayList2.add(new Add2(name,dateMessage));
			System.out.println("1");
			}
		else
		{
			System.out.println("2");
			for(i=0;i<size;i++)
			{
			
				if(arrayList2.get(i).getName().contains(name)==true)
				{

					if(arrayList2.get(i).getDateMessageList().contains(dateMessage)==true)
						{System.out.println("3");
						return;}
					else
					{ System.out.println("5");
						Add2 temp=new Add2();
						temp=arrayList2.get(i);
						
						temp.getDateMessageList().add(dateMessage);
					
						arrayList2.add(i, temp);
						return;
					}
				}
				
			}
				if(i==size)
				{		arrayList2.add(new Add2(name,dateMessage));
				System.out.println("4");
				return;
				}
		
			
		}
	}
	}

