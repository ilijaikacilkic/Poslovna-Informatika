package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.poslovnaInformatika.banka.entity.Transakcija;
import com.poslovnaInformatika.banka.service.TransakcijaService;

@RestController
public class TransakcijaController {

	@Autowired
	private TransakcijaService transakcijaService;

	@GetMapping("/transakcije")
	public List<Transakcija> findAllTransakcije() {
		return transakcijaService.getTransakcije();
	}

	@PostMapping("/addTransakcija")
	public Transakcija addTransakcija(@RequestBody Transakcija transakcija) {
		return transakcijaService.saveTransakcija(transakcija);
	}

	@PostMapping("/addTransakcije")
	public List<Transakcija> addTransakcija(@RequestBody List<Transakcija> transakcije) {
		return transakcijaService.saveTransakcije(transakcije);
	}

	@GetMapping("/transakcijaById/{id}")
	public Transakcija findTransakcijaById(@PathVariable long id) {
		return transakcijaService.getTransakcijaById(id);
	}

}
