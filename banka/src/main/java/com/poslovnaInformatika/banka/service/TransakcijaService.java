package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poslovnaInformatika.banka.entity.Transakcija;
import com.poslovnaInformatika.banka.repository.TransakcijaRepository;

@Service
public class TransakcijaService {

	@Autowired
	private TransakcijaRepository transakcijaRepository;

	public List<Transakcija> getTransakcije() {
		return transakcijaRepository.findAll();
	}

	public Transakcija getTransakcijaById(Long id) {
		return transakcijaRepository.findById(id).orElse(null);
	}

	public Transakcija addTransakcija(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}

	public List<Transakcija> saveTransakcije(List<Transakcija> transakcije) {
		return transakcijaRepository.saveAll(transakcije);
	}

	public void deleteTransakcija(long id) {
		transakcijaRepository.deleteById(id);
	}

	public Transakcija saveTransakcija(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}
}
