package TestNGBasics;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day4 {
	
	
	@Test
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan");
	}
	
	@Test
	public void MobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan");
	}
	@BeforeSuite
	public void APILoginHomeLoan() {
		System.out.println("APILoginHomeLoan");
	}

}
