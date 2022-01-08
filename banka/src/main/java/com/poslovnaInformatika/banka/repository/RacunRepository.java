package com.poslovnaInformatika.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Racun;

public interface RacunRepository extends JpaRepository<Racun, Long> {
	
	Racun findBybrojRacuna(String brojRacuna);

}
