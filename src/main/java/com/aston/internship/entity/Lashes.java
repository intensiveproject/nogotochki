package com.aston.internship.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "LASHES")
@AllArgsConstructor
@Data

public class Lashes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String type;
    String form;
    Double length;

    public Lashes() {
    }
}
