package com.poslovnaInformatika.banka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.entity.Delatnost;
import com.poslovnaInformatika.banka.repository.DelatnostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DelatnostService {
	
	private final DelatnostRepository delatnostRepository;
	
	 public List<Delatnost> getDelatnosti() {
		 List<Delatnost> delatnosti = delatnostRepository.findAll();
			return delatnosti;
	    }
	 
	 public Delatnost getDelatnostById(Long id) {
	        return delatnostRepository.findById(id).orElse(null);
	    }
	 
	 public Delatnost addDelatnost(Delatnost delatnost) {
			return delatnostRepository.save(delatnost);
		}	 
	
	 
	 public void deleteDelatnost(long id) {
		 delatnostRepository.deleteById(id);
	 }
	 
	 public Delatnost saveDelatnost(Delatnost delatnost) {
	        return delatnostRepository.save(delatnost);
	    }

}
