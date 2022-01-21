package com.poslovnaInformatika.banka.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Valuta;
import com.poslovnaInformatika.banka.service.BankaService;
import com.poslovnaInformatika.banka.service.KlijentService;
import com.poslovnaInformatika.banka.service.RacunService;
import com.poslovnaInformatika.banka.service.ValutaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RacunController {

	
	public final RacunService racunService;
	public final KlijentService klijentService;
	public final BankaService bankaService;
	public final ValutaService valutaService;
	
	
	
	@RequestMapping(value = "/addRacun/{idBanke}/{idKlijenta}/{idValuta}", method =RequestMethod.POST)
	public ResponseEntity<?> addRacun(@PathVariable long idBanke, @PathVariable long idKlijenta, @PathVariable long idValuta){
		
		Banka b = bankaService.getBankaById(idBanke);
		Klijent k = klijentService.getKlijent(idKlijenta);
		Valuta v = valutaService.getValutaById(idValuta);
		

		
		racunService.saveRacun(b,k,v);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value = "/deleteRacun/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRacun(@PathVariable Long id){
		racunService.deleteRacun(id);
		return new ResponseEntity<>("obrisan racun", HttpStatus.OK);
	}
	
}
