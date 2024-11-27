package com.aluraJavaSpring.MusicHubJava.service;

import com.aluraJavaSpring.MusicHubJava.model.Singer;

import java.util.Optional;

/**
 * Interface for managing singers.
 */
public interface ISingerService {
    /**
     * Registers a new singer.
     *
     * @param singer The singer to be registered.
     */
    void registerSinger(Singer singer);

    /**
     * Finds a singer by name.
     *
     * @param name The name of the singer to find.
     * @return An Optional containing the singer if found, empty otherwise.
     */
    Optional<Singer> findSingerByName (String name);
}
