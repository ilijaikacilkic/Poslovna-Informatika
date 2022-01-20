package com.poslovnaInformatika.banka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.dto.BankaDTO;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.repository.BankaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankaService {

	private final BankaRepository bankaRepository;
	
	 public List<Banka> getBanke() {
	        return bankaRepository.findAll();
	    }
	 
	 public Banka getBankaById(Long id) {
	        return bankaRepository.findById(id).orElse(null);
	    }
	 
	 public Banka addBanka(Banka banka) {
			return bankaRepository.save(banka);
		}
	 
	 public List<Banka> saveBanke(List<Banka> banke) {
	        return bankaRepository.saveAll(banke);
	    }
	 
	 
	 public void deleteBanka(long id) {
		 bankaRepository.deleteById(id);
	 }
	 
	 public Banka saveBanka(Banka banka) {
	        return bankaRepository.save(banka);
	    }
	 
		//prebacivanje Banke u DTO klasu
		public BankaDTO getBankaDTO(Banka banka) {
			BankaDTO bankaDTO = new BankaDTO(banka);
			return bankaDTO;
		}
		
		//prebacivanje Liste banaka u listu DTO banaka
		public List<BankaDTO> getAllBankeDTO(List<Banka> banke){
			List<BankaDTO> bankeDTO = new ArrayList<BankaDTO>();
			for(Banka banka : banke) {
				BankaDTO bankaDTO = new BankaDTO(banka);
				bankaDTO.setRacuniListFromSet(banka.getRacuni());
				bankeDTO.add(bankaDTO);
			}
			return bankeDTO;
		}
}
