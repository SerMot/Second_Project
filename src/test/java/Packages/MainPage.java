package Packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;


    @FindBy(css = "a[data-statlog=\"head.region.setup\"] span")
    private WebElement GeoLink;

    @FindBy(css = "input[id=\"city__front-input\"]")
    private WebElement findLondonField;

    @FindBy(css = "li[data-bem*='\"subtitle\":\"Великобритания\"'] div[class='b-autocomplete-item__reg']")
    private WebElement findLondonList;

    @FindBy(css = "a[data-statlog=\"tabs.more\"]")
    private WebElement findMoreLink;

    @FindBy(css = "li[data-bem*='\"subtitle\":\"Франция\"'] div[class='b-autocomplete-item__reg']")
    private WebElement findFranceList;

    @FindBy(css = "div[class=\"home-tabs__more-item\"] a")
    private WebElement findMoreLinksLondon;

    @FindBy(css = "div[class=\"home-tabs__more-item\"] a")
    private WebElement findMoreLinksParis;

    public void navigate(String URL) {
        driver.get(URL);
        System.out.println("Переход на:" + URL);
    }

    public void clickGeoLink() {
        GeoLink.click();
    }

    public void inputGeoField(String text) {
        findLondonField.clear();
        findLondonField.sendKeys(text);
    }

    public void clickLodonList() {
        findLondonList.click();
    }

    public void clickMoreLink() {
        findMoreLink.click();
    }

    public void clickFranceList() {
        findFranceList.click();
    }

    public void clickLondonMoreLink() {
        findMoreLinksLondon.click();
    }

    public void clickParisMoreLink() {
        findMoreLinksParis.click();
    }

}
