package com.autotest20230906;

import org.junit.jupiter.api.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-06
 * Time: 20:44
 */
public class JunitTest {
    // @BeforeEach 每一个方法之前都执行一次
    // @BeforeAll 在所有的方法之前执行一次
    // @AfterEach 每一个方法之后都执行一次
    // @AfterAll 在所有的方法之后执行一次

    @BeforeAll
    static void beforeAll() {
        System.out.println("start");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("qqq");
    }

    @AfterEach
    void afterEach() {
        System.out.println("hhh");
    }

    @Test
    void ordinaryMethod1() {
        System.out.println("ordinary1");
    }

    @Test
    void ordinaryMethod2() {
        System.out.println("ordinary2");
    }


    @AfterAll
    static void afterAll() {
        System.out.println("end");
    }
}
