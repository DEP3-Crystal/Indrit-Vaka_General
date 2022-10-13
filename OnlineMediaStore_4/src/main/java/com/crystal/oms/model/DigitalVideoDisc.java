package com.crystal.oms.model;

import com.crystal.oms.model.media.Category;
import com.crystal.oms.model.media.Media;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
//@JsonTypeName(value = "DigitalVideoDisc")
@Getter
@Setter
@NoArgsConstructor
@Data
public class DigitalVideoDisc extends Media
{
    private List<Person> director;
    private int length;

    public DigitalVideoDisc(String title, String description, Category category, long cost, LocalDate releaseDate, List<Person> director, int length) {
        super(title, description, category, cost, releaseDate);
        this.director = director;
        this.length = length;
    }

    /**
     * EX: DVD-R,DVD-RW,DVD+R,DVD+RW,DVD-RAM
     * */
   // private final String type;
}

