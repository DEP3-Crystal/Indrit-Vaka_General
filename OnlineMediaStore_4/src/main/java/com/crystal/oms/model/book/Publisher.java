package com.crystal.oms.model.book;

import com.crystal.oms.model.Address;
import lombok.Data;

@Data
public class Publisher {
    private String name;
    private Address address;

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
