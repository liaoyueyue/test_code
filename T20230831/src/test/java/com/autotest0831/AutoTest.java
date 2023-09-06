package com.autotest0831;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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

    public void windowHandlesTest() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的图片的关键字：");
        String searchKey = scanner.next();

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
        driver.findElement(By.cssSelector("#kw")).sendKeys(searchKey);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#homeSearchForm > span.s_btn_wr")).click();
        Thread.sleep(2000);
        // 开始保存图片到本地目录
        FileSystemView systemView = FileSystemView.getFileSystemView();
        File desktopPath = systemView.getHomeDirectory();
        File searchKeyDirectory = new File(desktopPath, searchKey);
        searchKeyDirectory.mkdirs();
        //获取searchKey图片集合
        List<WebElement> elements = driver.findElements(By.cssSelector(".imgbox-border img"));
        List<String> images = new ArrayList<>();
        for (WebElement ele : elements) {
            String img = ele.getAttribute("src");
            System.out.println(img);
            images.add(img);
        }

        for (String imageUrl : images) {
            try {
                URL url = new URL(imageUrl);
                InputStream is = url.openStream();
                String path = searchKeyDirectory.getPath() + "\\" + UUID.randomUUID().toString().replace("-", "") + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                byte[] tmp = new byte[1024];
                int len = 0;
                while ((len = is.read(tmp)) != -1) {
                    fileOutputStream.write(tmp, 0, len);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                is.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                driver.quit();
            }
        }

    }

}
