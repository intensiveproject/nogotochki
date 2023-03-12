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

    public static TestDetails TestDetailsBuilder(){
        return TestDetails.builder()
                .name("test_name")
                .surname("test_surname")
                .login("test_login")
                .password("test_password")
                .phone("89998887766")
                .email("test_email")
                .build();
    }
}
