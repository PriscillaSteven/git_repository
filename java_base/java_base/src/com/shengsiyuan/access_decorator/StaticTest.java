package com.shengsiyuan.access_decorator;

import org.junit.Test;

/*
 * 测试将成员变量声明在静态代码块后面对程序编译的影响
 */
public class StaticTest
{
	static
	{
		age = 26;
	}
	
	private static int age;
	
	/*
	 * 非静态方法中可以直接引用静态变量吗？Of Cource!!!但是反过来就不行！！！
	 * 为什么此方法加上"static"修饰符之后，编译通过，但是测试时反而报错呢？
	 * 这是因为，凡是带@Test注解的方法必须必须声明为"public void"!!!
	 */
	@Test
	public static void showAge()
	{
		System.err.println("@Test测试方法执行结果\n我的年龄是： " + age + "岁。");
	}
	
	public static void tellAge()
	{
		System.err.println("普通成员方法测试结果\n我的年龄是： " + age + "岁。");
	}
	
	public static void main(String[] args)
	{
		System.err.println("main方法测试结果\n我的年龄是： " + age + "岁。");
		tellAge();
	}
}
