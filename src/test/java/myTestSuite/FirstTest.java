package myTestSuite;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import core.config.Pages;
import core.config.base.BaseTest;
import core.config.pages.loginpage.LoginPage;
import core.pages.Item;
import core.pages.ItemDetails;
import core.pages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FirstTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ItemDetails itemDetails = new ItemDetails();

    @BeforeMethod
    public void prepareVariables() {
        loginPage = new LoginPage();

    }

    @Test
    public void test()  {

        $(By.xpath("//input[@placeholder='Username']")).append("standard_user");
        $(By.xpath("//input[@placeholder='Password']")).append("secret_sauce");
        Assert.assertTrue($(By.xpath("//input[@value='Login']")).is(Condition.visible));
        $(By.xpath("//input[@value='Login']")).click();
        Selenide.sleep(1000);

        List<Item> items = mainPage.getItems();
        System.out.println(items);

        mainPage.getElement().get(1).click();
        Selenide.sleep(1000);
        Item detailItem = itemDetails.getDetailItem();
        System.out.println(detailItem);

        Assert.assertTrue(items.contains(detailItem));


    }


}
