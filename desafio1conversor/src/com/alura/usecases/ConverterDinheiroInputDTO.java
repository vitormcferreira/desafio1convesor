package com.alura.usecases;

import com.alura.domain.Moeda;

public class ConverterDinheiroInputDTO {

	private Moeda moeda;
	private double valor;
	private Moeda novaMoeda;

	public ConverterDinheiroInputDTO(Moeda moeda, double valor, Moeda novaMoeda) {
		this.moeda = moeda;
		this.valor = valor;
		this.novaMoeda = novaMoeda;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public double getValor() {
		return valor;
	}

	public Moeda getNovaMoeda() {
		return novaMoeda;
	}

}
