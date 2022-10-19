package com.crystal.oms.model.book;

import com.crystal.oms.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class Publisher {
    private String name;
    private List<Address> address;

    public Publisher(String name, List<Address> address) {
        this.name = name;
        this.address = address;
    }

    public Publisher() {
    }
}
