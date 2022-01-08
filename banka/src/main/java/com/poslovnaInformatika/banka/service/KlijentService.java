package com.poslovnaInformatika.banka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.dto.KlijentDTO;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.repository.KlijentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KlijentService {
	
	
	private final KlijentRepository klijentRepository;
	
	public Klijent getKlijent(long id) {
		return klijentRepository.findById(id).orElse(null);
	}
	
	public List<Klijent> getAllklijent(){
		List<Klijent> klijenti = klijentRepository.findAll();
		return klijenti;
	}
	
	public Klijent saveKlijent(Klijent k) {
		return klijentRepository.save(k);
	}
	
	public void deleteKlijent(long id) {
		klijentRepository.deleteById(id);
	}

	
	//prebacivanje Klijenta u DTO klasu
	public KlijentDTO getKlinetDTO(Klijent klijent) {
		KlijentDTO klijentDTO = new KlijentDTO(klijent);
		klijentDTO.setRacuniListFromSet(klijent.getRacuni());
		return klijentDTO;
	}
	
	//prebacivanje Liste klijenata u listu DTO klijenata
	public List<KlijentDTO> getAllKlijentDTO(List<Klijent> klijenti){
		List<KlijentDTO> klijentiDTO = new ArrayList<KlijentDTO>();
		for(Klijent klijent : klijenti) {
			KlijentDTO klijentDTO = new KlijentDTO(klijent);
			klijentDTO.setRacuniListFromSet(klijent.getRacuni());
			klijentiDTO.add(klijentDTO);
		}
		return klijentiDTO;
	}
	
}
