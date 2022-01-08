package com.poslovnaInformatika.banka.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.dto.DelatnostDTO;
import com.poslovnaInformatika.banka.entity.Delatnost;
import com.poslovnaInformatika.banka.service.DelatnostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DelatnostController {

	private final DelatnostService delatnostService;

	@RequestMapping(value = "/delatnosti")
	public ResponseEntity<List<Delatnost>> getAll() {
		List<Delatnost> delatnosti = delatnostService.getDelatnosti();

		return new ResponseEntity<List<Delatnost>>(delatnosti, HttpStatus.OK);
	}

	@RequestMapping(value = "/delatnost/{id}")
	public ResponseEntity<Delatnost> getOne(@PathVariable Long id) {

		Delatnost delatnost = delatnostService.getDelatnostById(id);

		if (delatnost == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Delatnost>(delatnost, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/addDelatnost")
	public ResponseEntity<?> save(@RequestBody DelatnostDTO dto) {
		if (dto.getSifra() == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		Delatnost delatnost = new Delatnost();
		delatnost.setSifra(dto.getSifra());
		delatnost.setNaziv(dto.getNaziv());

		delatnostService.saveDelatnost(delatnost);
		return new ResponseEntity<>(new DelatnostDTO(delatnost), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/updateDelatnost/{id}")
	public ResponseEntity<?> update(@RequestBody DelatnostDTO dto) {
		Delatnost delatnost = delatnostService.getDelatnostById(dto.getId());
		if (delatnost == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		delatnost.setNaziv(dto.getNaziv());

		delatnostService.saveDelatnost(delatnost);
		return new ResponseEntity<>(new DelatnostDTO(delatnost), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteDelatnost/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Delatnost delatnost = delatnostService.getDelatnostById(id);
		if (delatnost != null) {
			delatnostService.deleteDelatnost(id);
			List<Delatnost> delatnosti = delatnostService.getDelatnosti();
			List<DelatnostDTO> dtos = delatnostService.getAllDTOs(delatnosti);

			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

}
