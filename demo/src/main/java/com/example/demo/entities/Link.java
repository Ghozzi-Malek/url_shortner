package com.example.demo.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "Link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private @Getter @Setter Long id;

    @Column(name = "long_form")
    private @Getter @Setter String long_form;
    @Column(name = "short_form")
    private @Getter @Setter String short_form;
    @Column(name = "prefix")
    private @Getter @Setter String prefix;
    @Column(name = "duration")
    private @Getter @Setter String duration;

    
}
