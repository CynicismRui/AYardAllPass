package com.example.allpass;


import com.example.allpass.Exit.UserToExit;
import com.example.allpass.Query.GoodsQuery;
import com.example.allpass.Query.Query;
import com.example.allpass.Upload.ImageUpload;
import com.example.allpass.function.DeviceUse;
import com.example.allpass.imgcotout.GetCutOut;
import com.example.allpass.login.Login;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass extends BaseURL {

    private static WebDriver webDriver;
    private static DeviceUse deviceUse;
    private static ImageUpload imageUpload;

    @Before
    public void beforeEach() {
        //如果火狐浏览器没有默认安装在C盘，需要制定其路径

        System.setProperty("webdriver.gecko.driver", "E:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");

        webDriver = new FirefoxDriver();

        deviceUse = new DeviceUse();

        imageUpload = new ImageUpload();

        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void main() {
        //请求地址
        webDriver.get(new BaseURL().URL());
        try {
            Thread.sleep(2000);
            // 最⼤化窗⼝
            webDriver.manage().window().maximize();
            Thread.sleep(2000);

            //平台账号登录
            new Login().LoginID(webDriver);

            WebElement web_left_nav = webDriver.findElement(By.className("web_left_nav"));
            List<WebElement> h1s = web_left_nav.findElements(By.tagName("h1"));
            List<WebElement> lis = web_left_nav.findElements(By.tagName("li"));

            System.out.println(h1s.get(0).getText());
            h1s.get(0).click();
            System.out.println(lis.get(0).getText());
            lis.get(0).click();
            getCutOut().getInto(webDriver);
            Thread.sleep(2000);
            deviceUse.click(webDriver, By.className("add"));

            deviceUse.sendKeys(webDriver, By.name("name"), "补水保湿睡眠面膜");
            Thread.sleep(2000);

            webDriver.findElement(By.name("price")).clear();
            Thread.sleep(1000);
            deviceUse.sendKeys(webDriver, By.name("price"), "268.00");
            Thread.sleep(2000);

            deviceUse.sendKeys(webDriver, By.name("count"), "100");
            Thread.sleep(2000);

            deviceUse.pullDownList(webDriver, By.name("shop_type"), "美容洗护");
            Thread.sleep(2000);


//            imageUpload.imageUpload(webDriver, By.className("file_zhanshi_img"));

            deviceUse.back(webDriver);
            Thread.sleep(2000);


            new GoodsQuery().GoodQuery(deviceUse, webDriver, By.name("name"), By.className("sub"), By.name("good_type"), "任务", "日用百货");



            List<WebElement> is_sxj = webDriver.findElements(By.className("is_sxj"));

            //退出平台
            new UserToExit().LoginToExit(TestClass.webDriver);


            deviceUse.CloseThePage(webDriver);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private GetCutOut getCutOut() {
        return new GetCutOut();
    }
}
