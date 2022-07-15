package Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class InputCheck {
    WebDriver driver;

    public InputCheck(WebDriver driver) {
        this.driver = driver;
    }

    public void enterValueAndCheck(String value) {
        By search = By.name(value);
        driver.findElement(search).sendKeys("wew");

        driver.findElement(By.name("commit")).click();
        Boolean isPresent = driver.findElements(By.id("errorExplanation")).size() > 0;
        if (isPresent == true) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String name = "src/test/screenshots/" + value + ".png";
            FileUtils.copyFile(scrFile, new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }}
    }
}