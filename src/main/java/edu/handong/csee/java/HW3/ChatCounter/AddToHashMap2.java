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

	public static void addToHashMap2()
	{
		//String dateMessage=date+message;
		int size=0;
		int i=0; 
		int count=0;

      for(int p=0; p<DataReaderForTXTThread.nameList2.size();p++)
      {
    	String name=DataReaderForTXTThread.nameList2.get(p);
    	System.out.print(name);
    	String dateMessage=DataReaderForTXTThread.dateMessageList2.get(p);
    	System.out.println(dateMessage);
    	size=arrayList2.size();
		
    	if(size==0)
		{System.out.println("1");
			arrayList2.add(new Add2(name,dateMessage));
			continue;
		}
		else
		{
			for(i=0;i<size;i++)
			{
				
				if(arrayList2.get(i).getName().contains(name)==true)
				{

					if(arrayList2.get(i).getDateMessageList().contains(dateMessage)==true)
					{System.out.println("2");
						break;
					}
					else
					{ System.out.println("3");
						Add2 temp=new Add2();
						temp=arrayList2.get(i);
					

						temp.getDateMessageList().add(dateMessage);

						arrayList2.add(i, temp);
						
						break;
					}
				}

			    }
			if(i==size)
			{		System.out.println("4");			
				arrayList2.add(new Add2(name,dateMessage));
			    continue;
			}


		}
		}
      
 
    /*  for(int k=0;k< arrayList2.get(7).getDateMessageList().size();k++)
      {
    	  System.out.println(arrayList2.get(7).getName());
    	  System.out.println(arrayList2.get(7).getDateMessageList().get(k));
      }*/
	}
}

