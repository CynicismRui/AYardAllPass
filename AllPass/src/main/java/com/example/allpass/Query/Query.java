package com.example.allpass.Query;

import com.example.allpass.function.DeviceUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * GoodsQuery 商品查询
 */
public interface Query {

    void GoodQuery(DeviceUse deviceUse,WebDriver webDriver, By name, By sub, By good_type, String text, String type);

}
