package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;

public class ArrayList2 {

	private static ArrayList<String> full =new ArrayList<String>();

	public ArrayList<String> getA() {
		return full;
	}

	public void setA(String message) {
		full.add(message);
	}
	 
}
