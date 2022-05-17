package za.co.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import za.co.baseclass.BaseClass;

public class AppointmentConfirmationPage extends BaseClass {

    private static By facilityId = By.id("facility");

    public AppointmentConfirmationPage(){
        PageFactory.initElements(driver,this);
    }

    public static String returnFacilityName(){
        return driver.findElement(facilityId).getText();
    }
}
