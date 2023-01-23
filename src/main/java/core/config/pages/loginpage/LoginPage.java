package core.config.pages.loginpage;

import core.config.PageTools;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageTools {
    private By userName = By.xpath("//div[@class='form_group']//input[@placeholder='Username']");
    private By password = By.xpath("//div[@class='form_group']//input[@placeholder='Password']");
    private By button = By.xpath("//input[@value='Login']");

    public void typeLoginForm(){
        waitForElementVisibility(userName);
        type("standard_user",userName);
        waitForElementVisibility(password);
        type("secret_sauce",password);
    }
    public void clearLoginForm(){
        $(By.xpath("//div[@class='form_group']//input[@placeholder='Username']")).clear();
        getElementText(userName);
        $(By.xpath("//div[@class='form_group']//input[@placeholder='Password']")).clear();
    }

}
