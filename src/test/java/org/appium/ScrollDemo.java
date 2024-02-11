package org.appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void scrollDemoTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        ScrollGesture("WebView");
        Thread.sleep(2000);
    }

}
