package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.dto.KlijentDTO;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.service.KlijentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class KlijentController {

	
	private final KlijentService klijentService;
	
	@RequestMapping(value = "/klijenti")
	public ResponseEntity<List<KlijentDTO>> getAll(){
		List<Klijent> klijenti = klijentService.getAllklijent();
		
		List<KlijentDTO> klijentiDTO = klijentService.getAllKlijentDTO(klijenti);
		
		return new ResponseEntity<List<KlijentDTO>>(klijentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/klijent/{id}")
	public ResponseEntity<KlijentDTO> getOne(@PathVariable Long id){
		
		Klijent k = klijentService.getKlijent(id);
		
		if(k == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		KlijentDTO klijentDTO = klijentService.getKlinetDTO(k);
		
		return new ResponseEntity<KlijentDTO>(klijentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addKlijent",method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<KlijentDTO> addKlijent(@RequestBody KlijentDTO klijentDTO){
		Klijent klijent = new Klijent();
		
		klijent.setNaziv(klijentDTO.getNaziv());
		klijent.setIme(klijentDTO.getIme());
		klijent.setPrezime(klijentDTO.getPrezime());
		klijent.setEmail(klijentDTO.getEmail());
		klijent.setAdresa(klijentDTO.getAdresa());
		klijent.setTelefon(klijentDTO.getTelefon());
		klijent.setJmbg(klijentDTO.getJmbg());
		klijent.setPib(klijentDTO.getPib());
		klijent.setFizickoLice(klijentDTO.isFizickoLice());
		
		klijentService.saveKlijent(klijent);
		
		return new ResponseEntity<KlijentDTO>(klijentDTO, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/deleteKlijent/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<?> deleteKlijenta(@PathVariable Long id){
		klijentService.deleteKlijent(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
