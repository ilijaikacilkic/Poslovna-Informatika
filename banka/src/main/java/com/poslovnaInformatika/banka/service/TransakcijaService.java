package com.poslovnaInformatika.banka.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poslovnaInformatika.banka.dto.TransakcijaDTO;
import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.entity.Transakcija;
import com.poslovnaInformatika.banka.entity.Valuta;
import com.poslovnaInformatika.banka.repository.TransakcijaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransakcijaService {

	
	private final TransakcijaRepository transakcijaRepository;
	
//	private final DnevnoStanjeService dnevnoStanjeService;
	
	private final int BROJ_TRANSAKCIJA = 2;

	public List<Transakcija> getTransakcije() {
		List<Transakcija> transakcije = transakcijaRepository.findAll();
		return transakcije;
	}

	public Transakcija getTransakcijaById(Long id) {
		return transakcijaRepository.findById(id).orElse(null);
	}

	public Transakcija addTransakcija(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}
	

	public void deleteTransakcija(long id) {
		transakcijaRepository.deleteById(id);
	}

	public void saveTransakcija(TransakcijaDTO dto,Racun racunDuznika,Racun racunPrimaoca, Valuta valuta, int param){

//		Date datumPrijema = is.getDateFromMillis(System.currentTimeMillis());
//		Date datumValute = is.getDateFromMillis(System.currentTimeMillis());
//
//		List<DnevnoStanje> dnevnoStanjeZaDatum = new ArrayList<>();

		Transakcija transakcija = null;
		for(int i=0;i<BROJ_TRANSAKCIJA;i++){
			transakcija = new Transakcija();
			transakcija.setDatum(dto.getDatum());			
			transakcija.setDuznik(racunDuznika.getKlijent().getIme() + " " + racunDuznika.getKlijent().getPrezime());
			transakcija.setPrimalac(racunPrimaoca.getKlijent().getIme() + " " + racunDuznika.getKlijent().getPrezime());
			transakcija.setHitno(dto.getHitno());
			transakcija.setIznos(dto.getIznos());
			transakcija.setModelPrimaoca(dto.getPrimalac());
			transakcija.setPozivNaBrojPrimaoca(dto.getPrimalac());
			transakcija.setModelDuznika(dto.getModelDuznika());
			transakcija.setPozivNaBrojDuznika(dto.getPozivNaBrojDuznika());			
			transakcija.setSvrhaPlacanja(dto.getSvrhaPlacanja());			
			transakcija.setValuta(valuta);
			transakcija.setRacunDuznika(racunDuznika);
			transakcija.setRacunPrimaoca(racunPrimaoca);
			
//			DnevnoStanje ds = null;
//			double novoStanje = 0;
//			if(i == 0) {
//				dnevnoStanjeZaDatum = dnevnoStanjeService.dnevnoStanjeZaDatum(datumPrijema, racunDuznika.getId());
//				novoStanje = racunDuznika.getStanje()-nalog.getIznos();
//				racunDuznika.setStanje(novoStanje);
//			}else if(i == 1) {
//				dnevnoStanjeZaDatum = dss.dnevnoStanjeZaDatum(datumPrijema, racunPrimaoca.getId());
//				novoStanje = racunPrimaoca.getStanje()+nalog.getIznos();	
//				racunPrimaoca.setStanje(novoStanje);
//			}
//			
//			if(dnevnoStanjeZaDatum.isEmpty()) {
//				ds = new DnevnoStanje();
//				int count = dss.countDnevnoStanje();
//				count++;
//				ds.setBrojIzvoda(Integer.toString(count));
//				ds.setDatumPrometa(datumPrijema);
//				if(i == 0) {
//					ds.setPrethodnoStanje(novoStanje+nalog.getIznos());
//					ds.setNovoStanje(novoStanje);
//					ds.setPrometNaTeret(nalog.getIznos());
//					ds.setPrometUKorist(0);
//					ds.setRacun(racunDuznika);
//				}else if(i == 1) {
//					ds.setPrethodnoStanje(novoStanje-nalog.getIznos());
//					ds.setNovoStanje(novoStanje);
//					ds.setPrometNaTeret(0);
//					ds.setPrometUKorist(nalog.getIznos());
//					ds.setRacun(racunPrimaoca);
//				}
//				dss.save(ds);
//				nalog.setDnevnoStanje(ds);
//				nr.save(nalog);
//			}else {
//				
//				for(DnevnoStanje d : dnevnoStanjeZaDatum) {
//					d.setPrethodnoStanje(d.getNovoStanje());
//					d.setNovoStanje(novoStanje);
//					if(i == 0) {
//						d.setPrometNaTeret(nalog.getIznos());
//						d.setPrometUKorist(0);
//					}else if(i == 1) {
//						d.setPrometNaTeret(0);
//						d.setPrometUKorist(nalog.getIznos());
//					}
//					nalog.setDnevnoStanje(d);
//					dss.save(d);
//					nr.save(nalog);
//				}
//			}
//			
//			
//			if(i==0){
//				is.exportNalog(nalog);
//				if(param==1)
//					racunDuznika.setRezervisanIznos(0); 	
//				rs.save(racunDuznika);
//			}
//			else if(i==1)
//				rs.save(racunPrimaoca);

			
		}
		
		transakcijaRepository.save(transakcija);
		
	}
	public TransakcijaDTO getTransakcijaDTO(Transakcija transakcija) {
		TransakcijaDTO transakcijaDTO = new TransakcijaDTO(transakcija);
		return transakcijaDTO;
	}
	

	public List<TransakcijaDTO> getTransakcijeDTO(List<Transakcija> transakcije){
		List<TransakcijaDTO> transakcijeDTO = new ArrayList<TransakcijaDTO>();
		for(Transakcija transakcija : transakcije) {
			TransakcijaDTO transakcijaDTO = new TransakcijaDTO(transakcija);			
			transakcijeDTO.add(transakcijaDTO);
		}
		return transakcijeDTO;
	}
	
}

