package com.autotest20230906;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-06
 * Time: 20:29
 */
public class ParamsAutoTest {
    @Test
    public void paramsControl() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("-headless"); // 设置无头模式，速度更快
        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://www.baidu.com");
        List<WebElement> eles = driver.findElements(By.className("hotsearch-item"));
        for (WebElement ele :
                eles) {
            System.out.println(ele.getText());
        }
        driver.quit();
    }
}
