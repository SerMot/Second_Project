package Tests.by;

import Driver.CreateCloseDriver;

import Packages.LocationPage;
import Packages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class YandexGeoLocation extends CreateCloseDriver {

    public MainPage mainPage;
    public LocationPage locationPage;

    final String CITY1 = "Лондон";
    final String CITY2 = "Париж";
    final String URL = "https://yandex.by";

    @Test
    public void cityTest() {
        ArrayList<String> moreLinkCity1;
        ArrayList<String> moreLinkCity2;

        mainPage = new MainPage(driver);
        locationPage = new LocationPage(driver);

        mainPage.navigate(URL);


        mainPage.clickGeoLink(CITY1);
        locationPage.cityLocationCity1(CITY1);
        mainPage.clickMoreLink(CITY1);
        moreLinkCity1 = mainPage.getCountMoreLinks(CITY1);

        mainPage.clickGeoLink(CITY2);
        locationPage.cityLocationCity2(CITY2);
        mainPage.clickMoreLink(CITY2);
        moreLinkCity2 = mainPage.getCountMoreLinks(CITY2);


        for (int i = 0; i < moreLinkCity1.size(); i++) {
            Assert.assertEquals(moreLinkCity1.get(i), moreLinkCity2.get(i));

        }
    }
}
