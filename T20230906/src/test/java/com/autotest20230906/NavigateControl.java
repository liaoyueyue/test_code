package com.autotest20230906;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-06
 * Time: 15:41
 */
public class NavigateControl {
    EdgeDriver driver;

    public NavigateControl() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new EdgeDriver(options);
    }

    @Test
    public void navigateControl() throws InterruptedException {
        driver.navigate().to("https://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }
}
