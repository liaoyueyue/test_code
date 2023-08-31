package com.autotest0830;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-08-30
 * Time: 19:38
 */
public class FirstAutoTest {
    public void kunkunTest(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeDriver driver = new EdgeDriver(options);
        try {
            Thread.sleep(3000);
            driver.get("https://www.baidu.com");
            Thread.sleep(3000);
                driver.findElement(By.cssSelector("#kw")).sendKeys("坤坤表情包");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#su")).click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    public void getHotSearch() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://www.baidu.com");
        List<WebElement> eles = driver.findElements(By.className("hotsearch-item"));
        for (WebElement els : eles
        ) {
            System.out.println(els.getText());
        }
        driver.quit();
    }
}
