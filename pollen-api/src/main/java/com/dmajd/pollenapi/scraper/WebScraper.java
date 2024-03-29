package com.dmajd.pollenapi.scraper;

import com.dmajd.pollenapi.entity.City;
import com.dmajd.pollenapi.entity.Pollen;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebScraper
{
    private static WebScraper instance = null;
    private final Map<String, String> urls;


    public WebScraper()
    {
        urls = new HashMap<>();
        urls.put("zagreb", "https://www.plivazdravlje.hr/alergije/prognoza/1/Zagreb.html");
        urls.put("dubrovnik", "https://www.plivazdravlje.hr/alergije/prognoza/17/Dubrovnik.html");
        urls.put("osijek", "https://www.plivazdravlje.hr/alergije/prognoza/7/Osijek.html");
        urls.put("pula", "https://www.plivazdravlje.hr/alergije/prognoza/20/Pula.html");
        urls.put("split", "https://www.plivazdravlje.hr/alergije/prognoza/16/Split.html");
        urls.put("varazdin", "https://www.plivazdravlje.hr/alergije/prognoza/3/Varazdin.html");
        urls.put("virovitica", "https://www.plivazdravlje.hr/alergije/prognoza/11/Virovitica.html");
        urls.put("zadar", "https://www.plivazdravlje.hr/alergije/prognoza/15/Zadar.html");
    }

    public static WebScraper getInstance()
    {
        if(instance == null)
        {
            instance = new WebScraper();
        }
        return instance;
    }

    public City getCityData(String cityName)
    {
        try
        {
            // scrape relevant page data
            Document document = Jsoup.connect(urls.get(cityName)).get();
            Elements content = document
                    .getElementsByClass("peludSadrzaj")
                    .first().getElementsByClass("peludHolder");

            // add city and its name
            City city = new City();
            city.setName(
                    document.getElementsByClass("peludPrognozaNaslov1").first().text()
            );

            // add data from each pollen to city
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
        } catch (IOException | NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Map<String, String> getUrls()
    {
        return urls;
    }
}
