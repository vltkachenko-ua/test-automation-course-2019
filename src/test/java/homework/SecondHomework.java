package homework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.bonigarcia.wdm.WebDriverManager.*;


public class SecondHomework {

    private WebDriver driver;
    private String url = "http://localhost/litecart";

    private String idMainPage = "box-campaign-products";
    private String idProductPage = "box-product";
    private String selectorForGetNameMainPage = "div.name";
    private String selectorForGetNameProductPage = "h1.title";


    @After
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void chromeTest() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

        // Main page part
        String nameMain = getProductName(idMainPage, selectorForGetNameMainPage);
        String[] priceMain = getProductPrice(idMainPage);
        Assert.assertEquals("Campaign price color on main page is red", "rgba(204, 0, 0, 1)", getCampaignPriceColor(idMainPage));
        Assert.assertEquals("Campaign price text on main page is bold", "700", getCampaignBold(idMainPage));
        Assert.assertEquals("Regular price color on main page is gray", "rgba(51, 51, 51, 1)", getRegularPriceColor(idMainPage));
        Assert.assertEquals("Regular price text on main page is strike", "line-through", getRegularStrike(idMainPage));
        //Product page part
        clickByProduct();
        String nameProductPage = getProductName(idProductPage, selectorForGetNameProductPage);
        String[] priceProductPage = getProductPrice(idProductPage);
        Assert.assertEquals("Campaign price color on product page is red", "rgba(204, 0, 0, 1)", getCampaignPriceColor(idProductPage));
        Assert.assertEquals("Campaign price text on product page is bold", "700", getCampaignBold(idProductPage));
        Assert.assertEquals("Regular price color on product page is gray", "rgba(51, 51, 51, 1)", getRegularPriceColor(idProductPage));
        Assert.assertEquals("Regular price text on product page is strike", "line-through", getRegularStrike(idProductPage));

