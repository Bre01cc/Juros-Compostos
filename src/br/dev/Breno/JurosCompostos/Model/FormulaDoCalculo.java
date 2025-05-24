package br.dev.Breno.JurosCompostos.Model;

import java.nio.file.attribute.AclEntry;

//Atributos da classe
public class FormulaDoCalculo {
	private double capital;
	private double taxaDeJuros;
	private double tempoDoRendimento;
	public double montante;
	public double jurosCompostos;

	// GETS e SETS

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getTaxaDeJuros() {
		return taxaDeJuros;
	}

	public void setTaxaDeJuros(double taxaDeJuros) {
		this.taxaDeJuros = taxaDeJuros /100;
	}

	public double getTempoDoRendimento() {
		return tempoDoRendimento;
	}

	public void setTempoDoRendimento(double tempoDoRendimento) {
		this.tempoDoRendimento = tempoDoRendimento;
	}

	// CALCULO DOS JUROS COMPOSTOS
	public double CalcularJurosCompostos() { 
		return jurosCompostos = capital * (Math.pow(1 + taxaDeJuros, tempoDoRendimento) - 1);

	}

	//CALCULO DO MONTANTE
	public double CalcularMontante() {
		return montante = jurosCompostos + capital;
	}

	public void MostrarDados() {
		System.out.println("Exibindo os resultados:");
		System.out.println("===========================");
		System.out.println("Capital Inicial:" + capital);
		System.out.println("Taxa de Juros:" + taxaDeJuros);
		System.out.println("Tempo do investimento:" + tempoDoRendimento);
		System.out.printf("Resultado do investimento: %.2f\n", jurosCompostos);
		System.out.printf("Valor final do montante: %.2f\n", montante);
	}

}
