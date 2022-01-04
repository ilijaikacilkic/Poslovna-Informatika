package com.poslovnaInformatika.banka.controller;

import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.service.RacunService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RacunController {

	
	public final RacunService racunService;
	
}
