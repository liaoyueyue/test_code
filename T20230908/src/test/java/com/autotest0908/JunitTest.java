package com.autotest0908;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-08
 * Time: 11:18
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitTest {
    @Test
    @Order(1) // 指定执行顺序
    void loginTest() {
        System.out.println("loginTest");
    }

    @Test
    @Order(2)
    void indexTest() {
        System.out.println("indexTest");
    }

    @Test
    @Order(3)
    void exitTest() {
        System.out.println("exitTest");
    }

    // 单参数
    // 使用了参数化注解的方法上不能再使用@Test注解
    @ParameterizedTest
    @ValueSource(strings = {"lucy", "mary", "alice"})
    void singleParameterTest(String name) {
        System.out.println(name);
    }

    // 多参数
    @ParameterizedTest
    @CsvSource({"lucy, 18", "mary, 19", "alice, 20"})
    void muchParameterTest(String name, int age) {
        System.out.println(name + ":" + age);
    }

    @ParameterizedTest
    @CsvFileSource(files = "students.csv")
    void csvfileParameterTest(String name, int age) {
        System.out.println(name + ":" + age);
    }

    @ParameterizedTest
    @MethodSource("methodParameter") // 当我们这里不指定数据源的方法名时候，会自动找与用例方法名同名的静态方法
    void dynamicMethodParameterTest(String name, int age) {
        System.out.println(name + ":" + age);
    }

//    Arguments 参数
    static Stream<Arguments> methodParameter() throws InterruptedException {
        //构造动态参数
        String[] arr = new String[5];
        for (int i = 0; i < arr.length; i++) {
            Thread.sleep(500);
            arr[i] = System.currentTimeMillis()+"";
        }
        return Stream.of(
                Arguments.arguments(arr[0], 18),
                Arguments.arguments(arr[1], 19),
                Arguments.arguments(arr[2], 18),
                Arguments.arguments(arr[3], 12),
                Arguments.arguments(arr[4], 15)
        );
    }
}
