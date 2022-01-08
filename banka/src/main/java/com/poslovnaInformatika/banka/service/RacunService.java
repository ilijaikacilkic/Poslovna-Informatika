package com.poslovnaInformatika.banka.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.repository.RacunRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RacunService {
	
	
	private final RacunRepository racunRepository;
	
	public Racun getRacun(long id) {
		return racunRepository.findById(id).orElse(null);
	}
	
	public List<Racun> getAllRacuni(){
		List<Racun> racuni = racunRepository.findAll();
		return racuni;
	}
	
	public Racun saveRacun(Banka b, Klijent k) {
		
		Racun noviRacun = new Racun();
		
		String brojRacuna = this.generateBrojRacuna(b);
		
		noviRacun.setBrojRacuna(brojRacuna);
		noviRacun.setStanjeRacuna(0);
		noviRacun.setRezevisanIznos(0);
		noviRacun.setDatumKreiranja(new Date());
		
		noviRacun.setBanka(b);
		noviRacun.setKlijent(k);
		
		return racunRepository.save(noviRacun);
	}
	
	public void deleteRacun(long id) {
		racunRepository.deleteById(id);
	}
	
	public Racun getByBrojRacuna(String brojRacuna) {
        return racunRepository.findBybrojRacuna(brojRacuna);
    }
	
	//funkcija za kreiranje broja racuna
	public String generateBrojRacuna(Banka b) {
		
		String sifraBanke = String.valueOf(b.getSifraBanke());
		
		long min = (long) Math.pow(10, 13 - 1);
		long oznakaRacuna13 = ThreadLocalRandom.current().nextLong(min, min * 10);
		String oznakaRacuna = Long.toString(oznakaRacuna13);
		
		StringBuilder brojRacuna = new StringBuilder();
		brojRacuna.append(sifraBanke);
		brojRacuna.append("-");
		brojRacuna.append(oznakaRacuna);
		brojRacuna.append("-");
		brojRacuna.append("CC");
		
		return brojRacuna.toString();
		
	}
	

}
