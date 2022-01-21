package com.poslovnaInformatika.banka.dto;

import java.util.Date;

import com.poslovnaInformatika.banka.entity.Gasenje_racuna;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class GasenjeRacunaDTO {
	
	private long id ;
	private String obrazlozenje;
	private Date datumIzvrsenjaUkidanja ;
	private boolean zavrseno ; 
	
	private RacunDTO racunZaUkidanje;
	private RacunDTO racunZaPremestanje;
	
	public GasenjeRacunaDTO(){
		
	}
	
	
	public GasenjeRacunaDTO(Gasenje_racuna gasenje_racuna) {
		
		id = gasenje_racuna.getId();
		obrazlozenje = gasenje_racuna.getObrazlozenje();
		datumIzvrsenjaUkidanja = gasenje_racuna.getDatum();
		zavrseno = gasenje_racuna.isZavrseno();
		
		if(gasenje_racuna.getRacun() != null)
			racunZaUkidanje = new RacunDTO(gasenje_racuna.getRacun());
		if(gasenje_racuna.getRacunPremestanje()!=null)
			racunZaPremestanje = new RacunDTO(gasenje_racuna.getRacunPremestanje());
			
	}


	public GasenjeRacunaDTO(long id, String obrazlozenje, Date datumIzvrsenjaUkidanja, boolean zavrseno,
			RacunDTO racunZaUkidanje, RacunDTO racunZaPremestanje) {
		super();
		this.id = id;
		this.obrazlozenje = obrazlozenje;
		this.datumIzvrsenjaUkidanja = datumIzvrsenjaUkidanja;
		this.zavrseno = zavrseno;
		this.racunZaUkidanje = racunZaUkidanje;
		this.racunZaPremestanje = racunZaPremestanje;
	}
	
	
	
	
	
	
	
	

}



// id , str obrazlozenje , date datum , boolean zavrseno , racun racun , racunPremestanje 