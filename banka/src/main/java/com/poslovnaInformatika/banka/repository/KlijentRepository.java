package com.poslovnaInformatika.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Klijent;

public interface KlijentRepository extends JpaRepository<Klijent, Long> {

}
