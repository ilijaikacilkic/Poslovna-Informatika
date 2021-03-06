package com.poslovnaInformatika.banka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Racun;

public interface RacunRepository extends JpaRepository<Racun, Long> {
	
	Racun findBybrojRacuna(String brojRacuna);
	
	List<Racun> getByKlijentIdAndAktivanAndOdobren(Long idKlijent, Boolean aktivan,Boolean odobren);
	List<Racun> getByBankaIdAndAktivanAndOdobren(Long idBanka, Boolean aktivan,Boolean odobren);
	

}
