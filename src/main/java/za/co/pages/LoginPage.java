package za.co.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import za.co.baseclass.BaseClass;

public class LoginPage extends BaseClass {

    private static By username = By.id("txt-username");
    private static By password = By.id("txt-password");
    private static By loginButton = By.id("btn-login");

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public MakeAppointmentPage loginUser(String theUsername, String thePassword){
        driver.findElement(username).sendKeys(theUsername);
        driver.findElement(password).sendKeys(thePassword);
        driver.findElement(loginButton).click();

        return new MakeAppointmentPage();
    }

}
