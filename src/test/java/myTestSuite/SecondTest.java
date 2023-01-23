package myTestSuite;

import core.config.base.BaseTest;
import org.testng.annotations.*;

public class SecondTest  {

    @Test(priority = 1)
    public void test1() {
//        Pages.loginPage().typeLoginForm();
//        Selenide.sleep(1000);
//        Pages.loginPage().clearLoginForm();
        System.out.println("Test1");
    }

    @Test(priority = 2)
    public void test2() {
//        Pages.loginPage().typeLoginForm();
//        Selenide.sleep(1000);
//        Pages.loginPage().clearLoginForm();
        System.out.println("Test2");
    }

    @Test(priority = 3)
    public void test3() {
//        Pages.loginPage().typeLoginForm();
//        Selenide.sleep(1000);
//        Pages.loginPage().clearLoginForm();
        System.out.println("Test3");
    }


}
