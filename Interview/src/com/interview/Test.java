package com.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	
	public static void main(String[] args) {
	
		try {
			File file = new File(System.getProperty("user.dir") + "//test.txt");
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String s= "";
			
			//List<String> a1 = new ArrayList<String>();
			Set<String> a1 = new TreeSet<String>(new MyComparator());
			a1.add("nitin");
			a1.add("rahul");
			a1.add("eclipse");
			a1.add("Nitin");
			
			//Collections.sort(a1);
			System.out.println(a1);
			
//			for (int i = 0; i < a1.size(); i++) {
//				if(a1.get(i).equals("eclipse")) {
//					a1.remove(i);
//					break;
//				}
//				System.out.println(a1.get(i));
//			}
			
			HashMap<Integer, String> m = new HashMap<Integer, String>();  
			int counter = 1;
			for (String a : a1) {
				m.put(counter, a);
				counter++;
			}
			
			System.out.println(m);
			
			
//				while((s = bf.readLine()) != null) {
//					System.out.println(s);
//					//System.out.println(a1.contains("nitin"));
//					if(!a1.contains("nitin")) {
//						a1.add(s);
//					}
//					
//					a2.add(s);
//			
//		}
//				//System.out.println(a2);
//				System.out.println(a1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
