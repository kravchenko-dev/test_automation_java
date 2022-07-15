package Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class ValidateAllInput {
    WebDriver driver;

    public ValidateAllInput(WebDriver driver) {
        this.driver = driver;
    }

    public void enterValueAndClick (String locator, String value) {
        driver.findElement(By.name(locator)).clear();
        driver.findElement(By.name(locator)).sendKeys(value);
        WebElement lastInput = driver.findElement(By.name("user[custom_field_values][3]"));
        String elem = lastInput.getAttribute("value");
        Assert.assertEquals(elem, value);
        driver.findElement(By.name("commit")).click();
    }


        public void checkAndScreenshot () {
            Boolean isPresent = driver.findElements(By.id("errorExplanation")).size() > 0;
            if (isPresent == true) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    Random random = new Random();
                    String name = "src/test/screenshots/ValidateAllInputs" + random + ".png";
                    FileUtils.copyFile(scrFile, new File(name));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
