package com.ict.erp;

public class RefiTest {

	public static void main(String[] args) {
		String classPath = "com.ict.erp.Person";
		
		try {
			Class clazz = Class.forName(classPath);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
