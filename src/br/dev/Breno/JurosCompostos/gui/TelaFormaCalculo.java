package br.dev.Breno.JurosCompostos.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.Breno.JurosCompostos.Model.FormulaDoCalculo;

public class TelaFormaCalculo {
	private JLabel labelCapital;
	private JLabel labelJuros;
	private JLabel labelTempoDoRendimento;
	private JTextField textCapitalCaixa;
	private JTextField textJurosCaixa;
	private JTextField textTempoCaixa;
	private String tituloDaTela;
	private JLabel labelResultado;
	private JLabel labelErro;
	private JButton buttomCalcular;
	private JButton buttomLimpar;

	public void CriarTelaFormaCalculo(String tituloDaTela) {
		this.tituloDaTela = tituloDaTela;
		JFrame tela = new JFrame();
		tela.setTitle(this.tituloDaTela);
		tela.setSize(500, 500);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = tela.getContentPane();
		container.setBackground(Color.green);

		// CAPITAL
		labelCapital = new JLabel();
		labelCapital.setText("INSIRA O CAPITAL");
		labelCapital.setBounds(50, 20, 200, 20);
		labelCapital.setForeground(Color.WHITE);

		// CAPITAL CAIXA DE TEXTO
		textCapitalCaixa = new JTextField();
		textCapitalCaixa.setBounds(50, 40, 300, 30);

		// JUROS
		labelJuros = new JLabel();
		labelJuros.setText("INSIRA O JUROS");
		labelJuros.setBounds(50, 70, 300, 30);
		labelJuros.setForeground(Color.WHITE);

		// JUROS CAIXA DE TEXTO
		textJurosCaixa = new JTextField();
		textJurosCaixa.setBounds(50, 100, 300, 30);

		// TEMPO DO RENDIMENTO
		labelTempoDoRendimento = new JLabel();
		labelTempoDoRendimento.setText("INSIRA O TEMPO DO RENDIMENTO");
		labelTempoDoRendimento.setForeground(Color.WHITE);
		labelTempoDoRendimento.setBounds(50, 130, 300, 30);

		// TEMPO DO RENDIMENTO CAIXA DE TEXTO
		textTempoCaixa = new JTextField();
		textTempoCaixa.setBounds(50, 160, 300, 30);

		// CALCULAR
		buttomCalcular = new JButton();
		buttomCalcular.setText("Calcular");
		buttomCalcular.setBounds(50, 350, 150, 40);

		// LIMPAR
		buttomLimpar = new JButton();
		buttomLimpar.setText("Limpar");
		buttomLimpar.setBounds(220, 350, 150, 40);

		// RESULTADO
		labelResultado = new JLabel();
		labelResultado.setText("Resultado");
		labelResultado.setBounds(100, 200, 350, 40);
		labelResultado.setFont(new Font("Arial", 1, 22));
		labelResultado.setVisible(false);

		// ERRO
		labelErro = new JLabel();
		labelErro.setBounds(50, 200, 350, 40);
		labelErro.setFont(new Font("Arial", 1, 22));
		labelErro.setForeground(Color.RED);
		labelErro.setVisible(false);

		buttomCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FormulaDoCalculo fmu = new FormulaDoCalculo();
					String capital = textCapitalCaixa.getText();
					String capitalP = capital.replace(",", ".");
					double capitalDouble = Double.parseDouble(capitalP);
					if (capitalDouble > 0) {
						fmu.setCapital(capitalDouble);
						labelErro.setVisible(false);
					} else {
						labelErro.setText("Capaital precisa ser positivo");
						labelErro.setVisible(true);
						labelResultado.setVisible(false);
					}
					String juros = textJurosCaixa.getText();
					String jurosP = juros.replace(",", ".");
					double jurosDouble = Double.parseDouble(jurosP);
					if (jurosDouble > 0) {
						fmu.setTaxaDeJuros(jurosDouble);

					} else {
						labelErro.setText("juros precisa ser positivo");
						labelErro.setVisible(true);
						labelResultado.setVisible(false);
					}
					String tempo = textTempoCaixa.getText();
					String tempoP = tempo.replace(",", ".");
					double tempoDouble = Double.parseDouble(tempoP);
					if (tempoDouble > 0) {
						fmu.setTempoDoRendimento(tempoDouble);
						double compostos = fmu.CalcularJurosCompostos();
						double montante = fmu.CalcularMontante();
						labelResultado.setText(String.format("Valor final: %.2f", montante));
						labelResultado.setVisible(true);

					} else {
						labelErro.setText("tempo precisa ser positivo");
						labelErro.setVisible(true);
						labelResultado.setVisible(false);

					}

				} catch (NumberFormatException erro) {
					labelErro.setText("Formado invalido inserido");
					labelErro.setVisible(true);
					labelResultado.setVisible(false);
				} catch (IllegalArgumentException erro) {
					labelErro.setText("Verifique as informações");
					labelErro.setVisible(true);
					labelResultado.setVisible(false);
				} catch (Exception erro) {
					labelErro.setText("Erro identificado");
					labelErro.setVisible(true);
					labelResultado.setVisible(false);
				}

			}

		});
		buttomLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textCapitalCaixa.setText("");
				textJurosCaixa.setText("");
				textTempoCaixa.setText("");
				labelResultado.setVisible(false);
				labelErro.setVisible(false);
			}
		});

		container.add(labelCapital);
		container.add(textCapitalCaixa);
		container.add(labelJuros);
		container.add(textJurosCaixa);
		container.add(labelTempoDoRendimento);
		container.add(textTempoCaixa);
		container.add(labelResultado);
		container.add(labelErro);
		container.add(buttomCalcular);
		container.add(buttomLimpar);

		tela.setVisible(true);
	}

}
