package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.service.BankaService;

import lombok.RequiredArgsConstructor;

@RestController	
@RequiredArgsConstructor
public class BankaController {

	
	private final BankaService bankaService;

	@RequestMapping(value = "/banke")
	public ResponseEntity<List<Banka>> getAll(){
		List<Banka> banke = bankaService.getBanke();
		
		return new ResponseEntity<List<Banka>>(banke, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/banka/{id}")
	public ResponseEntity<Banka> getOne(@PathVariable Long id){
		
		Banka banka = bankaService.getBankaById(id);
		
		if(banka == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Banka>(banka, HttpStatus.OK);
	}

	@PostMapping("/addBanka")
	public Banka addBanka(@RequestBody Banka banka) {
		return bankaService.saveBanka(banka);
	}


	@GetMapping("/bankaById/{id}")
	public Banka findBankaById(@PathVariable long id) {
		return bankaService.getBankaById(id);
	}

}
