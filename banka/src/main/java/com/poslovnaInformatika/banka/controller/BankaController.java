package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}

