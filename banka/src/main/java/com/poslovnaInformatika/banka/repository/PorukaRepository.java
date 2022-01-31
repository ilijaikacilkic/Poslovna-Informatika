package com.poslovnaInformatika.banka.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {
	

}
