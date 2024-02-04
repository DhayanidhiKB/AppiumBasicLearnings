package org.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;


import java.io.File;
import java.net.URL;

public class AppiumFirstTest {


    @Test
    public void firstTest() throws Exception  {

        AppiumDriverLocalService server=new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Praveen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        server.start();

        /*AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);


        //Start the server with the builder
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service = AppiumDriverLocalService.buildService(builder);
        service.start();*/
        UiAutomator2Options ui=new UiAutomator2Options();
        ui.setDeviceName("Pixel7Pro");
        ui.setApp(System.getProperty("user.dir")+"/src/test/resources/utils/ApiDemos-debug.apk");

        AndroidDriver driver=new AndroidDriver(new URL(" http://127.0.0.1:4723/"),ui);
    }
}
