package com.example.allpass.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *  Devices Function
 */
public class DeviceUse implements DevicesFunction {

    @Override
    public void sendKeys(WebDriver webDriver, By by, String value) {
        webDriver.findElement(by).sendKeys(value);
    }

    @Override
    public void radioOption(WebDriver webDriver, By by, String name) {
        WebElement is_element = webDriver.findElement(by);
        if (is_element.isSelected()) switch (is_element.getAttribute("value")) {
            case "0":
                click(webDriver, By.id(name + "_yes"));
                break;
            case "1":
                click(webDriver, By.id(name + "_no"));
                break;
        }

    }

    @Override
    public void click(WebDriver webDriver, By by) {

        webDriver.findElement(by).click();
    }

    //关闭当前浏览器
    @Override
    public void CloseThePage(WebDriver webDriver) {

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            webDriver.quit();
        }



        System.out.println("----------------测试结束------------------");
    }

    @Override
    public void pullDownList(WebDriver webDriver, By by, String text) {
        webDriver.getCurrentUrl();
        System.out.println(webDriver.getPageSource());

        Select select = new Select(webDriver.findElement(by));
        List<WebElement> allOptions = select.getAllSelectedOptions();

        for (WebElement e : allOptions) {

            try {
                Thread.sleep(2000);
                if (e.isSelected() ){
                    select.selectByVisibleText(text);

                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }

    @Override
    public boolean IsElementPresent(WebDriver webDriver,By by) {
        try {
            webDriver.findElement(by);

            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    @Override
    public void back(WebDriver driver) {
        driver.navigate().back();
    }


    @Override
    public void forward(WebDriver driver) {
        driver.navigate().forward();
    }

    @Override
    public String getText(WebDriver driver,By by) {
        return driver.findElement(by).getText();
    }


}
