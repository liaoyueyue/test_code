package com.autotest0908;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-08
 * Time: 19:18
 */
public class waitTest {
    EdgeDriver driver;

    // 添加隐式等待
    // implicitly 含蓄地；无保留地；暗中地；不明显地；无疑问地
    public waitTest() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new EdgeDriver(options);
    }

    @Test
    void implicationTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.quit();
    }

    @Test
    void webDriverWait() {
        // duration 持续时间; until 直到
        // 添加显示等待
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.cssSelector("#\\32  > div > div._content-border_17ta2_4.content-border_r0TOp.cu-border.sc-aladdin.sc-cover-card > div > div.cos-row > div:nth-child(1) > div > div > div > div > div > div._info-mask_1gdgv_25")));
        driver.quit();
    }
}
