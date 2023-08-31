package com.autotest0831;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.List;
import java.util.Set;

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

    public void windowHandlesTest() throws InterruptedException, IOException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://www.baidu.com");
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(6)")).click();
        String curHandle = driver.getWindowHandle();
        System.out.println("当前窗口的句柄为 " + curHandle);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles
        ) {
            if (!handle.equals(curHandle)) {
                driver.switchTo().window(handle);
                System.out.println("切换窗口句柄为 " + handle);
            }
        }
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#kw")).sendKeys("ikun");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#homeSearchForm > span.s_btn_wr")).click();
        Thread.sleep(2000);
        // 开始保存图片到本地目录
        FileSystemView systemView = FileSystemView.getFileSystemView();
        File desktopPath = systemView.getHomeDirectory();
        File kunkunDirectory = new File(desktopPath,"ikunPicture");
        kunkunDirectory.mkdirs();
        //获取ikun图片集合
        List<WebElement> elements = driver.findElements(By.className("imgbox-border"));
        for (WebElement ele: elements
             ) {
            System.out.println(ele.getText());
        }
        driver.quit();
    }

}
