package Packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;
    ArrayList<String> cityLinksMore = new ArrayList<String>();


    @FindBy(css = "a[data-statlog=\"head.region.setup\"] span")
    private WebElement GeoLink;

    @FindBy(css = "input[id=\"city__front-input\"]")
    private WebElement findLondonField;

    @FindBy(css = "li[data-bem*='\"subtitle\":\"Великобритания\"'] div[class='b-autocomplete-item__reg']")
    private WebElement findLondonList;

    @FindBy(css = "a[data-statlog=\"tabs.more\"]")
    private WebElement findMoreLink;


    @FindBy(css = "li[data-bem*='\"subtitle\":\"Франция\"'] div[class='b-autocomplete-item__reg']")
    private WebElement findParisList;


    @FindBy(css = "div[class=\"home-tabs__more-item\"] a")
    private List<WebElement> moreLinks;



    public void navigateLondon(String urlLondon) {
        driver.get(urlLondon);
        System.out.println("Переход на:" + urlLondon);
    }

    public void navigateParis(String urlParis) {
        driver.get(urlParis);
        System.out.println("Переход на:" + urlParis);
    }

    public void clickGeoLink(String text) {
        GeoLink.click();
    }

    public void inputGeoField(String text) {
        findLondonField.clear();
        findLondonField.sendKeys(text);
    }

    public void clickLodonList() {
        findLondonList.click();
    }

    public void clickParisList() {
        findParisList.click();
    }

    public void clickMoreLink(String text) {
        findMoreLink.click();
    }


    public ArrayList<String> getCountMoreLinks(String city){
        System.out.println("Количество ссылок на вкладке 'ещё': "+ city + " = " + moreLinks.size());

        if (!cityLinksMore.isEmpty())
            cityLinksMore.clear();

        for(WebElement e : moreLinks) {
            System.out.println(e.getText());
            cityLinksMore.add(e.getText());
        }
        return cityLinksMore;
    }
}
