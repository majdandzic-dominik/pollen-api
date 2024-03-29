package com.dmajd.pollenapi.rest;

import com.dmajd.pollenapi.scraper.WebScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollenRestController
{
    @GetMapping("/cities")
    public String getCities()
    {
        WebScraper scraper = new WebScraper();
        return scraper.getCityData();
    }
}
