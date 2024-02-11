package org.appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EcommerceApp_TC01 extends BaseTest {

    @Test
    public void FillForm(){

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Harmanpreet Kaur");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        ScrollGesture("India");
        driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
}
