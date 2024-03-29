package com.dmajd.pollenapi.entity;

public class Pollen
{
    private String name;
    private String date;
    private float value;

    public Pollen()
    {
    }

    public Pollen(String name, String date, float value)
    {
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public float getValue()
    {
        return value;
    }

    public void setValue(float value)
    {
        this.value = value;
    }


}
