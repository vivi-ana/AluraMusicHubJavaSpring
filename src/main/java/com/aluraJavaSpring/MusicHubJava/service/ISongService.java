package com.aluraJavaSpring.MusicHubJava.service;

import com.aluraJavaSpring.MusicHubJava.model.Song;

import java.util.List;

/**
 * Interface for managing songs.
 */
public interface ISongService {
    /**
     * Registers a new song.
     *
     * @param song The song to be registered.
     */
    void registerSong(Song song);

    /**
     * Finds songs by singer ID.
     *
     * @param singerId The ID of the singer whose songs are to be found.
     * @return A list of songs by the specified singer.
     */
    List<Song> findSongsBySingerId(Long singerId);
}
