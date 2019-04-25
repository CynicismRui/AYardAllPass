package com.example.allpass.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * sendKeys 输入框输入
 *
 * radioOption 下拉列表操作
 *
 * click 控件点击
 *
 * CloseThePage 关闭页面
 *
 * IsElementPresent 判断元素是否存在
 *
 *
 */
public interface DevicesFunction {

    void sendKeys(WebDriver driver, By by, String value);

    void radioOption(WebDriver driver, By by, String str);

    void click(WebDriver driver, By by);

    void CloseThePage(WebDriver driver);

    void pullDownList(WebDriver driver, By by, String text);

    boolean IsElementPresent(WebDriver driver, By by);

    void back(WebDriver driver);

    void forward(WebDriver driver);

    String getText(WebDriver driver, By by);



}
