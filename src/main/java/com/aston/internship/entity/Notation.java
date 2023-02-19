package com.aston.internship.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;

@Entity
@Table(name = "NOTATION")
@AllArgsConstructor
@Data

public class Notation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar calendar;

    public Notation() {

    }
}
