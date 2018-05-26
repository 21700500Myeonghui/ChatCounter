package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

public class Add2 {
	private String name;
	private ArrayList<String> dateMessageList=new ArrayList<String>();
	
	public Add2(String name, String dateMessage)
	{
		this.name=name;
		dateMessageList.add(dateMessage);
	}

	public Add2()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getDateMessageList() {
		return dateMessageList;
	}

	public void setDateMessageList(String dateMessage) {
		dateMessageList.add(dateMessage);
	}
	
}
