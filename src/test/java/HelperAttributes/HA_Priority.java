package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;
//Header Attribute -HA
//priority decides the order of the execution
//if we give same priority, it will execute in alphabetical order
//least the priority, first the execution
public class HA_Priority {
	@Test(priority=0)
public void amazon() {
		Reporter.log("amazon executed",true);
	}
	@Test(priority=-3)
	public void flipkart() {
		Reporter.log("flipkart executed",true);
		
	}
	@Test(priority=4)
	public void youtube() {
		Reporter.log("youtube executed",true);
	
}
}
