package Tests.by;

import Driver.CreateCloseDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class YandexGeoLocation extends CreateCloseDriver {
    @Test
    public void cityTest() {

        String urlLondon = "https://yandex.by";
        mainPage.navigateLondon(urlLondon);
        mainPage.clickGeoLink("Лондон");
        mainPage.inputGeoField("Лондон");
        mainPage.clickLodonList();
        mainPage.clickMoreLink("Лондон");

        String urlParis = "https://yandex.by";
        mainPage.navigateParis(urlParis);
        mainPage.clickGeoLink("Париж");
        mainPage.inputGeoField("Париж");
        mainPage.clickParisList();
        mainPage.clickMoreLink("Париж");

        ArrayList<String> moreLinkCityLondon;
        ArrayList<String> moreLinkCityParis;

        mainPage.clickMoreLink("Лондон");
        moreLinkCityLondon = mainPage.getCountMoreLinks("Лондон");

        mainPage.clickMoreLink("Париж");
        moreLinkCityParis = mainPage.getCountMoreLinks("Париж");
        for (int i = 0; i < moreLinkCityLondon.size(); i++) {
            Assert.assertEquals(moreLinkCityLondon.get(i), moreLinkCityParis.get(i));

        }
    }
}
