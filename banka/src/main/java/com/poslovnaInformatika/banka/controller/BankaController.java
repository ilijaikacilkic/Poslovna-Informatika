package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.service.BankaService;

@RestController
public class BankaController {

	@Autowired
	private BankaService bankaService;

	@GetMapping("/banke")
	public List<Banka> findAllBanke() {
		return bankaService.getBanke();
	}

	@PostMapping("/addBanka")
	public Banka addBanka(@RequestBody Banka banka) {
		return bankaService.saveBanka(banka);
	}

	@PostMapping("/addBanke")
	public List<Banka> addBanke(@RequestBody List<Banka> banke) {
		return bankaService.saveBanke(banke);
	}

	@GetMapping("/bankaById/{id}")
	public Banka findBankaById(@PathVariable long id) {
		return bankaService.getBankaById(id);
	}

}
