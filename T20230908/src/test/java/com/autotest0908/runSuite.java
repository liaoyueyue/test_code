package com.autotest0908;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-09-08
 * Time: 12:12
 */

/**
 * 使用 @Suite 注解来表示该类为测试套件类
 */
@Suite
//@SelectClasses({oneTest.class, twoTest.class})
@SelectPackages("com.autotest0908")
// 如果使用包名来指定运行的范围，则该包下所有的测试类的命名需要以 Test/Tests 来结尾（T必须要大写）
public class runSuite {

}
