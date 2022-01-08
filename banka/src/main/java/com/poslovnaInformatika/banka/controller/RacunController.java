package com.poslovnaInformatika.banka.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.service.BankaService;
import com.poslovnaInformatika.banka.service.KlijentService;
import com.poslovnaInformatika.banka.service.RacunService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RacunController {

	
	public final RacunService racunService;
	public final KlijentService klijentService;
	public final BankaService bankaService;
	
	
	
	@RequestMapping(value = "/addRacun/{idBanke}/{idKlijenta}", method =RequestMethod.POST)
	public ResponseEntity<?> addRacun(@PathVariable long idBanke, @PathVariable long idKlijenta){
		
		Banka b = bankaService.getBankaById(idBanke);
		Klijent k = klijentService.getKlijent(idKlijenta);
		

		
		racunService.saveRacun(b,k);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	
}
