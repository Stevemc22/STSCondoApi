package com.cenfotec.condoapi.service;

import java.util.Optional;

import com.cenfotec.condoapi.domain.Amenidad;

public interface AmenidadService {
	public Optional<Amenidad> save(Amenidad amenidad);
}
