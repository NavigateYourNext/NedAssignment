package za.co.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import za.co.baseclass.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeAppointmentPage extends BaseClass {

    private static By facilityDropdownList = By.id("combo_facility");
    private static By applyForAddmissionOption = By.id("chk_hospotal_readmission");
    private static By noneRadioBox = By.id("radio_program_none");
    private static By dateTextBox = By.id("txt_visit_date");
    private static By commentBox = By.id("txt_comment");
    private static By bookAppointmentButton = By.id("btn-book-appointment");

    public MakeAppointmentPage() {
        PageFactory.initElements(driver, this);
    }

    public AppointmentConfirmationPage fillAppointmentForm(String facilityCenter, String comment) {
        Select theSelect = new Select(driver.findElement(facilityDropdownList));
        theSelect.selectByVisibleText(facilityCenter);
        driver.findElement(applyForAddmissionOption).click();
        driver.findElement(noneRadioBox).click();
        driver.findElement(dateTextBox).sendKeys(getTodaysDate());
        driver.findElement(commentBox).sendKeys(comment);
        driver.findElement(bookAppointmentButton).click();

        return new AppointmentConfirmationPage();
    }

    private static String getTodaysDate() {
        String todaysDate = "";
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            todaysDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todaysDate;
    }
}