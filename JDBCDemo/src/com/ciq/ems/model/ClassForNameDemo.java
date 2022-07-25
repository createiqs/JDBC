package com.ciq.ems.model;

public class ClassForNameDemo {

	{
		System.out.println("block is called");

	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		ClassForNameDemo demo=new ClassForNameDemo();
		Class.forName("com.ciq.ems.model.ClassForNameDemo").newInstance();
		
	}

}
