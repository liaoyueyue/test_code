package com.autotest0831;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-08-31
 * Time: 10:47
 */
public class AutoTest {
    public void bilibiliTest() throws FileNotFoundException, UnsupportedEncodingException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeDriver driver = new EdgeDriver(options);
        PrintWriter printWriter = new PrintWriter("bilibili_feed_card.txt", "utf-8");
        try {
            driver.get("https://www.bilibili.com");
            List<WebElement> elements = driver.findElements(By.className("feed-card"));
            for (WebElement elem : elements
            ) {
                printWriter.println(elem.getText());
            }
            System.out.println("推荐卡牌提取成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            printWriter.close();
        }
    }

}
