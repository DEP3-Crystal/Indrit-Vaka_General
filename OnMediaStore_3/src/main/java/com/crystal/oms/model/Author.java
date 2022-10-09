package com.crystal.oms.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author
{
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
