package com.cenfotec.condoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.condoapi.domain.HistoricCuota;

public interface HistoricCuotaRepository extends JpaRepository<HistoricCuota, Long> {
	
}
