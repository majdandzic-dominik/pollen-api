package com.dmajd.pollenapi.scraper;

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

    public String getCityData()
    {
        try
        {
            Document document = Jsoup.connect(url).get();
            Elements content = document
                    .getElementsByClass("peludSadrzaj")
                    .first().getElementsByClass("peludHolder");
            return content.text();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return "HEHEXD";
    }
}
