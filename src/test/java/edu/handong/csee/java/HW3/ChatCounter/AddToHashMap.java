package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

import java.util.HashMap;

public class AddToHashMap {
	public static ArrayList<Add> arrayList=new ArrayList<Add>();
	
	public static void addToHashMap(String name, String date, String message) {
		int size=arrayList.size();
		ArrayList<Integer> iList= new ArrayList<Integer>();
		
		if(size==0)
			arrayList.add(new Add(name, date, message));
		else
		{
			for(int i=0;i<size;i++)
			{
				if(arrayList.get(i).getName()==name)
				{
					for(int j=0;j<arrayList.get(i).getDateList().size();j++)
					{
						if(arrayList.get(i).getDateList().get(j)==date)
							iList.add(j);
					}
					if(iList.size()==0)
					{Add temp=new Add();
				    temp=arrayList.get(i);
					temp.setDateList(date);
					temp.setMessageList(message);
					arrayList.add(i, temp);
					return;
				    }
					else {
						if(arrayList.get(i).getMessageList().contains(message)==true)
							return;
						else {Add temp=new Add();
						temp=arrayList.get(i);
						temp.setDateList(date);
						temp.setMessageList(message);
						arrayList.add(i, temp);
						return;
					   }
			          }
		           }
				if(i==size-1)
				{	arrayList.add(new Add(name, date, message));
				    return;
				}
			}
		}
	}
	private static Add clone(Add object)
	{
		Add temp=new Add();
		temp.setName(object.getName());
		for(int a=0;a<object.getDateList().size();a++)
		{
			temp.setDateList(object.getDateList().get(a));
			temp.setDateList(object.getMessageList().get(a));
		}
		return temp;
	}
}

	
	
	
	/*public static ArrayList<Add> arrayList=new ArrayList<Add>();
	
		/*public static void addToHashMap(String name, String date, String message)
	{
			
			Object[] objectList=arrayList.toArray();
			int size=arrayList.size();
			ArrayList<Integer> iList=new ArrayList<Integer>();
			int arrayListSize3=arrayList.size();
			//int arrayListSize=arrayList.size();
			int count=0;
			int count2=0;
			int i=0;
			
			if(size==0)
				{
				arrayList.add(new Add(name, date, message));
				
				int arrayListSize=arrayList.size();
				
				for(int p=0;p<arrayListSize;p++) {
					System.out.println("name:"+arrayList.get(i).getName()+"date"+arrayList.get(i).getDateList().size()+"message"+arrayList.get(i).getMessageList().size());
				}
				
				
				return;
				}
			else
			{
				for(i=0;i<size;i++)
				{
					System.out.println(arrayList.get(i).getName());
					if(arrayList.get(i).getName()==name)//만약 같은 이름이 있으면
					{
						ArrayList<String> dateList=new ArrayList<String>();//(((Add) objectList[i]).getDateList()).toArray();
						for(int q=0;q<arrayList.get(i).getDateList().size();q++)
						dateList.add(arrayList.get(i).getDateList().get(q));
						int dateListSize=dateList.size();
						for(int j=0;j<dateListSize;j++)
							if(dateList.get(j)==date)
								iList.add(j);										
					
					if(iList.size()==0)
					{
						Add temp=new Add();
						temp=arrayList.get(i);
						temp.setDateList(date);
						temp.setMessageList(message);
						arrayList.add(i, temp);
						//arrayList.add(i,new Add(date, message));
						//arrayList.get(i).setDateList(date);
						//arrayList.get(i).setMessageList(message);
						return;
						
						//int arrayListSize2=arrayList.size();
						
						/*for(int p=0;p<arrayListSize3;p++) {
							System.out.println("name:"+arrayList.get(i).getName()+"date"+arrayList.get(i).getDateList().size()+"message"+arrayList.get(i).getMessageList().size());
						}
						*/
						
						//return;
					/*}
					/*else
					{ArrayList<String> messageList=new ArrayList<String>();//(((Add) objectList[i]).getDateList()).toArray();
					for(int q=0;q<arrayList.get(i).getMessageList().size();q++)
					messageList.add(arrayList.get(i).getMessageList().get(q));
						//ArrayList<String> messageList=((Add) objectList[i]).getDateList();
						for(int k=0;k<iList.size();k++)
							if(messageList.get(iList.get(k))!=message)
									count++;			
						if(count==iList.size())
						{Add temp=new Add();
						temp=arrayList.get(i);
						
						temp.setMessageList(message);
						arrayList.add(i, temp);
							//arrayList.get(i).setDateList(date);
							//arrayList.get(i).setMessageList(message);
							
							int arrayListSize=arrayList.size();
							
							for(int p=0;p<arrayListSize;p++) {
								System.out.println("name:"+arrayList.get(i).getName()+"date"+arrayList.get(i).getDateList().size()+"message"+arrayList.get(i).getMessageList().size());
							}
							
							
							
							return;
						}
					
						else
						{
							int arrayListSize=arrayList.size();
							
							for(int p=0;p<arrayListSize;p++) {
								System.out.println("name:"+arrayList.get(i).getName()+"date"+arrayList.get(i).getDateList().size()+"message"+arrayList.get(i).getMessageList().size());
							}
							
							
							
							return;}
					}
					}
					/*if(i==size-1)
					{	arrayList.add(new Add(name, date, message));
					    return;
					}*/
						
				/*}
				if(i==size)
				{	arrayList.add(new Add(name, date, message));
				    return;
				}
			}
			
			
			/*int i			for( i=0;i<arrayList.size();i++)
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
			}*/

