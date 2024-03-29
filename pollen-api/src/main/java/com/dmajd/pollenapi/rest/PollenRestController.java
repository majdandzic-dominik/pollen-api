package com.dmajd.pollenapi.rest;

import com.dmajd.pollenapi.entity.City;
import com.dmajd.pollenapi.scraper.WebScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PollenRestController
{
    @GetMapping("/cities")
    public Set<String> getCities()
    {
        WebScraper scraper = WebScraper.getInstance();
        return scraper.getUrls().keySet();
    }

    @GetMapping("/cities/{cityName}")
    public City getCities(@PathVariable String cityName)
    {
        WebScraper scraper = WebScraper.getInstance();
        return scraper.getCityData(cityName);
    }

}
