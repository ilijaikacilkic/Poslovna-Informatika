package com.poslovnaInformatika.banka.service;



import org.springframework.stereotype.Service;
import java.util.List;

import com.poslovnaInformatika.banka.dto.GasenjeRacunaDTO;
import com.poslovnaInformatika.banka.entity.Gasenje_racuna;
import com.poslovnaInformatika.banka.repository.GasenjeRacunaRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GasenjeRacunaService{
	
	private final GasenjeRacunaRepository gasenjeRacunaRepository;
	
	public Gasenje_racuna getGasenje_racuna(long id) {
		return gasenjeRacunaRepository.findById(id).orElse(null);
		
		
	}
	
	public List<Gasenje_racuna> getGasenje_racunas(){
		
		List<Gasenje_racuna> gasenje_racuna = gasenjeRacunaRepository.findAll();
		return gasenje_racuna;
		
	}
	
	public Gasenje_racuna addGasenjeRacuna(Gasenje_racuna gasenje) {
		return gasenjeRacunaRepository.save(gasenje);
	}
	
	
	
	
	
	

}
