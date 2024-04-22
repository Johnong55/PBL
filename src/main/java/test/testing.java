package test;

import java.util.ArrayList;
import java.util.List;

public class testing {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("123");
		a.set(0, "huhu");
		for(String i : a)
		{
			System.out.println(i);
		}
	}
}
