package com.cenfotec.condoapi.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Condominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String direccion;
	private int cedulaJuridica;
	private String representante;
	private int unidades;
	private double cuotaCondominal;
	private Boolean isActive = true;
	
	@JsonManagedReference
	@OneToMany(fetch= FetchType.LAZY, mappedBy="condominio")
	private Set<Amenidad> amenidades;
	
	public Condominio() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCedulaJuridica() {
		return cedulaJuridica;
	}

	public void setCedulaJuridica(int cedulaJuridica) {
		this.cedulaJuridica = cedulaJuridica;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getCuotaCondominal() {
		return cuotaCondominal;
	}

	public void setCuotaCondominal(double cuotaCondominal) {
		this.cuotaCondominal = cuotaCondominal;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Amenidad> getAmenidades() {
		return amenidades;
	}

	public void setAmenidades(Set<Amenidad> amenidades) {
		this.amenidades = amenidades;
	}
}
