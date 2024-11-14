package TestNGBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class day3 {
	// note TestNG run Methods in Alphabetical Order
	@Test
	public void WebLoginCarLoan() {
		System.out.println("WebLoginCarLoan");
	}
	
	@Test
	public void MobileLoginCarLoan() {
		System.out.println("MobileLoginCarLoan");
	}
	@AfterSuite
	public void APILoginCarLoan() {
		System.out.println("APILoginCarLoan");
	}

}
