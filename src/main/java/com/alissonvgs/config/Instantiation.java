package com.alissonvgs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alissonvgs.domain.Rebelde;
import com.alissonvgs.repositories.LocalizacaoRepository;
import com.alissonvgs.repositories.RebeldeRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private RebeldeRepository RebeldeRepository;
	
	@Autowired
	private LocalizacaoRepository LocalizacaoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		RebeldeRepository.deleteAll();
		LocalizacaoRepository.deleteAll();
		
		Rebelde rebelde = new Rebelde(null, "alisson", 19, "male", null);
		RebeldeRepository.save(rebelde);
		
	}

}
