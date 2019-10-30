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

    private String url = "http://demo.litecart.net/admin/";
    private String username = "demo";
    private String password = "demo";


    @Test
    public void loginTest() {
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
        // Find all elements in menu and create list with their name
        List<WebElement> apps = driver.findElements(By.cssSelector("li.app"));
        List<String> appsMap = new ArrayList<>();

        // Create map of elements name
        apps.forEach(app -> {
            String appName = app.getText();
            appsMap.add(appName);
        });

        // Click on every element in left side menu's
        appsMap.forEach(mainElementName -> {
            System.out.println("Click on main element: " + mainElementName);
            driver.findElement(By.linkText(mainElementName)).click();

            // Wait sub elements if exist
            List<WebElement> subElements = findDocs(mainElementName);

            // If sub elements exist, then create map of it
            if (subElements != null) {
                List<String> subElementsName = new ArrayList<>();
                subElements.forEach(element -> {
                    String name = element.getText();
                    subElementsName.add(name);
                });

                // Click on every sub element
                subElementsName.forEach(subElementName -> {
                    System.out.println("Click on sub element: " + subElementName);
                    WebElement subElementUL = driver.findElement(By.cssSelector("ul.docs"));
                    subElementUL.findElement(By.linkText(subElementName)).click();
                    // Check page header of sub element
                    assert findPageHeader().equals(true) : "Header on the page " + subElementName + " not found.";
                });
            }

            // Check page header of main element
            else assert findPageHeader().equals(true) : "Header on the page " + mainElementName + " not found.";
        });
    }

    // Method for find sub elements
    private List<WebElement> findDocs(String elementName) {
        try {
            WebElement docs = (new WebDriverWait(driver, 1))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.docs")));
            return docs.findElements(By.tagName("li"));
        } catch (Exception e) {
            System.out.println(elementName + " without sub elements");
            return null;
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
