package com.crystal.oms.model.compact_disc;

import lombok.Data;

@Data
public class Tracks {
    private String title;
    private int length;
    /**
     * Type of the track EX: audio, Photo
    * */
    private String type;
}
