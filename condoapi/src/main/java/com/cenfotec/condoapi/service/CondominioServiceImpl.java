package com.cenfotec.condoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.condoapi.domain.Amenidad;
import com.cenfotec.condoapi.domain.Condominio;
import com.cenfotec.condoapi.repository.CondominioRepository;

@Service
public class CondominioServiceImpl implements CondominioService {

	@Autowired
	CondominioRepository condoRepo;
	
	@Override
	public List<Condominio> getAll() {
		// TODO Auto-generated method stub
		return condoRepo.findAll();
	}

	@Override
	public Optional<Condominio> findById(long id) {
		// TODO Auto-generated method stub
		return condoRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
	}

	@Override
	public Optional<Condominio> save(Condominio condominio) {
		// TODO Auto-generated method stub
		return Optional.of(condoRepo.save(condominio));
	}

	@Override
	public Optional<Condominio> update(Condominio condominio) {
		// TODO Auto-generated method stub
		Optional<Condominio> record = condoRepo.findById(condominio.getId());
		if(record.isPresent()) {
			Condominio data = record.get();
			data.setCedulaJuridica(condominio.getCedulaJuridica());		
			data.setCuotaCondominal(condominio.getCuotaCondominal());
			data.setDireccion(condominio.getDireccion());
			data.setName(condominio.getName());
			data.setRepresentante(condominio.getRepresentante());
			data.setUnidades(condominio.getUnidades());
			return Optional.of(condoRepo.save(data));
		}
		return Optional.empty();
	}
	
	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
        Optional<Condominio> result = condoRepo.findById(id);
        if (result.isPresent()){
        	condoRepo.deleteById(id);
            return true;
        }
            return false;
	}

	@Override
	public List<Condominio> getAll(boolean isActive) {
		// TODO Auto-generated method stub
		return condoRepo.findByisActive(isActive);
	}

	@Override
	public boolean disable(long id) {
		// TODO Auto-generated method stub
		Optional<Condominio> record = condoRepo.findById(id);
		if(record.isPresent()) {
			Condominio data = record.get();
			data.setIsActive(false);
			condoRepo.save(data);
			return true;
		}
		return false;
	}

	@Override
	public Optional<Condominio> saveAmenidad(long id, Amenidad amenidad) {
		// TODO Auto-generated method stub
		Optional<Condominio> record = condoRepo.findById(id);
		if(record.isPresent()) {
			Condominio data = record.get();
			amenidad.setCondominio(data);
			return Optional.of(condoRepo.save(data));
		}
		return Optional.empty();
	}
}
