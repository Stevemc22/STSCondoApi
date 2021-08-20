package com.cenfotec.condoapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.condoapi.domain.Amenidad;
import com.cenfotec.condoapi.repository.AmenidadesRepository;

@Service
public class AmenidadadServiceImpl implements AmenidadService {

    @Autowired
    AmenidadesRepository repo;
	
	@Override
	public Optional<Amenidad> save(Amenidad amenidad) {
		// TODO Auto-generated method stub
		return Optional.of(repo.save(amenidad));
	}
}
