package com.poslovnaInformatika.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Valuta;

public interface ValutaRepository  extends JpaRepository<Valuta, Long> {

}
