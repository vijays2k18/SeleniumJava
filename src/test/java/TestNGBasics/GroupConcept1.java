package TestNGBasics;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GroupConcept1 {
	
	@Test
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan From Group 1");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan From Group 1");
	}
	@Test
	public void APILoginHomeLoan() {
		System.out.println("APILoginHomeLoan From Group 1");
	}


}
