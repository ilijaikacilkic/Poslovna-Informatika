package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	


}
