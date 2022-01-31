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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.poslovnaInformatika.banka.enums.TipKlijenta;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "klijent")
@Getter
@Setter 
public class Klijent {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "adresa")
	private String adresa;
	
	@Column(name = "telefon")
	private String telefon;
	
	@Column(name = "jmbg")
	private String jmbg;

	@Column(name = "fizickoLice")
	private TipKlijenta fizickoLice;
	
	@OneToMany(mappedBy = "klijent")
	private Set<Racun> racuni = new HashSet<Racun>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Delatnost delatnost;
	
	public Klijent() {
		super();
	}

	
	
	
	
}
