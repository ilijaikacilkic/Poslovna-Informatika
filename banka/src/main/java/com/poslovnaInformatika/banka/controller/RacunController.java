package com.poslovnaInformatika.banka.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.dto.RacunDTO;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Racun;
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
	
	@RequestMapping(value = "/racun/{idRacuna}", method = RequestMethod.GET)
	public ResponseEntity<RacunDTO> getRacun(@PathVariable long idRacuna) {
		Racun racun = racunService.getRacun(idRacuna);
		
		if(racun == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		RacunDTO racunDTO = racunService.getRacunDTO(racun);
		
		return new ResponseEntity<RacunDTO>(racunDTO, HttpStatus.OK);
		
	}
	
	//svi aktivni i odobreni racuni banke
	@RequestMapping(value = "/banka/{idBanke}/racuni", method = RequestMethod.GET)
	public ResponseEntity<List<RacunDTO>> getAllRacuniBanke(@PathVariable long idBanke){
		
		Banka banka = bankaService.getBankaById(idBanke);
		if(banka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Racun> racuniBanke = racunService.getAllBankaRacuniAktivni(banka.getId(), true, true);
		
		List<RacunDTO> racuniBankeDTO = racunService.getRacuneDTOKlijentBanka(racuniBanke);
		
		if(racuniBankeDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<RacunDTO>>(racuniBankeDTO, HttpStatus.OK);
		
	}
	
	//svi aktivni i odobreni racuni klijenta
	@RequestMapping(value = "/klijent/{idKlijent}/racuni", method = RequestMethod.GET)
	public ResponseEntity<List<RacunDTO>> getAllRacuniKlijenta(@PathVariable long idKlijent){
		
		Klijent klijent = klijentService.getKlijent(idKlijent);
		if(klijent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Racun> racuniBanke = racunService.getAllBankaRacuniAktivni(klijent.getId(), true, true);
		
		List<RacunDTO> racuniBankeDTO = racunService.getRacuneDTOKlijentBanka(racuniBanke);
		
		if(racuniBankeDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<RacunDTO>>(racuniBankeDTO, HttpStatus.OK);
		
	}
	
//	//svi racuni banke za odobrenje
//	@RequestMapping(value = "banka/{id}/neodobreniRacuni", method = RequestMethod.GET)
//	public ResponseEntity<List<RacunDTO>> getAllNeodobreneRacuneBanke(@PathVariable long idBanke){
//		Banka banka = bankaService.getBankaById(idBanke);
//		if(banka == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return null;
//		
//		
//	}
	
	
	@RequestMapping(value = "/deleteRacun/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRacun(@PathVariable Long id){
		racunService.deleteRacun(id);
		return new ResponseEntity<>("obrisan racun", HttpStatus.OK);
	}
	
}
