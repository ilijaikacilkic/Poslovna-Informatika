package com.poslovnaInformatika.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Transakcija;

public interface TransakcijaRepository extends JpaRepository<Transakcija, Long>{

}
