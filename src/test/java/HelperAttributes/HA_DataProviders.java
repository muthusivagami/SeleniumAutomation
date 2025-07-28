package HelperAttributes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HA_DataProviders {
@Test(dataProvider="logindetails")
public void login(String username,String password)
{
	System.out.println(username+"===="+password);
}

@DataProvider
public Object[][] logindetails(){
	Object[][] objarr=new Object[3][2];
	objarr[0][0]="virat";
	objarr[0][1]="v0123";
	objarr[1][0]="raja";
	objarr[1][1]="rajlkdfjald";
	objarr[2][0]="hang";
	objarr[2][1]="rakldfaf";
	return objarr;
}
}
