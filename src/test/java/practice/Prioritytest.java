package practice;

import org.testng.annotations.Test;

public class Prioritytest {
	@Test
	public void method1()
	{
		System.out.println("Execute method1");
	}
	
	@Test
	public void method2()
	{
		System.out.println("Execute mehtod2");
		
	}
	
	@Test(priority=-1)
	public void method3()
	{
		System.out.println("Execute method3");
	}

}
