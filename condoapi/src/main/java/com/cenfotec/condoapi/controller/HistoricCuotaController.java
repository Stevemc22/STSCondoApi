package com.cenfotec.condoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.condoapi.domain.HistoricCuota;
import com.cenfotec.condoapi.service.HistoricCuotaService;

@RestController
@RequestMapping({ "/historic_cuota" })
public class HistoricCuotaController {
	@Autowired
	private HistoricCuotaService historicCuotaService;
	
	@GetMapping
	public List<HistoricCuota> getAllHistoricCuota(){
		return historicCuotaService.getAll();
	}
}
