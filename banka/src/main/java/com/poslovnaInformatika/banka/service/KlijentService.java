package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
