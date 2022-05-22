package com.poslovnaInformatika.banka.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.entity.Korisnik;
import com.poslovnaInformatika.banka.entity.Valuta;
import com.poslovnaInformatika.banka.repository.KorisnikRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KorisnikService implements UserDetailsService  {
	
	private final KorisnikRepository korisnikRepository;

	@Override
	public Korisnik loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik korisnik = korisnikRepository.findByUsername(username);
		
		if (korisnik == null) {
			throw new UsernameNotFoundException("No user with username " + username + " found.");
		} else {
			return korisnik;
		}
	}
	
//	public Korisnik saveKorisnik(Korisnik korisnik) {
//		return korisnikRepository.save(korisnik);
//	}
	
//	public Korisnik saveKorisnik(Klijent klijent) {
//		Korisnik korisnik = new Korisnik();
//		
//		korisnik.setKlijent(klijent);
//		korisnik.setUsername(korisnik.getUsername());
//		korisnik.setPassword(korisnik.getPassword());
//		
//		return korisnikRepository.save(korisnik);
//		
//	}
	public Korisnik saveKorisnik(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}
	

}