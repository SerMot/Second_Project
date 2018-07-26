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

    @FindBy(css = "a[data-statlog=\"tabs.more\"]")
    private WebElement findMoreLink;

    @FindBy(css = "div[class=\"home-tabs__more-item\"] a")
    private List<WebElement> moreLinks;


    public void navigate(String URL) {
        driver.get(URL);
        System.out.println("Переход на: "+URL);
    }


        public void clickGeoLink(String text) {
        GeoLink.click();
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
