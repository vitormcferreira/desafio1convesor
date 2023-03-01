package com.alura.usecases;

import com.alura.domain.ConversaoIndisponivelException;
import com.alura.domain.CotacaoService;
import com.alura.domain.Dinheiro;
import com.alura.domain.Moeda;

public class ConverterDinheiroUseCase {

	private CotacaoService cotacaoService;

	public ConverterDinheiroUseCase(CotacaoService cotacaoService) {
		this.cotacaoService = cotacaoService;
	}

	public ConverterDinheiroOutputDTO execute(ConverterDinheiroInputDTO input) throws ConversaoIndisponivelException {
		Dinheiro dinheiro = new Dinheiro(cotacaoService, input.getMoeda(), input.getValor());

		dinheiro.converterPara(input.getNovaMoeda());

		return new ConverterDinheiroOutputDTO(dinheiro.getMoeda(), dinheiro.getValor());
	}

}
