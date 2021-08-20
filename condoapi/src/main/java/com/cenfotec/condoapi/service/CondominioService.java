package com.cenfotec.condoapi.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.condoapi.domain.Amenidad;
import com.cenfotec.condoapi.domain.Condominio;

public interface CondominioService {
	public List<Condominio> getAll();
	public List<Condominio> getAll(boolean isActive);
	public Optional<Condominio> findById(long id);
	public Optional<Condominio> save(Condominio condominio);
	public Optional<Condominio> update(Condominio condominio);
	public boolean delete(long id);
	public boolean disable(long id);
	public Optional<Condominio> saveAmenidad(long id, Amenidad amenidad);
}
