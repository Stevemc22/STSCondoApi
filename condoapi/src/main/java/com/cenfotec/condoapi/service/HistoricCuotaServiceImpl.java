package com.cenfotec.condoapi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.condoapi.domain.Condominio;
import com.cenfotec.condoapi.domain.HistoricCuota;
import com.cenfotec.condoapi.repository.HistoricCuotaRepository;

@Service
public class HistoricCuotaServiceImpl implements HistoricCuotaService {

    @Autowired
    HistoricCuotaRepository repo;

	@Override
	public void save(HistoricCuota historicCuota) {
		// TODO Auto-generated method stub
		repo.save(historicCuota);
	}

	@Override
	public List<HistoricCuota> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public void insertHistoricCuota(Condominio condominio) {
		HistoricCuota historic = new HistoricCuota();
		historic.setMonto(condominio.getCuotaCondominal());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		historic.setFecha(dtf.format(now));
		
		historic.setCondominioId(condominio.getId());
		this.save(historic);
	}
}
