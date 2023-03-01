package com.alura.domain;

public class Dinheiro {

	private CotacaoService cotacaoService;
	private Moeda moeda;
	private double valor;

	public Dinheiro(CotacaoService cotacaoService, Moeda moeda, double valor) {
		this.cotacaoService = cotacaoService;
		this.moeda = moeda;
		this.valor = valor;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void converterPara(Moeda novaMoeda) throws ConversaoIndisponivelException {
		double cotacao = cotacaoService.getCotacao(this.moeda, novaMoeda);

		double novoValor = this.valor * cotacao;

		this.valor = novoValor;
		this.moeda = novaMoeda;
	}

}
