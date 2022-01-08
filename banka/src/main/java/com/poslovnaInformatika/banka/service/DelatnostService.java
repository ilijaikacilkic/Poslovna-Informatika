package com.poslovnaInformatika.banka.service;

import java.util.List;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.poslovnaInformatika.banka.dto.DelatnostDTO;
import com.poslovnaInformatika.banka.entity.Delatnost;
import com.poslovnaInformatika.banka.repository.DelatnostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DelatnostService {

	private final DelatnostRepository delatnostRepository;

	public List<Delatnost> getDelatnosti() {
		return delatnostRepository.findAll();
	}

	public Delatnost getDelatnostById(Long id) {
		return delatnostRepository.findById(id).orElse(null);
	}

	public Delatnost addDelatnost(Delatnost delatnost) {
		return delatnostRepository.save(delatnost);
	}

	public void deleteDelatnost(Long id) {
		delatnostRepository.deleteById(id);
	}

	public Delatnost saveDelatnost(Delatnost delatnost) {
		return delatnostRepository.save(delatnost);
	}

	public List<DelatnostDTO> getAllDTOs(List<Delatnost> delatnosti) {

		List<DelatnostDTO> dtos = new ArrayList<>();
		for (Delatnost delatnost : delatnosti) {
			DelatnostDTO dto = new DelatnostDTO(delatnost);
			dto.setKlijentiListFromSet(delatnost.getKlijenti());
			dtos.add(dto);
		}
		return dtos;
	}

	public DelatnostDTO getDelatnostDTO(Delatnost delatnost) {
		DelatnostDTO dto = new DelatnostDTO(delatnost);
		dto.setKlijentiListFromSet(delatnost.getKlijenti());
		return dto;
	}

}
