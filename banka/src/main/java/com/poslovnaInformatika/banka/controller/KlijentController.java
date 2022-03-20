package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.dto.KlijentDTO;
import com.poslovnaInformatika.banka.dto.RegistracijaDTO;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Korisnik;
import com.poslovnaInformatika.banka.service.KlijentService;
import com.poslovnaInformatika.banka.service.KorisnikService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class KlijentController {

	
	private final KlijentService klijentService;
	
	private final KorisnikService korisnikService;
	
	private final PasswordEncoder passwordEncoder;
	
	@CrossOrigin("*")
	@RequestMapping(value = "/klijenti")
	public ResponseEntity<List<KlijentDTO>> getAll(){
		List<Klijent> klijenti = klijentService.getAllklijent();
		
		List<KlijentDTO> klijentiDTO = klijentService.getAllKlijentDTO(klijenti);
		
		return new ResponseEntity<List<KlijentDTO>>(klijentiDTO, HttpStatus.OK);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/klijent/{id}")
	public ResponseEntity<KlijentDTO> getOne(@PathVariable Long id){
		
		Klijent k = klijentService.getKlijent(id);
		
		if(k == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		KlijentDTO klijentDTO = klijentService.getKlinetDTO(k);
		
		return new ResponseEntity<KlijentDTO>(klijentDTO, HttpStatus.OK);
	}

	
	@CrossOrigin("*")
	@RequestMapping(value = "/addKlijent",method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RegistracijaDTO> addKlijent(@RequestBody RegistracijaDTO registracijaDTO){
		Klijent klijent = new Klijent();
		Korisnik korisnik = new Korisnik();
		
		klijent.setIme(registracijaDTO.getIme());
		klijent.setPrezime(registracijaDTO.getPrezime());
		klijent.setEmail(registracijaDTO.getEmail());
		klijent.setAdresa(registracijaDTO.getAdresa());
		klijent.setTelefon(registracijaDTO.getTelefon());
		klijent.setJmbg(registracijaDTO.getJmbg());
		klijent.setFizickoLice(registracijaDTO.getFizickoLice());
		klijent.setDelatnost(registracijaDTO.getDelatnost());
		
		korisnik.setUsername(registracijaDTO.getUsername());
		korisnik.setPassword(passwordEncoder.encode(registracijaDTO.getPassword()));
		
		Klijent sacuvaniKlijent = klijentService.saveKlijent(klijent);
		korisnik.setKlijent(sacuvaniKlijent);
//		klijentService.saveKlijent(klijent);
		korisnikService.saveKorisnik(korisnik);
		
		return new ResponseEntity<RegistracijaDTO>(registracijaDTO, HttpStatus.CREATED);
		
		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/deleteKlijent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteKlijenta(@PathVariable Long id){
		klijentService.deleteKlijent(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
