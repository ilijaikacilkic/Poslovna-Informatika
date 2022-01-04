package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.entity.Transakcija;
import com.poslovnaInformatika.banka.repository.TransakcijaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransakcijaService {

	
	private final TransakcijaRepository transakcijaRepository;

	public List<Transakcija> getTransakcije() {
		List<Transakcija> transakcije = transakcijaRepository.findAll();
		return transakcije;
	}

	public Transakcija getTransakcijaById(Long id) {
		return transakcijaRepository.findById(id).orElse(null);
	}

	public Transakcija addTransakcija(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}
	

	public void deleteTransakcija(long id) {
		transakcijaRepository.deleteById(id);
	}

	public Transakcija saveTransakcija(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}
}
