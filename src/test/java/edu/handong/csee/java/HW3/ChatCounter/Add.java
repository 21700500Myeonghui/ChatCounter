package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

public class Add {

	private String name;
	private ArrayList<String> dateList =new ArrayList<String>();
	private ArrayList<String> messageList=new ArrayList<String>();
	
	public Add() {
		
	}
	public void setDateList2(ArrayList<String> dateList) {
		this.dateList = dateList;
	}
	public Add(String name, String date, String message)
	{
		this.name=name;
		dateList.add(date);
		messageList.add(message);
	}
	public Add(String date, String message)
	{
	
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
