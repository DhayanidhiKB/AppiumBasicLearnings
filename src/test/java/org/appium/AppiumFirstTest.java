package org.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumFirstTest {

    @Test

    public void firstTest() throws MalformedURLException {

        UiAutomator2Options ui=new UiAutomator2Options();
        ui.setDeviceName("Pixel7Pro");
        ui.setApp(System.getProperty("user.dir")+"/src/test/resources/utils/ApiDemos-debug.apk");

        AndroidDriver driver=new AndroidDriver(new URL(" http://127.0.0.1:4723/"),ui);
    }
}
