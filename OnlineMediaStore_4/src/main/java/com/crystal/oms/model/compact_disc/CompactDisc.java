package com.crystal.oms.model.compact_disc;

import com.crystal.oms.model.Person;
import com.crystal.oms.model.media.Category;
import com.crystal.oms.model.media.Media;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
//@JsonTypeName(value = CompactDisc.TYPE)
@Data
@NoArgsConstructor
public class CompactDisc extends Media {
    private List<Person> artist;
    /**
     * The physic size of the CompactDisc
     */
    private Definition definition;
    private List<Tracks> tracks;

    public CompactDisc(String title, String description, Category category, long cost, LocalDate releaseDate, List<Person> artist, Definition definition, List<Tracks> tracks) {
        super(title, description, category, cost, releaseDate);
        this.artist = artist;
        this.definition = definition;
        this.tracks = tracks;
    }
}

