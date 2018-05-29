package edu.handong.csee.java.HW3.ChatCounter;

import java.util.Comparator;
import java.util.Map;
/**
 *  @version java version "9.0.4"
 *  @author Lee MyeongHui
 *  The declaration of class ValueComparator, Implementing the Interface Comparator
 *  The ValueCompartator class has valueComparator(), compare() methods
 *  The ValueComparator class has bas variable
 */
public class ValueComparator implements Comparator{

	Map<String,Integer> base;
	public ValueComparator(Map<String,Integer> base)
	{
		this.base=base;
	}
	public int compare(String a,String b)
	{
		if(base.get(a)>=base.get(b))
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	@Override
	public int compare(Object a, Object b) {
		// TODO Auto-generated method stub
		if(base.get(a)>=base.get(b))
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
