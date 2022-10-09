package com.crystal.oms.model;

import com.crystal.oms.model.media.Media;
import lombok.Getter;

@Getter
public abstract class Disc extends Media {
    private final int capacityMb;
    /**
     * EX: DVD-R,DVD-RW,DVD+R,DVD+RW,DVD-RAM
     * */
    private final String type;

    public Disc(int capacityMb, String type) {
        this.capacityMb = capacityMb;
        this.type = type;
    }
}
