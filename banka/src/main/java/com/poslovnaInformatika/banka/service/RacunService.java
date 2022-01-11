package com.poslovnaInformatika.banka.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.dto.BankaDTO;
import com.poslovnaInformatika.banka.dto.KlijentDTO;
import com.poslovnaInformatika.banka.dto.RacunDTO;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.repository.RacunRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RacunService {
	
	
	private final RacunRepository racunRepository;
	private final KlijentService klijentService;
	private final BankaService bankaService;
	
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
	
	
	//prebacivanje Racuna u DTO klasu
	public RacunDTO getRacunDTO(Racun racun) {
		RacunDTO racunDTO = new RacunDTO(racun);
		return racunDTO;
	}
	
	//provera da li klijent ima racun
	public RacunDTO getKlijentRacun(Klijent klijent, Racun racun) {
		
		KlijentDTO klijentDTO = klijentService.getKlinetDTO(klijent);
		RacunDTO racunDTO = this.getRacunDTO(racun);
		
		List<RacunDTO> racuniDTO = klijentDTO.getRacuni();
		
		for (RacunDTO racunProvera : racuniDTO) {
			
			if(racunProvera.getBrojRacuna().equals(racunDTO.getBrojRacuna())) {
				return racunDTO;
			}
		}
		return null;
	}

	//provera da li banka ima racun
	public RacunDTO getBankaRacun(Banka banka, Racun racun) {
		
		BankaDTO bankaDTO = bankaService.getBankaDTO(banka);
		RacunDTO racunDTO = this.getRacunDTO(racun);
		
		List<RacunDTO> racuniDTO = bankaDTO.getRacuni();
		
		for (RacunDTO racunProvera : racuniDTO) {
			
			if(racunProvera.getBrojRacuna().equals(racunDTO.getBrojRacuna())) {
				return racunDTO;
			}
		}
		return null;
	}
}
