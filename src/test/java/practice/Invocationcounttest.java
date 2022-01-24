package practice;

import org.testng.annotations.Test;

public class Invocationcounttest {
	@Test(invocationCount=4)
	public void invocmethod1()
	{
		System.out.println("hello world");
	}

}
