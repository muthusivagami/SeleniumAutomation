package HelperAttributes;

import org.testng.annotations.Test;
import org.testng.Reporter;
//If enabled is false, it will skip the particular testcase

public class HA_Enabled {
@Test
public void a1() {
	Reporter.log("a1 done",true);
}
@Test(enabled=false)
public void a2() {
	Reporter.log("a2 done",true);
}

@Test
public void a3() {
	Reporter.log("a3 done",true);
}
}

