package edu.handong.csee.java.HW3.ChatCounter;

import java.util.ArrayList;
/**This class defines a Add2 object
 * The Add2 class has name, dateMessageList members
 * The Add2 class has Add2(), getName(), setName(), getDateMessageList(), setDateMessageList(), setDateMessageList2() methods
 *  @author Lee MyeongHui
 * @version java version "9.0.4"
 */
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

	public void setDateMessageList2(ArrayList<String> dateMessageList)
	{
		this.dateMessageList=dateMessageList;
	}

}
