package practice;

import org.testng.annotations.Test;

public class Dependsonmethodtest {
	@Test
	public void method1()
	{
		System.out.println("login");
		int arr[]= {1,2,3};
		System.out.println(arr[5]);
	}
	@Test(dependsOnMethods="method1")
	public void  method2()
	{
		System.out.println("Createorg");
	}
	@Test(dependsOnMethods="method2")
	public void method3()
	{
		System.out.println("logout");
	}

}
