package org.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class LandScapeClipboardAndKeyEvent extends BaseTest {

    @Test
    public void Miscellaneous(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
       // driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //LandScape Rotation
        DeviceRotation landscape=new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //SetClipboardText
        driver.setClipboardText("Praveen's Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

        //PressKey
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
