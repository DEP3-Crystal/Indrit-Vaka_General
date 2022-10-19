package com.crystal.oms.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@Data
public class Person {
    private LocalDate birthDay;
    private String firstName;
    private String lastName;
    private LocalDate deathDay = null;

    public Person(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }

    public Person(String firstName, String lastName, LocalDate birthDay, LocalDate deathDay) {
        this(firstName, lastName, birthDay);
        this.deathDay = deathDay;
    }

    @JsonIgnore
    public int getAge() {
        return deathDay != null ? deathDay.getYear() - birthDay.getYear() : LocalDate.now().getYear() - birthDay.getYear();
    }

}
