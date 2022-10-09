package com.crystal.oms.model.book;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class Author
{
    private String firstName;
    private String lastName;
    private final LocalDate birthDay;
    private Optional<LocalDate> deathDay = Optional.empty();
    public int getAge(){
        return deathDay.map(localDate -> localDate.getYear() - birthDay.getYear()).orElseGet(() -> LocalDate.now().getYear() - birthDay.getYear());
    }
    public Author(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }

    public Author(String firstName, String lastName, LocalDate birthDay, Optional<LocalDate> deathDay) {
        this(firstName,lastName,birthDay);
        this.deathDay = deathDay;
    }
}
