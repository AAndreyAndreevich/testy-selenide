package saucedemo;

import io.qameta.allure.Description;
import org.testng.Assert;
import saucedemo.pages.LoginPage;
import saucedemo.service.BaseTest;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {

    @Test
    @Description("Попытка входа на заблокированную учетную запись")
    public void lockedUserTest() throws InterruptedException {
        LoginPage.lockedOutUserLogin();
        Thread.sleep(3000);
        Assert.assertTrue(LoginPage.getLockedInfo().isDisplayed());
    }

}