package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.dto.TransakcijaDTO;

import com.poslovnaInformatika.banka.entity.Transakcija;

import com.poslovnaInformatika.banka.service.TransakcijaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TransakcijaController {

	
	private final TransakcijaService transakcijaService;

	@RequestMapping(value = "/transakcije")
	public ResponseEntity<List<Transakcija>> getAll(){
		List<Transakcija> transakcije = transakcijaService.getTransakcije();
		
		return new ResponseEntity<List<Transakcija>>(transakcije, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transakcija/{id}")
	public ResponseEntity<Transakcija> getOne(@PathVariable Long id){
		
		Transakcija transakcija = transakcijaService.getTransakcijaById(id);
		
		if(transakcija == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Transakcija>(transakcija, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/addTransakcija")
	public ResponseEntity<?> save(@RequestBody TransakcijaDTO dto) {
		if (dto.getSifraPlacanja() == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		Transakcija transakcija = new Transakcija();
		transakcija.setDuznik(dto.getDuznik());
		transakcija.setSvrhaPlacanja(dto.getSvrhaPlacanja());
		transakcija.setPrimalac(dto.getPrimalac());
		transakcija.setIznos(dto.getIznos());
		transakcija.setSifraPlacanja(dto.getSifraPlacanja());
		transakcija.setRacunDuznika(dto.getRacunDuznika());
		transakcija.setModelDuznika(dto.getModelDuznika());
		transakcija.setPozivNaBrojDuznika(dto.getPozivNaBrojDuznika());
		transakcija.setRacunPrimaoca(dto.getRacunPrimaoca());
		transakcija.setModelPrimaoca(dto.getModelPrimaoca());
		transakcija.setPozivNaBrojPrimaoca(dto.getPozivNaBrojPrimaoca());
		transakcija.setHitno(dto.getHitno());
		transakcija.setDatum(dto.getDatum());
		transakcijaService.saveTransakcija(transakcija);
		return new ResponseEntity<>(new TransakcijaDTO(transakcija), HttpStatus.OK);
	}


	@GetMapping("/transakcijaById/{id}")
	public Transakcija findTransakcijaById(@PathVariable long id) {
		return transakcijaService.getTransakcijaById(id);
	}

}
