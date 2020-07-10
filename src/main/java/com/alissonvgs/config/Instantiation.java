package com.alissonvgs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alissonvgs.domain.Inventario;
import com.alissonvgs.domain.Localizacao;
import com.alissonvgs.domain.Rebelde;
import com.alissonvgs.repositories.InventarioRepository;
import com.alissonvgs.repositories.LocalizacaoRepository;
import com.alissonvgs.repositories.RebeldeRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private RebeldeRepository RebeldeRepository;
	
	@Autowired
	private LocalizacaoRepository LocalizacaoRepository;
	
	@Autowired
	private InventarioRepository InventarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		RebeldeRepository.deleteAll();
		LocalizacaoRepository.deleteAll();
		InventarioRepository.deleteAll();
		
		Localizacao loc1 = new Localizacao(null, 1000, 2000, "Norte");
		Inventario inv1 = new Inventario(null, 10, "arma");
		LocalizacaoRepository.save(loc1);
		InventarioRepository.save(inv1);
		
		Rebelde reb = new Rebelde(null, "alisson", 19, "male", loc1, inv1);
		RebeldeRepository.save(reb);
		
	}

}
