package com.poslovnaInformatika.banka.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.dto.RacunDTO;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.entity.Valuta;
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
	
	public Racun saveRacun(Banka b, Klijent k, Valuta v) {
		
		Racun noviRacun = new Racun();
		
		String brojRacuna = this.generateBrojRacuna(b);
		
		noviRacun.setBrojRacuna(brojRacuna);
		noviRacun.setStanjeRacuna(0);
		noviRacun.setRezevisanIznos(0);
		noviRacun.setDatumKreiranja(new Date());
		noviRacun.setAktivan(false);
		noviRacun.setOdobren(false);
		
		noviRacun.setBanka(b);
		noviRacun.setKlijent(k);
		noviRacun.setValuta(v);
		
		return racunRepository.save(noviRacun);
	}
	
	public void deleteRacun(long id) {
		racunRepository.deleteById(id);
	}
	
	public Racun getByBrojRacuna(String brojRacuna) {
        return racunRepository.findBybrojRacuna(brojRacuna);
    }
	
	public List<Racun> getAllKlijentRacuniAktivni(Long idKlijenta, boolean aktivan, boolean odobren){
		
		List<Racun> aktivniRacuniKlijenta = racunRepository.getByKlijentIdAndAktivanAndOdobren(idKlijenta, aktivan,odobren);
		
		return aktivniRacuniKlijenta;
	}
	public List<Racun> getAllBankaRacuniAktivni(Long idBanka, boolean aktivan, boolean odobren){
		
		List<Racun> aktivniRacuniKlijenta = racunRepository.getByBankaIdAndAktivanAndOdobren(idBanka, aktivan, odobren);
		
		return aktivniRacuniKlijenta;
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
	
	//prebacivanje liste racuna klijenta-banke u racuneDTO
	public List<RacunDTO> getRacuneDTOKlijentBanka(List<Racun> racuni) {
		
		if(racuni == null) {
			return null;
		}
		
		List<RacunDTO> racuniDTO = new ArrayList<RacunDTO>();
		
		for (Racun racun : racuni) {
			RacunDTO racunDTO = new RacunDTO(racun);
			racuniDTO.add(racunDTO);
		}
		
		return racuniDTO;
		
	}

}
