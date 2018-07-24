package Tests.by;

import Driver.CreateCloseDriver;
import org.testng.annotations.Test;



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
        mainPage.clickGeoLink();
        mainPage.inputGeoField("Париж");
        mainPage.clickFranceList();
        mainPage.clickMoreLink();
    }

    @Test
    public void compareMoreList() {
        System.out.println();
    }
}






