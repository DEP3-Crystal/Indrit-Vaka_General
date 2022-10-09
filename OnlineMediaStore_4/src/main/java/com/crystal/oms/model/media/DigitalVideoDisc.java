package com.crystal.oms.model.media;

import com.crystal.oms.model.Disc;

public class DigitalVideoDisc extends Disc
{
    private String director;
    private int length;

    public DigitalVideoDisc(String title, Category category, long cost, String director, int length,int capacity, String type)
    {
        super(capacity, type);
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

