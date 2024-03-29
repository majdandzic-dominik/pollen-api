package com.dmajd.pollenapi.entity;

import java.util.ArrayList;
import java.util.List;

public class City
{
    List<Pollen> pollenList;

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
