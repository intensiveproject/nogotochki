package com.aston.internship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TestDetails{
    String name;
    String surname;
    String login;
    String password;
    String phone;
    String email;
}
