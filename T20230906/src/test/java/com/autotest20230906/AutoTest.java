package com.autotest20230906;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-06
 * Time: 16:12
 */
public class AutoTest {
    EdgeDriver driver;

    public AutoTest() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new EdgeDriver(options);
    }

    @Test
    public void alertControl() throws InterruptedException {

        driver.get("");
        Thread.sleep(3000);
        // 切换到弹窗进行处理
        Alert alert =  driver.switchTo().alert();
        Thread.sleep(3000);
        // 在弹窗内输入内容
        alert.sendKeys("这里是弹窗里的内容");
        // 确认
        alert.accept();
        // 取消
        alert.dismiss();
        driver.quit();
    }

    @Test
    public void selectControl() {
        driver.get("");
        WebElement element = driver.findElement(By.cssSelector("#check-box"));
        // 创建选择框对象
        Select select = new Select(element);
        // 根据文本来选择
        // VisibleText 可见的文本
        select.selectByVisibleText("选择2");
        select.selectByVisibleText("选择3");
        // 根据属性值来选择
        select.selectByValue("option标签内value的值");
        // 根据序号来选择
        select.selectByIndex(1);
        driver.quit();
    }

    @Test
    public void fileUploadControl() {
        driver.get("");
        driver.findElement(By.cssSelector("# input[type=file]")).sendKeys("path");
        driver.quit();
    }
}
