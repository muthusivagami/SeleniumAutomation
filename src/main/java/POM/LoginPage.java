package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//constructor for login page //Lazy initialization
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement UN;
	
	@FindBy(id="inputPassword")
	private WebElement PW;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginbtn;
	//Generate getters for the webelements
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUN() {
		return UN;
	}

	public WebElement getPW() {
		return PW;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	}
