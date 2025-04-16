package br.dev.Breno.JurosCompostos.Model;

public class FormulaDoCalculo {
	private double capital;
	private double taxaDeJuros;
	private double tempoDoRendimento;
	public double montante;
	public double jurosCompostos;
	
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
		this.taxaDeJuros = taxaDeJuros;
	}
	public void CalcularJurosCompostos() {
		jurosCompostos = capital * (Math.pow(1 + taxaDeJuros, tempoDoRendimento) - 1);
		
	}
	public double getTempoDoRendimento() {
		return tempoDoRendimento;
	}
	public void setTempoDoRendimento(double tempoDoRendimento) {
		this.tempoDoRendimento = tempoDoRendimento;
	}
	public void CalcularMontante() {
		montante = jurosCompostos + capital;
	}
	public void MostrarDados() {
		System.out.println("Exibindo os resultados:");
		System.out.println("===========================");
		System.out.println("Capital Inicial:"+ capital);
		System.out.println("Taxa de Juros:" + taxaDeJuros);
		System.out.println("Tempo do ivestimento:" + tempoDoRendimento);
		System.out.printf("Resultado do investimento: %.2f\n", jurosCompostos);
		System.out.printf("Valor final do montante: %.2f\n", montante);
	}
	
	
	
	

}
