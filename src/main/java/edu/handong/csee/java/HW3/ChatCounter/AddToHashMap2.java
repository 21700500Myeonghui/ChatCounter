package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;
/**
 * This class is defined to add the name and date and message to the hash map.
 * The AddToHashMap2 has addToHashMap2() public static methods
 * The AddToHashMap2 has arrayList2 public static ArrayList<Add2>
 * @version java version "9.0.4"
 * @author Lee MyeongHui
 *
 */
public class AddToHashMap2 {

	/**
	 * This ArrayList type is class Add2
	 * its modifier is static and public
	 */
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
		}
		else
		{
			for(i=0;i<size;i++)
			{

				if(arrayList2.get(i).getName().contains(name)==true)
				{

					if(arrayList2.get(i).getDateMessageList().contains(dateMessage)==true)
					{
						return;}
					else
					{ 
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
			return;
			}


		}
	}
}

