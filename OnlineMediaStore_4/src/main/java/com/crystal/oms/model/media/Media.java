package com.crystal.oms.model.media;

import com.crystal.oms.model.DigitalVideoDisc;
import com.crystal.oms.model.book.Book;
import com.crystal.oms.model.compact_disc.CompactDisc;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = Book.class, name = "book"),
                @JsonSubTypes.Type(value = DigitalVideoDisc.class, name = "dvd"),
                @JsonSubTypes.Type(value = CompactDisc.class, name = "cd")
        })
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
        ,defaultImpl = DigitalVideoDisc.class
)

@JsonRootName(value = "data")
@AllArgsConstructor
@Data
public abstract class Media {
    protected String title;
    private String description;
    protected Category category;
    protected long cost;
    private LocalDate releaseDate;

    public Media() {
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

}
