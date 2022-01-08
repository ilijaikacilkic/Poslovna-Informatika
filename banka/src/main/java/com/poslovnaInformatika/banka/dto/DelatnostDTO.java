package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.poslovnaInformatika.banka.entity.Delatnost;
import com.poslovnaInformatika.banka.entity.Klijent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelatnostDTO {
	
	private long id;
	private String sifra;
	private String naziv;
	
	private List<KlijentDTO> klijenti = new ArrayList<KlijentDTO>();
	
	public DelatnostDTO() {
		
	}
	
	public DelatnostDTO(Delatnost obj) {

		this.id = obj.getId();
		this.sifra = obj.getSifra();
		this.naziv = obj.getNaziv();
		
	}
	
	public void setKlijentiListFromSet(Set<Klijent> klijenti) {
		List<Klijent> klijent = new ArrayList<Klijent>(klijenti);
		for(Klijent obj : klijent)
			this.klijenti.add(new KlijentDTO(obj));
	}

}

