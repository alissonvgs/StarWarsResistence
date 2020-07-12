package com.alissonvgs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alissonvgs.domain.Inventario;
import com.alissonvgs.domain.Localizacao;
import com.alissonvgs.domain.Rebelde;
import com.alissonvgs.domain.TraidorReport;
import com.alissonvgs.repositories.InventarioRepository;
import com.alissonvgs.repositories.LocalizacaoRepository;
import com.alissonvgs.repositories.RebeldeRepository;
import com.alissonvgs.repositories.TraidorReportRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private RebeldeRepository RebeldeRepository;
	
	@Autowired
	private LocalizacaoRepository LocalizacaoRepository;
	
	@Autowired
	private InventarioRepository InventarioRepository;
	
	@Autowired
	private TraidorReportRepository TraidorReportRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		RebeldeRepository.deleteAll();
		LocalizacaoRepository.deleteAll();
		InventarioRepository.deleteAll();
		TraidorReportRepository.deleteAll();
		
		Localizacao loc1 = new Localizacao(null, 1000, 2000, "Norte");
		Inventario inv1 = new Inventario(null, 10, "arma");
		Localizacao loc2 = new Localizacao(null, 9, 22, "Sul");
		Inventario inv2 = new Inventario(null, 2, "Agua");
		
		LocalizacaoRepository.save(loc1);
		InventarioRepository.save(inv1);
		LocalizacaoRepository.save(loc2);
		InventarioRepository.save(inv2);
		
		Rebelde reb1 = new Rebelde(null, "alisson", 19, "male", loc1, inv1);
		Rebelde reb2 = new Rebelde(null, "José", 29, "male", loc2, inv2);
		RebeldeRepository.save(reb1);
		RebeldeRepository.save(reb2);
		
		TraidorReport tra1 = new TraidorReport(null, reb2, reb1);
		
	}

}
