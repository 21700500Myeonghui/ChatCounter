package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

public class ChatMessageCounter {

	public static void chatMessageCount()
	{
		int size=AddToHashMap.arrayList.size();
		String result[][]=new String [size][2];
		
		for(int i=0;i<size;i++)
		{
			result[i][0]=AddToHashMap.arrayList.get(i).getName();
			result[i][1]=AddToHashMap.arrayList.get(i).getHashMapsize();
		}
		
		for(int i=0;i<size;i++)
			{
			for(int j=0;j<2;j++)
				System.out.println(result[i][j]);
		     System.out.println("\n");
			}
		
		
	}
}
