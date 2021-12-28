package com.poslovnaInformatika.banka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovnaInformatika.banka.entity.Banka;

public interface BankaRepository extends JpaRepository<Banka, Long> {

}
