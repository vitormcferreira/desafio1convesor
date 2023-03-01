package com.alura.usecases;

import com.alura.domain.Moeda;

public class ConverterDinheiroOutputDTO {

	private Moeda moeda;
	private double valor;

	public ConverterDinheiroOutputDTO(Moeda moeda, double valor) {
		this.moeda = moeda;
		this.valor = valor;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public double getValor() {
		return valor;
	}

}
