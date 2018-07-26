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

    final String City1 = "Лондон";
    final String City2 = "Париж";
    final String URL = "https://yandex.by";

    @Test
    public void cityTest() {
        ArrayList<String> moreLinkCity1;
        ArrayList<String> moreLinkCity2;

        mainPage = new MainPage(driver);
        locationPage = new LocationPage(driver);

        mainPage.navigate(URL);

        mainPage.clickGeoLink(City1);
        locationPage.cityLocationCity1(City1);
        mainPage.clickMoreLink(City1);
        moreLinkCity1 = mainPage.getCountMoreLinks(City1);

        mainPage.clickGeoLink(City2);
        locationPage.cityLocationCity2(City2);
        mainPage.clickMoreLink(City2);
        moreLinkCity2 = mainPage.getCountMoreLinks(City2);


        for (int i = 0; i < moreLinkCity1.size(); i++) {
            Assert.assertEquals(moreLinkCity1.get(i), moreLinkCity2.get(i));

        }
    }
}
