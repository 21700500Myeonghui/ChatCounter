package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

public class Add {

	private String name;
	ArrayList<String> dateList =new ArrayList();
	ArrayList<String> messageList=new ArrayList();
	
	public Add(String name, String date, String message)
	{
		this.name=name;
		dateList.add(date);
		messageList.add(message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getDateList() {
		return dateList;
	}

	public void setDateList(String date) {
		dateList.add(date);
	}

	public ArrayList<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(String message) {
		messageList.add(message);
	}
	

	
}
