package core.config.pages;

import core.config.pages.loginpage.LoginPage;

public class Pages {

    private static LoginPage loginPage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


}
