package com.aston.internship.entity;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Embeddable
public class Details {

    private String name;
    private String surname;
    private String phone;
    private String email;

    public Details() {
    }
}
