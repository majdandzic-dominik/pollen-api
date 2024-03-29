package com.dmajd.pollenapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollenRestController
{
    @GetMapping("/cities")
    public String getCities()
    {
        return "Empty";
    }
}
