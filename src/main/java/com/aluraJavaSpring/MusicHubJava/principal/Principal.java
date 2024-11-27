package com.aluraJavaSpring.MusicHubJava.principal;

import com.aluraJavaSpring.MusicHubJava.model.EMusicGenre;
import com.aluraJavaSpring.MusicHubJava.model.Singer;
import com.aluraJavaSpring.MusicHubJava.model.Song;
import com.aluraJavaSpring.MusicHubJava.service.SingerServiceImpl;
import com.aluraJavaSpring.MusicHubJava.service.SongServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private SongServiceImpl songServiceImpl;
    private SingerServiceImpl singerServiceImpl;
    private final Scanner scanner = new Scanner(System.in);

    public Principal(SongServiceImpl songServiceImpl, SingerServiceImpl singerServiceImpl) {
        this.songServiceImpl = songServiceImpl;
        this.singerServiceImpl = singerServiceImpl;
    }
    /**
     * This method displays a menu to register singer and song data and search for songs by singers.
     */
    public void showMenu() {
        int option = -1;


        while (option != 0) {
            String menu = """
                1 - Register Singer
                2 - Register Song
                3 - Search Songs by Singer
                0 - Exit
                """;
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerSinger();
                    break;
                case 2:
                    registerSong();
                    break;
                case 3:
                    searchSongsBySinger();
                    break;
                case 0:
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * This method allows the user to register singer data by providing name and songs.
     */
    private void registerSinger() {
        String name = getValidatedStringInput("Enter the name of the singer:", "Invalid name. Please try again.");
        Singer newSinger = new Singer(name);
        singerServiceImpl.registerSinger(newSinger);
    }

    /**
     * This method allows the user to register song data by providing title, album, year, genre, and singer.
     */
    private void registerSong() {
        String title, album;
        int year;
        EMusicGenre genre;
        Singer singer;

        title = getValidatedStringInput("Enter the title of the song:", "Invalid title. Please try again.");

        album = getValidatedStringInput("Enter the album of the song:","Invalid album. Please try again.");

        year = getValidatedIntegerInput("Enter the year of the song:",  "Invalid year. Please enter a valid year.");

        genre = getValidatedGenreInput("Enter the genre of the song:", "Invalid genre. Please enter a valid genre.");

        singer = getValidatedSingerInput("Enter the name of the singer for this song:", "Singer not found. Please try again.");

        Song newSong = new Song(title, album, year, genre, singer);
        songServiceImpl.registerSong(newSong);
    }

    /**
     * Gets a validated string input from the user.
     *
     * @param prompt       The message prompting the user for input.
     * @param errorMessage The error message to display if the input is invalid.
     * @return The validated string input from the user.
     */
    private String getValidatedStringInput(String prompt, String errorMessage) {
        boolean isValid = false;
        String field = "";
        while (!isValid) {
            System.out.println(prompt);
            field = scanner.nextLine();
            isValid = validateStringInput(field, errorMessage);
        }
        return field;
    }

    /**
     * Gets a validated integer input from the user.
     *
     * @param prompt       The message prompting the user for input.
     * @param errorMessage The error message to display if the input is invalid.
     * @return The validated integer input from the user.
     */
    public int getValidatedIntegerInput(String prompt, String errorMessage) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }

    /**
     * Validates and retrieves a music genre input from the user.
     *
     * @param prompt       The message prompting the user for the genre input.
     * @param errorMessage The error message to display if the input genre is invalid.
     * @return The validated EMusicGenre input from the user.
     */
    public EMusicGenre getValidatedGenreInput(String prompt, String errorMessage) {
        EMusicGenre genre = EMusicGenre.UNKNOWN;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            String genreInput = scanner.nextLine();
            try {
                genre = EMusicGenre.valueOf(genreInput.trim().toUpperCase());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }

        return genre;
    }

    /**
     * Validates and retrieves a singer from the user.
     *
     * @param prompt       The message prompting the user for the singer input.
     * @param errorMessage The error message to display if the input singer is invalid.
     * @return The validated Singer input from the user.
     */
    private Singer getValidatedSingerInput(String prompt, String errorMessage) {
        Singer singer = new Singer();
        boolean isValidSinger = false;

        while (!isValidSinger) {
            System.out.println(prompt);
            String singerName = scanner.nextLine();
            Optional<Singer> singerFind = singerServiceImpl.findSingerByName(singerName);
            if (singerFind.isPresent()) {
                singer = singerFind.get();
                isValidSinger = true;
            } else {
                System.out.println(errorMessage);
            }
        }

        return singer;

    }

    /**
     * Validates the input string to check if it is not empty.
     *
     * @param input       The input string to validate.
     * @param errorMessage The error message to display if the input is empty.
     * @return {@code true} if the input is valid (not empty), {@code false} otherwise.
     */
    private boolean validateStringInput(String input, String errorMessage) {
        boolean isValid = !input.isEmpty();
        if (!isValid) {
            System.out.println(errorMessage);
        }
        return isValid;
    }

    /**
     * This method allows the user to search for songs by a specific singer by entering the singer's name.
     */
    private void searchSongsBySinger() {
        System.out.println("Enter the name of the singer to search for songs:");
        String singerName = scanner.nextLine();

        Optional<Singer> optionalSinger = singerServiceImpl.findSingerByName(singerName);

        if (optionalSinger.isPresent()) {
            Long singerId = optionalSinger.get().getId();

            List<Song> songs = songServiceImpl.findSongsBySingerId(singerId);

            if (!songs.isEmpty()) {
                System.out.println("Songs by " + singerName + ":");
                for (Song song : songs) {
                    System.out.println(song.getTitle() + " - " + song.getAlbum() + " (" + song.getYear() + ")");
                }
            } else {
                System.out.println("No songs found for " + singerName);
            }
        } else {
            System.out.println("Singer not found. Please try again.");
        }
    }


}
