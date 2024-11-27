package com.aluraJavaSpring.MusicHubJava.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a Singer entity in the database.
 */
@Entity
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    public Singer() {
    }

    public Singer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
