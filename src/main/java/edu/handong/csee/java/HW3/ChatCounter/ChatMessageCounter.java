package edu.handong.csee.java.HW3.ChatCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ChatMessageCounter {

	public static void chatMessageCount()
	{
		HashMap<String, Integer> result = new HashMap<String,Integer>();
		int arrayListSize=AddToHashMap2.arrayList2.size();
		
		for(int i=0;i<arrayListSize;i++) {
			result.put(AddToHashMap2.arrayList2.get(i).getName(), AddToHashMap2.arrayList2.get(i).getDateMessageList().size());
		}
				
		Iterator<String> iterator=result.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key=(String)iterator.next();
			System.out.println("key="+key+"/value="+result.get(key));
		}
		
		
		/*for(int i=0; i<AddToHashMap.arrayList.size(); i++)
		{
			result.put(AddToHashMap.arrayList.get(i).getName(), AddToHashMap.arrayList.get(i).getDateList().size());
		}
		
		Set<String> keys=result.keySet();
		Iterator<String> it=keys.iterator();
		
		while(it.hasNext()) {
			String key=it.next();
			Integer value=result.get(key);
			System.out.println(key+" "+value);
		}*/

	}
}
