package edu.handong.csee.java.HW3.ChatCounter;

import java.util.HashMap;

public class Add {

	private String name;
	private HashMap<String,String> h=new HashMap<String,String>();
	
	public Add()
	{
		
	}
	public Add(String name, String date, String message)
	{
		this.name=name;
		h.put(date, message);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public HashMap<String,String> getdateMessage()
	{
		return h;
	}
	
	public void setdateMessage(String date, String message)
	{
		h.put(date, message);
	}
	
	public String getHashMapsize()
	{
		return Integer.toString(h.size());
	}
}
