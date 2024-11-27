package com.aluraJavaSpring.MusicHubJava.repository;

import com.aluraJavaSpring.MusicHubJava.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This interface represents a repository for managing singers.
 */
public interface SingerRepository extends JpaRepository<Singer,Long> {
    /**
     * Finds a singer by their name.
     *
     * @param name The name of the singer to search for.
     * @return An Optional containing the singer if found, otherwise empty.
     */
    Optional<Singer> findSingerByName (String name);
}
