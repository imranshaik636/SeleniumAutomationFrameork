package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By usernameTexBox = By.id("Email");
	private By passwordTextBox = By.id("Password");
	private By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) { 	
		this.driver = driver;
	}

	public void enterusername(String username) {
		driver.findElement(usernameTexBox).clear();
		driver.findElement(usernameTexBox).sendKeys(username);
	}

	public void enterpassword(String password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void clicklogin() {
		driver.findElement(loginButton).click();
	}
}
