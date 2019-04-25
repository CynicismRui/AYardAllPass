package com.example.allpass.Query;

import com.example.allpass.function.DeviceUse;
import com.example.allpass.imgcotout.GetCutOut;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodsQuery implements Query {


    @Override
    public void GoodQuery(DeviceUse deviceUse,WebDriver webDriver, By name, By sub, By good_type, String text, String type) {
        GetCutOut getCutOut = new GetCutOut();

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    deviceUse.click(webDriver, sub);

                case 1:

                    deviceUse.pullDownList(webDriver, good_type, type);
                    deviceUse.click(webDriver,sub);
                case 2:

                    deviceUse.sendKeys(webDriver, name, text);
                    deviceUse.pullDownList(webDriver, good_type, type);
                    deviceUse.click(webDriver, sub);
                    webDriver.findElement(name).clear();

                case 3:
                    deviceUse.sendKeys(webDriver, name, text);
                    deviceUse.click(webDriver, sub);
                    webDriver.findElement(name).clear();

            }
            getCutOut.getInto(webDriver);

        }
    }
}
