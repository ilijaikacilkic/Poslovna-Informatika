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

import com.poslovnaInformatika.banka.dto.BankaDTO;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.service.BankaService;

import lombok.RequiredArgsConstructor;

@RestController	
@RequiredArgsConstructor
public class BankaController {

	
	private final BankaService bankaService;


	@RequestMapping(value = "/banke")
	public ResponseEntity<List<BankaDTO>> getAll(){
		List<Banka> banke = bankaService.getBanke();
		
		List<BankaDTO> bankeDTO = bankaService.getAllBankeDTO(banke);
	
		return new ResponseEntity<List<BankaDTO>>(bankeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/banka/{id}")
	public ResponseEntity<BankaDTO> getOne(@PathVariable Long id){
		
		Banka banka = bankaService.getBankaById(id);
		
		if(banka == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		BankaDTO bankaDTO = bankaService.getBankaDTO(banka);
		
		return new ResponseEntity<BankaDTO>(bankaDTO, HttpStatus.OK);
	}

	@PostMapping("/addBanka")
	public ResponseEntity<BankaDTO> addBanka(@RequestBody BankaDTO bankaDTO) {
		Banka banka = new Banka();
		
		banka.setSifraBanke(bankaDTO.getSifraBanke());
		banka.setAdresa(bankaDTO.getAdresa());
		banka.setTelefon(bankaDTO.getTelefon());
		banka.setFax(bankaDTO.getFax());
		banka.setSwiftKod(bankaDTO.getSwiftKod());
		
		bankaService.saveBanka(banka);
		
		return new ResponseEntity<BankaDTO>(bankaDTO, HttpStatus.CREATED);
	}


	@GetMapping("/bankaById/{id}")
	public Banka findBankaById(@PathVariable long id) {
		return bankaService.getBankaById(id);
	}

}
