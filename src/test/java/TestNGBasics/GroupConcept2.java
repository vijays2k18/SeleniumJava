package TestNGBasics;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GroupConcept2 {
	
	@Test
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan From Group 2");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan From Group 2");
	}
	@Test
	public void APILoginHomeLoan() {
		System.out.println("APILoginHomeLoan From Group 2");
	}


}
