package com.aston.internship.repository;

import com.aston.internship.entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DetailsRepository extends CrudRepository<Details, Long> {
    Optional<Details> findByUsername(String username);
}
