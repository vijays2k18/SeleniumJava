package TestNGBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day2 {
	
	
	@BeforeClass
	public void before() {
		System.out.println("Before Class day2");
	}
	
	
	@AfterClass
	public void after() {
		System.out.println("after Class day2");
	}
	
	@Test
	public void demo()
	{
		System.out.println("running demo script and this code come from day2");
	}
	
	@Test
	public void demo1() {
		System.out.println("running demo1 script and this code come from day2");
	}

}
