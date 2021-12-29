package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.service.KlijentService;

@RestController
public class KlijentController {

	@Autowired
	KlijentService klijentService;
	
	@RequestMapping(value = "/klijenti")
	public ResponseEntity<List<Klijent>> getAll(){
		List<Klijent> klijenti = klijentService.getAllklijent();
		
		return new ResponseEntity<List<Klijent>>(klijenti, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/klijent/{id}")
	public ResponseEntity<Klijent> getOne(@PathVariable Long id){
		
		Klijent k = klijentService.getKlijent(id);
		
		if(k == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Klijent>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addKlijent",method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Klijent> addKlijent(@RequestBody Klijent k){
		Klijent klijent = new Klijent();
		
		klijent.setNaziv(k.getNaziv());
		klijent.setIme(k.getIme());
		klijent.setPrezime(k.getPrezime());
		klijent.setEmail(k.getEmail());
		klijent.setAdresa(k.getAdresa());
		klijent.setTelefon(k.getTelefon());
		klijent.setJmbg(k.getJmbg());
		klijent.setPib(k.getPib());
		klijent.setFizickoLice(k.isFizickoLice());
		
		klijentService.saveKlijent(klijent);
		
		return new ResponseEntity<Klijent>(klijent, HttpStatus.CREATED);
		
	}
	
	
}
