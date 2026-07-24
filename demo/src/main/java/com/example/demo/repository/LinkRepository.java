package com.example.demo.repository;

import com.example.demo.entities.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByShortForm(String shortForm);

    @Query("select case when count(l) > 0 then true else false end from Link l where l.shortForm = ?1")
    boolean existsByShortForm(String shortForm);
}
