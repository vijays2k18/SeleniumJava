package TestNGBasics;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day1 {
	
	@Test
	public void demo()
	{
		System.out.println("running demo script and this code come from day1");
	}
	
	@Test
	public void demo1() {
		System.out.println("running demo1 script and this code come from day1");
	}
	
	@BeforeMethod
	public void run() {
		System.out.println("I run Every Method before for day 1 class");
	}

}
