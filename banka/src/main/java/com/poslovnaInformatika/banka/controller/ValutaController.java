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
import com.poslovnaInformatika.banka.dto.ValutaDTO;
import com.poslovnaInformatika.banka.entity.Valuta;
import com.poslovnaInformatika.banka.service.ValutaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ValutaController {

	private final ValutaService valutaService;

	@RequestMapping(value = "/valute")
	public ResponseEntity<List<ValutaDTO>> getAll() {
		List<Valuta> valute = valutaService.getValute();
		
		List<ValutaDTO> valuteDTO = valutaService.getValuteDTO(valute);

		return new ResponseEntity<List<ValutaDTO>>(valuteDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/valuta/{id}")
	public ResponseEntity<ValutaDTO> getOne(@PathVariable Long id) {

		Valuta valuta = valutaService.getValutaById(id);

		if (valuta == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		ValutaDTO valutaDTO = valutaService.getValutaDTO(valuta);

		return new ResponseEntity<ValutaDTO>(valutaDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/addValuta")
	public ResponseEntity<?> save(@RequestBody ValutaDTO dto) {
		if (dto.getDrzava() == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		Valuta valuta = new Valuta();
		valuta.setNaziv(dto.getNaziv());
		valuta.setSkraceniNaziv(dto.getSkraceniNaziv());
		valuta.setDrzava(dto.getDrzava());
		valutaService.saveValuta(valuta);
		return new ResponseEntity<>(new ValutaDTO(valuta), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/updateValuta/{id}")
	public ResponseEntity<?> update(@RequestBody ValutaDTO dto) {
		Valuta valuta = valutaService.getValutaById(dto.getId());
		if (valuta == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		valuta.setNaziv(dto.getNaziv());
		valuta.setSkraceniNaziv(dto.getSkraceniNaziv());
		valuta.setDrzava(dto.getDrzava());

		valutaService.saveValuta(valuta);
		return new ResponseEntity<>(new ValutaDTO(valuta), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteValuta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Valuta valuta = valutaService.getValutaById(id);
		if (valuta != null) {
			valutaService.deleteValuta(id);
			List<Valuta> valute = valutaService.getValute();
			List<ValutaDTO> dtos = valutaService.getAllDTOs(valute);

			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else		
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}

}
