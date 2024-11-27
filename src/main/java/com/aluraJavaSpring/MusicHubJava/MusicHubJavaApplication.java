package com.aluraJavaSpring.MusicHubJava;

import com.aluraJavaSpring.MusicHubJava.principal.Principal;
import com.aluraJavaSpring.MusicHubJava.service.SingerServiceImpl;
import com.aluraJavaSpring.MusicHubJava.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicHubJavaApplication implements CommandLineRunner {
	@Autowired
	private SongServiceImpl songServiceImpl;
	@Autowired
	private SingerServiceImpl singerServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(MusicHubJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(songServiceImpl, singerServiceImpl);
		principal.showMenu();
	}
}
