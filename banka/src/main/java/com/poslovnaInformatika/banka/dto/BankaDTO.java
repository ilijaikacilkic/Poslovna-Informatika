package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;

import com.poslovnaInformatika.banka.entity.Banka;

public class BankaDTO {

	private long id;
	private int sifraBanke;
	private String nazivBanke;
	private String adresa;
	private String telefon;
	private String fax;
	private String swiftKod;
	
	List<RacunDTO> racuni = new ArrayList<RacunDTO>();
	
	public BankaDTO() {}

	public BankaDTO(Banka obj) {

		this.id = obj.getId();
		this.sifraBanke = obj.getSifraBanke();
		this.nazivBanke = obj.getNazivBanke();
		this.adresa = obj.getAdresa();
		this.telefon = obj.getTelefon();
		this.fax = obj.getFax();
		this.swiftKod = obj.getSwiftKod();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSifraBanke() {
		return sifraBanke;
	}

	public void setSifraBanke(int sifraBanke) {
		this.sifraBanke = sifraBanke;
	}

	public String getNazivBanke() {
		return nazivBanke;
	}

	public void setNazivBanke(String nazivBanke) {
		this.nazivBanke = nazivBanke;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSwiftKod() {
		return swiftKod;
	}

	public void setSwiftKod(String swiftKod) {
		this.swiftKod = swiftKod;
	}

	public List<RacunDTO> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<RacunDTO> racuni) {
		this.racuni = racuni;
	}
	
	
	
	
}
