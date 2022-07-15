package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;

public class Link {
    WebDriver driver;

    public Link(WebDriver driver) {
        this.driver = driver;
    }



    public void clickLink(String value) {
        By search = By.xpath(value);
        driver.findElement(search).click();
    }

    public void checkExpect(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(driver.getCurrentUrl().contains(value));

    }
}