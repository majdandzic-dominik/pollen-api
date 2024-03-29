package com.dmajd.pollenapi.scraper;

import com.dmajd.pollenapi.entity.City;
import com.dmajd.pollenapi.entity.Pollen;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper
{
    String url = "https://www.plivazdravlje.hr/alergije/prognoza/1/Zagreb.html";

    public WebScraper()
    {
    }

    public City getCityData()
    {
        try
        {
            City city = new City();

            Document document = Jsoup.connect(url).get();
            Elements content = document
                    .getElementsByClass("peludSadrzaj")
                    .first().getElementsByClass("peludHolder");

            for (Element pollenData : content)
            {
                Pollen tempPollen = new Pollen(
                        pollenData.getElementsByClass("peludKategorija").text(),
                        pollenData.getElementsByClass("peludStupacDatum").first().text(),
                        Float.parseFloat(pollenData.getElementsByClass("peludStupacOcitanje ").first().text())
                );
                city.addPollen(tempPollen);
            }
            return city;
        }
        catch (IOException | NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
