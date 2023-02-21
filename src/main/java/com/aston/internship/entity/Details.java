package com.aston.internship.entity;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Embeddable
public class Details {

    private String name;
    private String surname;

    @Size(min=5, message = "Не меньше 5 знаков")
    private String password;
    @Transient
    private String passwordConfirm;

    private String phone;
    private String email;

    public Details() {
    }
}
