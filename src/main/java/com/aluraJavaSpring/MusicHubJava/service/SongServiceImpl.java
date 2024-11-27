package com.aluraJavaSpring.MusicHubJava.service;


import com.aluraJavaSpring.MusicHubJava.model.Song;
import com.aluraJavaSpring.MusicHubJava.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing songs.
 */
@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    private SongRepository songRepository;

    @Override
    public void registerSong(Song song) {
        try {
            songRepository.save(song);
            System.out.println("Song registered successfully.");
        } catch (Exception ex) {
            System.out.println("Error registering song.");
        }
    }

    @Override
    public List<Song> findSongsBySingerId(Long singerId) {
        return songRepository.findBySingerId(singerId);
    }

}
