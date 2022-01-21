package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.entity.Gasenje_racuna;
import com.poslovnaInformatika.banka.service.GasenjeRacunaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GasenjeRacunaController {

	
	private final GasenjeRacunaService gasenjeRacunaService;
	
	@RequestMapping(value = "/gasenje_racuna")
	public ResponseEntity<List<Gasenje_racuna>> getAll() {
		
		List<Gasenje_racuna> gasenje_racuna = gasenjeRacunaService.getGasenje_racunas();
		return new ResponseEntity<List<Gasenje_racuna>>(gasenje_racuna, HttpStatus.OK);
		
		
		
	}
	
	
	
	
	

}
