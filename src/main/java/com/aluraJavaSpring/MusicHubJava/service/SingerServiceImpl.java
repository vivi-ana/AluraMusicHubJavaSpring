package com.aluraJavaSpring.MusicHubJava.service;

import com.aluraJavaSpring.MusicHubJava.model.Singer;
import com.aluraJavaSpring.MusicHubJava.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation for managing singers.
 */
@Service
public class SingerServiceImpl implements ISingerService{
    @Autowired
    private SingerRepository singerRepository;
    @Override
    public void registerSinger(Singer singer) {
        try {
            singerRepository.save(singer);
            System.out.println("Singer registered successfully.");
        } catch (Exception ex) {
            System.out.println("Error registering singer.");
        }
    }

    @Override
    public Optional<Singer> findSingerByName(String name) {
        return singerRepository.findSingerByName(name);
    }
}
