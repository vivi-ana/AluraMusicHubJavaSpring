package com.aluraJavaSpring.MusicHubJava.model;

import jakarta.persistence.*;

/**
 * Represents a Song entity in the database.
 */
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String album;
    private int year;

    @Enumerated(EnumType.STRING)
    private EMusicGenre genre;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    public Song() {
    }

    public Song(String title, String album, int year, EMusicGenre genre, Singer singer) {
        this.title = title;
        this.album = album;
        this.year = year;
        this.genre = genre;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public int getYear() {
        return year;
    }
}
