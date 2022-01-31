package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.entity.Poruka;
import com.poslovnaInformatika.banka.repository.PorukaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PorukaService {
	
	private final PorukaRepository porukaRepository;

	
	public List<Poruka> getAllPoruke(){
		List<Poruka> poruke = porukaRepository.findAll();
		return poruke;
	}
	
	public Poruka getPoruka(Long id) {
		return porukaRepository.findById(id).orElse(null);
	}
	
	public Poruka savePoruka(Poruka poruka) {
		return porukaRepository.save(poruka);
	}
	
	
	
}
