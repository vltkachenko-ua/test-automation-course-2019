package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusable.TestBase;

import java.util.ArrayList;
import java.util.List;

public class FirstHomework extends TestBase {


    @Test
    public void loginTest() {
        String url = "http://demo.litecart.net/admin/";
        String username = "demo";
        String password = "demo";

        driver.navigate().to(url);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn.btn-default")).click();

        WebElement alert = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("notices")));

        assert alert.getText().trim().contains("You are now logged in as demo") : "Login failed.";
    }

    @Test
    public void leftMenuTest() {
        List<WebElement> apps = driver.findElements(By.cssSelector("li.app"));

        for (int i = 0; i < apps.size(); i++) {
            apps = driver.findElements(By.cssSelector("li.app"));
            String nameApp = apps.get(i).getText();
            apps.get(i).click();
            List<WebElement> docs = findDocs();
            for (int j = 0; j < docs.size(); j++) {
                docs = findDocs();
                String nameDoc = docs.get(j).getText();
                docs.get(j).click();
                assert findPageHeader().equals(true) : "Header on the page " + nameDoc + " not found.";
            }
            assert findPageHeader().equals(true) : "Header on the page " + nameApp + " not found.";
        }

    }

    // Method for find sub elements
    private List<WebElement> findDocs() {
        List<WebElement> docsLI = new ArrayList<>();
        try {
            WebElement docsUL = (new WebDriverWait(driver, 1))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.docs")));
            docsLI = docsUL.findElements(By.tagName("li"));
            return docsLI;
        } catch (Exception e) {
            return docsLI;
        }
    }

    // Method for find header on the page
    private Boolean findPageHeader() {
        try {
            return driver.findElement(By.cssSelector("div.panel-heading")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
