package com.aluraJavaSpring.MusicHubJava.repository;

import com.aluraJavaSpring.MusicHubJava.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This interface represents a repository for managing songs.
 */
public interface SongRepository extends JpaRepository<Song,Long> {
    /**
     * Finds songs by the ID of the singer.
     *
     * @param singerId The ID of the singer whose songs are to be retrieved.
     * @return A list of songs associated with the specified singer ID.
     */
    List<Song> findBySingerId(Long singerId);
}
