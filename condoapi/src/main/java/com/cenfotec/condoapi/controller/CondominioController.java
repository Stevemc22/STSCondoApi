package com.cenfotec.condoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.condoapi.domain.Amenidad;
import com.cenfotec.condoapi.domain.Condominio;
import com.cenfotec.condoapi.service.AmenidadService;
import com.cenfotec.condoapi.service.CondominioService;
import com.cenfotec.condoapi.service.HistoricCuotaService;

@RestController
@RequestMapping({ "/condominios" })
public class CondominioController {

	@Autowired
	private CondominioService condoService;
	
	@Autowired
	private HistoricCuotaService historicCuotaService;
	
	@Autowired
	private AmenidadService amenidadService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Condominio> getAll(@RequestParam(required = false) Boolean isActive) {
		if(isActive != null)
			return condoService.getAll(isActive);
		
		return condoService.getAll();
	}
	
    @GetMapping(path = {"/{id"})
    public ResponseEntity<Condominio> findById(@PathVariable long id){
        Optional<Condominio> result = condoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Condominio condominio) {
		if(condoService.save(condominio).isPresent())
			return new ResponseEntity<String>("Condominio creado correctamente", HttpStatus.CREATED);
		
		return ResponseEntity.internalServerError().build();
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<?> insertAmenidad(@PathVariable("id") long id, @RequestBody Amenidad amenidad){
        Optional<Condominio> result = condoService.findById(id);
        if (result.isPresent()){
        	
        	amenidad.setCondominio(result.get());
        	amenidadService.save(amenidad);
        	
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> disable(@PathVariable("id") long id) {
		if (condoService.disable(id)) {
			return new ResponseEntity<String>("Condominio deshabilitado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No se encontró el condominio", HttpStatus.NOT_FOUND);
		}
	}
	
    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id,
                                          @RequestBody Condominio condominio){
        condominio.setId(id);
        Optional<Condominio> result = condoService.update(condominio);
        if (result.isPresent()){
        	historicCuotaService.insertHistoricCuota(condominio);
			return new ResponseEntity<String>("Condominio actualizado correctamente", HttpStatus.OK);
        }else {
        	return new ResponseEntity<String>("No se encontró el condominio", HttpStatus.NOT_FOUND);
        }
    }
}
