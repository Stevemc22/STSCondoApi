package com.cenfotec.condoapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoricCuota {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	private double monto;
	private String fecha;
	private long CondominioId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public long getCondominioId() {
		return CondominioId;
	}
	public void setCondominioId(long condominioId) {
		CondominioId = condominioId;
	}
}
