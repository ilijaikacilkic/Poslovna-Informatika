package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class KlijentDTO {
	
	private long id;
	private String naziv;
	private String ime;
	private String prezime;
	private String email;
	private String adresa;
	private String telefon;
	private String jmbg;
	private String pib;
	private boolean fizickoLice;
	
	private List<RacunDTO> racuni = new ArrayList<RacunDTO>();
	
	public KlijentDTO() {}

	
}
