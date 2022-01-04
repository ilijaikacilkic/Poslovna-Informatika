package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public Racun saveRacun(Racun r) {
		return racunRepository.save(r);
	}
	
	public void deleteRacun(long id) {
		racunRepository.deleteById(id);
	}

}
