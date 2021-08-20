package com.cenfotec.condoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.condoapi.domain.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {
	public List<Condominio> findByisActive(Boolean isActive);
}
