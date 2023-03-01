package com.alura.app;

import com.alura.domain.Moeda;
import com.alura.externalservices.EconomiaAwesomeAPICotacaoService;
import com.alura.usecases.ConverterDinheiroInputDTO;
import com.alura.usecases.ConverterDinheiroOutputDTO;
import com.alura.usecases.ConverterDinheiroUseCase;

public class Main {

	public static void main(String[] args) {
		ConverterDinheiroUseCase converterMoedaUseCase = new ConverterDinheiroUseCase(
				new EconomiaAwesomeAPICotacaoService());

		ConverterDinheiroInputDTO input = new ConverterDinheiroInputDTO(Moeda.BRL, 5, Moeda.USD);

		try {
			ConverterDinheiroOutputDTO output = converterMoedaUseCase.execute(input);

			System.out.println("Valor na moeda " + input.getMoeda() + ": " + input.getValor());
			System.out.println("Valor na moeda " + output.getMoeda() + ": " + output.getValor());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
