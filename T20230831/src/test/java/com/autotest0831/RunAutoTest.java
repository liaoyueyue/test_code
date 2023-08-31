package com.autotest0831;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-08-31
 * Time: 10:47
 */
public class RunAutoTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        AutoTest autoTest = new AutoTest();
//        autoTest.bilibiliTest();
        autoTest.windowHandlesTest();
    }
}
