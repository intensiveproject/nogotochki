package com.aston.internship.entity;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Embeddable
public class SocialNetwork {

    private List<String> socialNetworks;

    public SocialNetwork() {
    }
}
