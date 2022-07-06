package com.nelioalves.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongo.domain.Person;
import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		Person maria = new Person(null, "Maria Brown", "maria@gmail.com");
		Person alex = new Person(null, "Alex Green", "alex@gmail.com");
		Person bob = new Person(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu Viagem","Vou viajar para São Paulo, abraços!",maria);
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje!",maria);
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
