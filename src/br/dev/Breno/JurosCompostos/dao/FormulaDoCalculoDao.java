package br.dev.Breno.JurosCompostos.dao;

import java.util.Scanner;

import br.dev.Breno.JurosCompostos.Model.FormulaDoCalculo;

public class FormulaDoCalculoDao {
	public static void criarFormulaDoCalculo() {
		FormulaDoCalculo formulaDoCalculo = new FormulaDoCalculo ();
		System.out.println();
		System.out.println("Iniciando operação...");
		
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Qual valor do capital inicial? ");
		formulaDoCalculo.setCapital(leitor.nextDouble());
		
		System.out.println("Qual o Tempo do investimento? ");
		formulaDoCalculo.setTempoDoRendimento(leitor.nextDouble());
		
		System.out.println("Qual a Taxa de juros?");
		formulaDoCalculo.setTaxaDeJuros(leitor.nextDouble());
		formulaDoCalculo.CalcularJurosCompostos();
		formulaDoCalculo.CalcularMontante();
		formulaDoCalculo.MostrarDados();
	}

	
		
	}


