package org.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AppiumDriverLocalService server;
    public AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        server = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Praveen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        server.start();

        UiAutomator2Options ui = new UiAutomator2Options();
        ui.setDeviceName("Pixel7Pro");
        ui.setApp(System.getProperty("user.dir") + "/src/test/resources/utils/General-Store.apk");

        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"), ui);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPress(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    public void SwipeGesture(WebElement element,String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),"direction", direction,
                "percent", 0.75));
    }

    public void DragAndDropGesture(WebElement source,int XCoordinate,int YCoordinate) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", XCoordinate,
                "endY", YCoordinate
        ));
    }

    public void ScrollGesture(String text){
       /* driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));*/
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        //server.stop();
    }
}

