package edu.handong.csee.java.HW3.ChatCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ChatMessageCounter {

	public static void chatMessageCount()
	{
		HashMap<String, Integer> result = new HashMap<String,Integer>();
		ValueComparator bvc=new ValueComparator(result);
		TreeMap<String,Integer> sorted_map=new TreeMap<String,Integer>(bvc);
		int arrayListSize=AddToHashMap2.arrayList2.size();
		
		for(int i=0;i<arrayListSize;i++) {
			result.put(AddToHashMap2.arrayList2.get(i).getName(), AddToHashMap2.arrayList2.get(i).getDateMessageList().size());
		}
		sorted_map.putAll(result);
				
		Iterator<String> iterator=result.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key=(String)iterator.next();
			System.out.println("key="+key+"/value="+result.get(key));
		}
		
		 for (Map.Entry<String,Integer> entry : sorted_map.entrySet()) {
	           
	            System.out.println(entry.getKey()+" : "+result.get(entry.getKey()));
	        }

	}
}
