package com.aston.internship.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DetailsDTO {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String phone;
    private String email;
    private AppRole role;
}
