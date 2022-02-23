package com.poslovnaInformatika.banka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.entity.Korisnik;
import com.poslovnaInformatika.banka.repository.KorisnikRepository;

@Service
public class KorisnikService implements UserDetailsService  {
	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public Korisnik loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik korisnik = korisnikRepository.findByUsername(username);
		
		if (korisnik == null) {
			throw new UsernameNotFoundException("No user with username " + username + " found.");
		} else {
			return korisnik;
		}
	}

}