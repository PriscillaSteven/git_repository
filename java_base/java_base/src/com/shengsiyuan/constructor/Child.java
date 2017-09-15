package com.shengsiyuan.constructor;

/*
 * 测试父类如果不存在空参构造将对子类造成什么影响
 */
class Parent
{
	private String name;
	private int age;
	
	//必须提供空参构造
	public Parent()
	{
		
	}
	
	public Parent(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
}

public class Child extends Parent
{
	private String name;
	private int age;
	private String password;
	
	public Child(String name,int age,String password)
	{
		this.name = name;
		this.age = age;
		this.password = password;
		System.out.println("hello world!");
	}
	
	public void fuck()
	{
		System.out.println("测试constructor");
	}
	
	public static void main(String[] args)
	{
		Child child = new Child("hello",21,"123");
		child.fuck();
	}
}