        Assert.assertArrayEquals("Prices equal on both pages", priceMain, priceProductPage);
        Assert.assertEquals("Names equal on both pages", nameMain, nameProductPage);

    }

    @Test
    public void internetExplorerTest() {
        iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        // Main page part
        String nameMain = getProductName(idMainPage, selectorForGetNameMainPage);
        String[] priceMain = getProductPrice(idMainPage);
        Assert.assertEquals("Campaign price color on main page is red", "rgba(204, 0, 0, 1)", getCampaignPriceColor(idMainPage));
        Assert.assertEquals("Campaign price text on main page is bold", "700", getCampaignBold(idMainPage));
        Assert.assertEquals("Regular price color on main page is gray", "rgba(51, 51, 51, 1)", getRegularPriceColor(idMainPage));
        Assert.assertEquals("Regular price text on main page is strike", "", getRegularStrike(idMainPage));
        //Product page part
        clickByProduct();
        String nameProductPage = getProductName(idProductPage, selectorForGetNameProductPage);
        String[] priceProductPage = getProductPrice(idProductPage);
        Assert.assertEquals("Campaign price color on product page is red", "rgba(204, 0, 0, 1)", getCampaignPriceColor(idProductPage));
        Assert.assertEquals("Campaign price text on product page is bold", "700", getCampaignBold(idProductPage));
        Assert.assertEquals("Regular price color on product page is gray", "rgba(51, 51, 51, 1)", getRegularPriceColor(idProductPage));
        Assert.assertEquals("Regular price text on product page is strike", "", getRegularStrike(idProductPage));

        Assert.assertArrayEquals("Prices equal on both pages", priceMain, priceProductPage);
        Assert.assertEquals("Names equal on both pages", nameMain, nameProductPage);
    }

    @Test
    public void fireFoxTest() {
        firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        // Main page part
        String nameMain = getProductName(idMainPage, selectorForGetNameMainPage);
        String[] priceMain = getProductPrice(idMainPage);
        Assert.assertEquals("Campaign price color on main page is red", "rgb(204, 0, 0)", getCampaignPriceColor(idMainPage));
        Assert.assertEquals("Campaign price text on main page is bold", "700", getCampaignBold(idMainPage));
        Assert.assertEquals("Regular price color on main page is gray", "rgb(51, 51, 51)", getRegularPriceColor(idMainPage));
        Assert.assertEquals("Regular price text on main page is strike", "line-through", getRegularStrike(idMainPage));
        //Product page part
        clickByProduct();
        String nameProductPage = getProductName(idProductPage, selectorForGetNameProductPage);
        String[] priceProductPage = getProductPrice(idProductPage);
        Assert.assertEquals("Campaign price color on product page is red", "rgb(204, 0, 0)", getCampaignPriceColor(idProductPage));
        Assert.assertEquals("Campaign price text on product page is bold", "700", getCampaignBold(idProductPage));
        Assert.assertEquals("Regular price color on product page is gray", "rgb(51, 51, 51)", getRegularPriceColor(idProductPage));
        Assert.assertEquals("Regular price text on product page is strike", "line-through", getRegularStrike(idProductPage));

        Assert.assertArrayEquals("Prices equal on both pages", priceMain, priceProductPage);
        Assert.assertEquals("Names equal on both pages", nameMain, nameProductPage);
    }

    @Test
    public void operaTest() {
        operadriver().setup();
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        // Main page part
        String nameMain = getProductName(idMainPage, selectorForGetNameMainPage);
        String[] priceMain = getProductPrice(idMainPage);
        Assert.assertEquals("Campaign price color on main page is red", "rgba(204, 0, 0, 1)", getCampaignPriceColor(idMainPage));
        Assert.assertEquals("Campaign price text on main page is bold", "700", getCampaignBold(idMainPage));
        Assert.assertEquals("Regular price color on main page is gray", "rgba(51, 51, 51, 1)", getRegularPriceColor(idMainPage));
        Assert.assertEquals("Regular price text on main page is strike", "line-through", getRegularStrike(idMainPage));
        //Product page part
        clickByProduct();
        String nameProductPage = getProductName(idProductPage, selectorForGetNameProductPage);
        String[] priceProductPage = getProductPrice(idProductPage);
        Assert.assertEquals("Campaign price color on product page is red", "rgba(204, 0, 0, 1)", getCampaignPriceColor(idProductPage));
        Assert.assertEquals("Campaign price text on product page is bold", "700", getCampaignBold(idProductPage));
        Assert.assertEquals("Regular price color on product page is gray", "rgba(51, 51, 51, 1)", getRegularPriceColor(idProductPage));
        Assert.assertEquals("Regular price text on product page is strike", "line-through", getRegularStrike(idProductPage));

        Assert.assertArrayEquals("Prices equal on both pages", priceMain, priceProductPage);
        Assert.assertEquals("Names equal on both pages", nameMain, nameProductPage);
    }

    private String getProductName(String id, String selectorForName) {
        WebElement elementForId = driver.findElement(By.id(id));
        String name = elementForId.findElement(By.cssSelector(selectorForName)).getText();
        System.out.println(name);
        return name;
    }

    private String[] getProductPrice(String id) {
        String[] price = new String[2];
        WebElement elementForId = driver.findElement(By.id(id));
        price[0] = elementForId.findElement(By.cssSelector("strong.campaign-price")).getText();
        price[1] = elementForId.findElement(By.cssSelector("del.regular-price")).getText();
        return price;
    }

    private void clickByProduct() {
        WebElement elementForId = driver.findElement(By.id(idMainPage));
        elementForId.findElement(By.cssSelector("div.image-wrapper")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.id(idProductPage)));
    }

    private String getCampaignPriceColor(String id) {
        WebElement elementForId = driver.findElement(By.id(id));
        String campaignColor = elementForId.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println(campaignColor);
        return campaignColor;
    }

    private String getRegularPriceColor(String id) {
        WebElement elementForId = driver.findElement(By.id(id));
        String regularColor = elementForId.findElement(By.cssSelector("del.regular-price")).getCssValue("color");
        System.out.println(regularColor);
        return regularColor;
    }

    private String getRegularStrike(String id) {
        WebElement elementForId = driver.findElement(By.id(id));
        String regularBold = elementForId.findElement(By.cssSelector("del.regular-price")).getCssValue("text-decoration-line");
        System.out.println(regularBold);
        return regularBold;
    }

    private String getCampaignBold(String id) {
        WebElement elementForId = driver.findElement(By.id(id));
        String campaignStrike = elementForId.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        System.out.println(campaignStrike);
        return campaignStrike;
    }
}
