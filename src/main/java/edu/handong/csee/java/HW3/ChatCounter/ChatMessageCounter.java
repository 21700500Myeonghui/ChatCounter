package edu.handong.csee.java.HW3.ChatCounter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * @version java version "9.0.4"
 * @author Lee MyeongHui
 * This class is defined to count the number of messages.
 * 
 */
public class ChatMessageCounter {

	public static void chatMessageCount(String args)
	{
		try{
			BufferedWriter fw=new BufferedWriter(new FileWriter(args)); 

			HashMap<String, Integer> result = new HashMap<String,Integer>();
			ValueComparator bvc=new ValueComparator(result);
			TreeMap<String,Integer> sorted_Map=new TreeMap<String,Integer>(bvc);
			int arrayListSize=AddToHashMap2.arrayList2.size();
			System.out.println("file make!");

			for(int i=0;i<arrayListSize;i++) {
				result.put(AddToHashMap2.arrayList2.get(i).getName(), AddToHashMap2.arrayList2.get(i).getDateMessageList().size());
			}
			sorted_Map.putAll(result);

			Iterator<String> iterator=result.keySet().iterator();

			while(iterator.hasNext()) {
				String key=(String)iterator.next();
				//System.out.println("key="+key+"/value="+result.get(key));
			}

			for (Map.Entry<String,Integer> entry : sorted_Map.entrySet()) {

				fw.write(entry.getKey()+","+result.get(entry.getKey())+"\n");
				 System.out.println(entry.getKey()+","+result.get(entry.getKey())+"\n");
			}

			fw.close();
		}catch(Exception e)
		{
			System.out.println("can't make file"); 
		}


	}
}
