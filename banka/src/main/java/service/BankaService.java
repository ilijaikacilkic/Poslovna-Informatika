package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.repository.BankaRepository;

@Service
public class BankaService {

	@Autowired
	private BankaRepository bankaRepository;
	
	
	public Banka saveBanka(Banka banka) {
        return bankaRepository.save(banka);
    }
	
	 public List<Banka> saveAppointments(List<Banka> banke) {
	        return bankaRepository.saveAll(banke);
	    }

	 public List<Banka> getBanke() {
	        return bankaRepository.findAll();
	    }

	 public Banka getBankaById(Long id) {
	        return bankaRepository.findById(id).orElse(null);
	    }
	 
	 public Banka addBanka(Banka banka) {
			return bankaRepository.save(banka);
		}
}
