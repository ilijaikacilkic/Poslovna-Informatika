package com.poslovnaInformatika.banka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.dto.ValutaDTO;
import com.poslovnaInformatika.banka.entity.Valuta;
import com.poslovnaInformatika.banka.repository.ValutaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValutaService {

	private final ValutaRepository valutaRepository;

	public List<Valuta> getValute() {
		List<Valuta> valute = valutaRepository.findAll();
		return valute;
	}

	public Valuta getValutaById(Long id) {
		return valutaRepository.findById(id).orElse(null);
	}

	public Valuta addValuta(Valuta valuta) {
		return valutaRepository.save(valuta);
	}

	
	public void deleteValuta(Long id) {
		valutaRepository.deleteById(id);
	}

	public Valuta saveValuta(Valuta valuta) {
		return valutaRepository.save(valuta);
	}
	
	public ValutaDTO getValutaDTO(Valuta valuta) {
		ValutaDTO valutaDTO = new ValutaDTO(valuta);
		return valutaDTO;
	}
	
	public List<ValutaDTO> getValuteDTO(List<Valuta> valute){
		List<ValutaDTO> valuteDTO = new ArrayList<ValutaDTO>();
		for(Valuta valuta : valute) {
			ValutaDTO valutaDTO = new ValutaDTO(valuta);			
			valuteDTO.add(valutaDTO);
		}
		return valuteDTO;
	}
	public List<ValutaDTO> getAllDTOs(List<Valuta> valute) {
		List<ValutaDTO> dtos = new ArrayList<>();
		for (Valuta valuta : valute) {
			ValutaDTO dto = new ValutaDTO(valuta);
			dto.setRacuniListFromSet(valuta.getRacuni());		
			dto.setTransakcijeListFromSet(valuta.getTransakcije());
			dtos.add(dto);
		}
		return dtos;
	}

	


}
