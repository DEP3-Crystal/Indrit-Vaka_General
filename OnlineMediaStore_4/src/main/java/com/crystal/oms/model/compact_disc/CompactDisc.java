package com.crystal.oms.model.compact_disc;

import com.crystal.oms.model.Disc;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CompactDisc extends Disc {
    private String artist;
    /**
     * The physic size of the CompactDisc
     * */
    private Definition definition;
    private List<Tracks> tracks;

    public CompactDisc(int capacityMb, String type, String artist, Definition definition, List<Tracks> tracks) {
        super(capacityMb, type);
        this.artist = artist;
        this.definition = definition;
        this.tracks = tracks;
    }
}
