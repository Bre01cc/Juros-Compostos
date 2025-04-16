package br.dev.Breno.JurosCompostos.ui;

import java.util.Scanner;

import br.dev.Breno.JurosCompostos.dao.FormulaDoCalculoDao;



public class Menu {

	public static void mostrarMenu(){
		System.out.println("------------------------------");
		System.out.println("CALCULADORA DE JUROS COMPOSTOS");
		System.out.println("------------------------------");
		System.out.println("INICAR CALCULADORA");
		System.out.println("-------------------------------");
		System.out.println("S OU N?");
		
		Scanner leitor = new Scanner(System.in);
		
		String opcao = leitor.nextLine();
		
		 if (opcao.equalsIgnoreCase("S")) {
	            FormulaDoCalculoDao.criarFormulaDoCalculo();
	        } else if (opcao.equalsIgnoreCase("N")) {
	            System.out.println("Encerrando calculadora");
	        } else {
	            System.out.println("Opção inválida.");
	        }

	        leitor.close();
			}
		
	
		
		
	}


