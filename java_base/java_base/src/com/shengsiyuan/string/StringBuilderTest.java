package com.shengsiyuan.string;

import org.junit.Test;

public class StringBuilderTest
{
	/*
	 * 经测试：在jdk1.5之前和jdk1.5之后得到的结果都一致，且与代码的执行顺序无关！
	 */
	@Test
	public void testStringBuilder()
	{
		String s1 = new StringBuilder("go").append("od").toString();
		System.out.println(s1.intern() == s1);//true
		
		System.out.println("====================================");
		
		String s2 = new StringBuilder("ja").append("va").toString();
//		String s = new String("java");
		String s = new String("helloworld");
		System.out.println(s.intern() == s);//false
		
		System.out.println("====================================");
		
		String s3 = new StringBuilder("hello").append("world").toString();
		System.out.println(s3.intern() == s3);
	}
	
	
	@Test
	public void testStringIntern()
	{
		String hello = "Hello", lo = "lo";
		System.out.print((hello == "Hello") + " ");//true
		System.out.print((Other.hello == hello) + " ");//true
		System.out.print((other.Other.hello == hello) + " ");//true
		System.out.print((hello == ("Hel"+"lo")) + " ");//true
		System.out.print((hello == ("Hel"+lo)) + " ");//false
		System.out.println(hello == ("Hel"+lo).intern());//true
	}
	
	@Test
	public void testString()
	{
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
	}
}

class Other
{
	static String hello = "Hello"; 
}
