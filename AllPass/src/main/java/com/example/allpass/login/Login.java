package com.example.allpass.login;


import com.example.allpass.function.DeviceUse;
import com.example.allpass.imgcotout.GetCutOut;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Login implements LoginInterface {

    @Override
    public void LoginID(WebDriver webDriver) throws InterruptedException {
        if (getDeviceUse().IsElementPresent(webDriver, By.xpath("//*[@id=\"exampleInputName2\"]"))) {
            //输入关键字搜索
            WebElement userBox = webDriver.findElement(By.xpath("//*[@id=\"exampleInputName2\"]"));
            WebElement passBox = webDriver.findElement(By.xpath("//*[@id=\"exampleInputPassword3\"]"));

            if (userBox.getText().isEmpty()) {

                getDeviceUse().click(webDriver, By.className("login-btn"));

                Thread.sleep(3000);
                //截图
                getCutOut().getInto(webDriver);
                System.out.println("---------账号为空---------");

                getDeviceUse().click(webDriver, By.className("zeromodal-close"));

            }
            if (passBox.getText().isEmpty()) {

                userBox.sendKeys("zhang");


                getDeviceUse().click(webDriver, By.className("login-btn"));
                System.out.println("---------密码为空---------");

                Thread.sleep(5000);

                //截图
                getCutOut().getInto(webDriver);

                getDeviceUse().click(webDriver, By.className("zeromodal-close"));

                userBox.clear();
            }
            if (userBox.isEnabled() && passBox.isEnabled()) {

                Actions actions = new Actions(webDriver);
                actions.moveToElement(userBox);
                actions.click();
                userBox.sendKeys("zhang");

                Thread.sleep(1000);

                actions.moveToElement(passBox);
                actions.click();
                passBox.sendKeys("654321");
                String currentUrl = webDriver.getCurrentUrl();

                Thread.sleep(1000);

                getDeviceUse().click(webDriver, By.className("login-btn"));

                System.out.println("----------账号错误---------");

                Thread.sleep(5000);

                getCutOut().getInto(webDriver);

                getDeviceUse().click(webDriver,By.className("zeromodal-close"));


                userBox.clear();
                passBox.clear();

            }
            if (userBox.isEnabled() && passBox.isEnabled()) {

                Actions actions = new Actions(webDriver);
                actions.moveToElement(userBox);
                actions.click();
                userBox.sendKeys("18796079657");

                Thread.sleep(1000);

                actions.moveToElement(passBox);
                actions.click();
                passBox.sendKeys("654321");
                String currentUrl = webDriver.getCurrentUrl();

                Thread.sleep(1000);

                getDeviceUse().click(webDriver, By.className("login-btn"));
                System.out.println("----------密码错误---------");

                Thread.sleep(5000);
                getCutOut().getInto(webDriver);
                getDeviceUse().click(webDriver,By.className("zeromodal-close"));


                userBox.clear();
                passBox.clear();

            }
            if (userBox.isEnabled() && passBox.isEnabled()) {

                Actions actions = new Actions(webDriver);
                actions.moveToElement(userBox);
                actions.click();
                userBox.sendKeys("18796079657");

                Thread.sleep(1000);

                actions.moveToElement(passBox);
                actions.click();
                passBox.sendKeys("123456");
                String currentUrl = webDriver.getCurrentUrl();

                Thread.sleep(1000);

                getDeviceUse().click(webDriver, By.className("login-btn"));
                getCutOut().getInto(webDriver);

                System.out.println("---------非空---------");

            }

        } else {

            Assert.fail("-----------------输入框不存在----------------");
        }

    }


    private DeviceUse getDeviceUse() {
        return new DeviceUse();
    }


    private GetCutOut getCutOut() {
        return new GetCutOut();
    }
}
