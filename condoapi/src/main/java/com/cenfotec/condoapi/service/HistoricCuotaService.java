package com.cenfotec.condoapi.service;

import java.util.List;

import com.cenfotec.condoapi.domain.Condominio;
import com.cenfotec.condoapi.domain.HistoricCuota;

public interface HistoricCuotaService {
	public void save(HistoricCuota historicCuota);
	public List<HistoricCuota> getAll();
	public void insertHistoricCuota(Condominio condominio);
}
