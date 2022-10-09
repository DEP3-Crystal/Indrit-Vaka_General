package com.crystal.oms.model;

public class DigitalVideoDisc extends Media
{
    private String director;
    private int length;

    public DigitalVideoDisc()
    {

    }

    public DigitalVideoDisc(String title, Category category, long cost, String director, int length)
    {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
        this.length = length;
    }




    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }


    @Override
    public String toString()
    {
        return String.format("%s|%s|%f|%s|%d", title, category.toString(), cost,director, length);
    }
}

