package myTestSuite;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import core.config.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FirstTest extends BaseTest {

    @Test
    public void test(){

        $(By.xpath("//input[@placeholder='Username']")).append("standard_user");
        $(By.xpath("//input[@placeholder='Password']")).append("secret_sauce");
        Assert.assertTrue($(By.xpath("//input[@value='Login']")).is(Condition.visible));
        $(By.xpath("//input[@value='Login']")).click();
        Selenide.sleep(1000);
        List<String> texts = $$(By.xpath("//div[@class='inventory_item_label']//div[@class='inventory_item_name']")).texts();
        Selenide.sleep(1000);
    }


}
