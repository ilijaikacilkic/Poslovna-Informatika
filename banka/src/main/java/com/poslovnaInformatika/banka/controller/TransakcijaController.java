package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.dto.TransakcijaDTO;
import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.entity.Transakcija;
import com.poslovnaInformatika.banka.entity.Valuta;
import com.poslovnaInformatika.banka.service.RacunService;
import com.poslovnaInformatika.banka.service.TransakcijaService;
import com.poslovnaInformatika.banka.service.ValutaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TransakcijaController {

	private final TransakcijaService transakcijaService;
	
	private final ValutaService valutaService;

	private final RacunService racunService;

	@RequestMapping(value = "/transakcije")
	public ResponseEntity<List<TransakcijaDTO>> getTranskacije() {
		List<Transakcija> transakcije = transakcijaService.getTransakcije();
		
		List<TransakcijaDTO> transakcijeDTO = transakcijaService.getTransakcijeDTO(transakcije);

		return new ResponseEntity<List<TransakcijaDTO>>(transakcijeDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/transakcija/{id}")
	public ResponseEntity<TransakcijaDTO> getOne(@PathVariable Long id) {

		Transakcija transakcija = transakcijaService.getTransakcijaById(id);

		if (transakcija == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		TransakcijaDTO transakcijaDTO = transakcijaService.getTransakcijaDTO(transakcija);

		return new ResponseEntity<TransakcijaDTO>(transakcijaDTO, HttpStatus.OK);
	}	


	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/addTransakcija")
	public ResponseEntity<?> save(@RequestBody TransakcijaDTO dto) {
		Racun racunPrimaoca = racunService.getByBrojRacuna(dto.getRacunPrimaoca().getBrojRacuna());
		if (racunPrimaoca == null)
			return new ResponseEntity<>("Nepostojeci racun primaoca!", HttpStatus.NOT_FOUND);
		Valuta valuta = valutaService.getValutaById(dto.getValuta().getId());
		if (valuta == null)
			return new ResponseEntity<>("Nepostojeca valuta!", HttpStatus.NOT_FOUND);
		if ((dto.getRacunDuznika().getStanjeRacuna() - dto.getRacunDuznika().getRezevisanIznos()) - dto.getIznos() < 0)
			return new ResponseEntity<>("Nemate dovoljno novca na racunu!", HttpStatus.NOT_FOUND);
		Racun racunDuznika = racunService.getRacun(dto.getRacunDuznika().getId());

		if (racunDuznika.getBanka().getId() == racunPrimaoca.getBanka().getId())
			transakcijaService.saveTransakcija(dto, racunDuznika, racunPrimaoca, valuta, 2);		

		return new ResponseEntity<>(HttpStatus.OK);
	}

//		Transakcija transakcija = new Transakcija();
//		transakcija.setDuznik(dto.getDuznik());
//		transakcija.setSvrhaPlacanja(dto.getSvrhaPlacanja());
//		transakcija.setPrimalac(dto.getPrimalac());
//		transakcija.setIznos(dto.getIznos());
//		transakcija.setSifraPlacanja(dto.getSifraPlacanja());
//		transakcija.setRacunDuznika(dto.getRacunDuznika());
//		transakcija.setModelDuznika(dto.getModelDuznika());
//		transakcija.setPozivNaBrojDuznika(dto.getPozivNaBrojDuznika());
//		transakcija.setRacunPrimaoca(dto.getRacunPrimaoca());
//		transakcija.setModelPrimaoca(dto.getModelPrimaoca());
//		transakcija.setPozivNaBrojPrimaoca(dto.getPozivNaBrojPrimaoca());
//		transakcija.setHitno(dto.getHitno());
//		transakcija.setDatum(dto.getDatum());
//		transakcija.setValuta(dto.getValuta());
//		transakcijaService.saveTransakcija(transakcija);
//		return new ResponseEntity<>(new TransakcijaDTO(transakcija), HttpStatus.OK);

	

}
