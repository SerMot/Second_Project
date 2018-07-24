package Tests.by;

import Driver.CreateCloseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class YandexGeoLocation extends CreateCloseDriver {
    @Test
    public void londonTest() {
        String URL = "https://yandex.by";
        mainPage.navigate(URL);

        mainPage.clickGeoLink();
        mainPage.inputGeoField("Лондон");
        mainPage.clickLodonList();
        mainPage.clickMoreLink();
    }

    @Test
    public void parisTest() {
        String URL = "https://yandex.by";
        mainPage.navigate(URL);
        mainPage.clickGeoLink();
        mainPage.inputGeoField("Париж");
        mainPage.clickFranceList();
        mainPage.clickMoreLink();
    }

    @Test
    public void compareMoreList() {
        String URL = "https://yandex.by";
        mainPage.navigate(URL);

        List<WebElement> londonLists = driver.findElements(By.cssSelector("div[class=\"home-tabs__more-item\"] a"));
        List<WebElement> parisLists = driver.findElements(By.cssSelector("div[class=\"home-tabs__more-item\"] a"));

        Assert.assertEquals(londonLists, parisLists);
        for (int i = 0; i < londonLists.size(); i++) {
        Assert.assertEquals(londonLists.get(i).getText(), parisLists.get(i).getText());

        }
    }
}




