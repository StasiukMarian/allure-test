package core.config;

import core.config.allure.AllureLogger;
import core.config.pages.loginpage.LoginPage;

public class Pages extends AllureLogger {
    private static LoginPage loginPage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
