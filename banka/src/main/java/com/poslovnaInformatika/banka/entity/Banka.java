package com.poslovnaInformatika.banka.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "banka")
@Getter
@Setter
public class Banka {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "sifraBanke")
	private int sifraBanke;
	@Column(name = "nazivBanke")
	private String nazivBanke;
	@Column(name = "adresa")
	private String adresa;
	@Column(name = "telefon")
	private String telefon;
	@Column(name = "fax")
	private String fax;
	@Column(name = "swiftKod")
	private String swiftKod;
	
	@OneToMany(mappedBy = "banka")
	private Set<Racun> racuni = new HashSet<Racun>();
	@OneToMany(mappedBy = "banka")
	private Set<Poruka> poruke = new HashSet<Poruka>();
	
	public Banka() {
		super();
	}


	
	
	


}
