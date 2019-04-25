package com.example.allpass.Exit;




import com.example.allpass.function.DeviceUse;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserToExit implements ToExit {


    //exit
    @Override
    public void LoginToExit(WebDriver webDriver) {

        if (new DeviceUse().IsElementPresent(webDriver, By.linkText("安全退出"))) {
            new DeviceUse().click(webDriver,By.linkText("安全退出"));

        } else {

            Assert.fail("--------------------------点击安全退出无效-------------------");
        }


    }
}
