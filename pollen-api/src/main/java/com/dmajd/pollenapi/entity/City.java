package com.dmajd.pollenapi.entity;

import java.util.ArrayList;
import java.util.List;

public class City
{
    private String name;
    private List<Pollen> pollenList;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public City()
    {
        pollenList = new ArrayList<>();
    }

    public List<Pollen> getPollenList()
    {
        return pollenList;
    }

    public void setPollenList(List<Pollen> pollenList)
    {
        this.pollenList = pollenList;
    }

    public void addPollen(Pollen pollen)
    {
        pollenList.add(pollen);
    }

    public void clearPollenList()
    {
        pollenList.clear();
    }
}
