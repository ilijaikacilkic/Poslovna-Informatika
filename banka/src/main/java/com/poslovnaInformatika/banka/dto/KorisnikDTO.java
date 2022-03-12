package com.poslovnaInformatika.banka.dto;

import com.poslovnaInformatika.banka.entity.Korisnik;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KorisnikDTO {
	
	private String username;
	private String password;
	
	public KorisnikDTO() {}
	
	public KorisnikDTO(Korisnik obj) {
		super();
		this.username = obj.getUsername();
		this.password = obj.getPassword();

	}

}
