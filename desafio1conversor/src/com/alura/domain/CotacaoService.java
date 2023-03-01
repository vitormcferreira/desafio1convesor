package com.alura.domain;

public interface CotacaoService {

	double getCotacao(Moeda moedaAtual, Moeda moedaAlvo) throws ConversaoIndisponivelException;

}
