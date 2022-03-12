package com.poslovnaInformatika.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, String>{
	
	Korisnik findByUsername(String username);
	
	

}
