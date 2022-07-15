package org.example;

import Objects.DataProviderData;
import Objects.InputCheck;
import Objects.Link;
import Objects.ValidateAllInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;


public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.redmine.org/account/register");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
   }

    @Test
    public void homeLink () {
        Link page = new Link(driver);
        page.clickLink("//*[@id=\"top-menu\"]/ul/li[2]/a");
        page.checkExpect("redmine.org");
        driver.navigate().back();
    }

   @Test
    public void projectsLink () {
       Link page = new Link(driver);
       page.clickLink("//*[@id=\"top-menu\"]/ul/li[2]/a");
       page.checkExpect("projects");
       driver.navigate().back();
   }

    @Test
    public void helpLink () {
        Link page = new Link(driver);
        page.clickLink("//*[@id=\"top-menu\"]/ul/li[3]/a");
        page.checkExpect("/guide");
        driver.navigate().back();
    }

    @Test
    public void loginLink () {
        Link page = new Link(driver);
        page.clickLink("//*[@id=\"account\"]/ul/li[1]/a");
        page.checkExpect("login");
        driver.navigate().back();
    }

    @Test
    public void searchLink () {
        Link page = new Link(driver);
        page.clickLink("//*[@id=\"quick-search\"]/form/label/a");
        page.checkExpect("search");
        driver.navigate().back();
    }

    @Test
    public void inputLogin () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[login]");
    }

    @Test
    public void inputPassword () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[password]");
    }

    @Test
    public void inputConfirmation () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[password_confirmation]");
    }

    @Test
    public void inputFirstName () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[firstname]");
    }

    @Test
    public void inputLastName () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[lastname]");
    }

    @Test
    public void inputEmail () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[mail]");
    }

    @Test
    public void inputIrcNick () {
        InputCheck page = new InputCheck(driver);
        page.enterValueAndCheck("user[custom_field_values][3]");
    }

    @Test(dataProvider="setValue",dataProviderClass= DataProviderData.class)
    public void validateAllInput (String locator, String value) {
        ValidateAllInput page = new ValidateAllInput(driver);
        page.enterValueAndClick(locator, value);
        page.checkAndScreenshot();
    }

    @AfterClass
    public void afterTest() {
        driver.close();
    }
}
