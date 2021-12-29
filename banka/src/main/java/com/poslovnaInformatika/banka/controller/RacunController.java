package com.poslovnaInformatika.banka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.service.RacunService;

@RestController
public class RacunController {

	@Autowired
	RacunService racunService;
	
}
