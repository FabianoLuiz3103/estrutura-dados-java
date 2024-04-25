package sensores;

import java.util.Scanner;

import fila.FilaSensor;
import lista.ListaSensorCrescente;
import lista.NO;

public class Funcoes {

	public String[] sensoresJaRegistrados() {
		String coordenadasSensores[] = { "47o55’44”W,21o00’34”S", "47o55’42”W,21o00’35”S", "47o55’39”W,21o00’37”S",
				"47o55’44”W,21o00’39”S", "47o55’40”W,21o00’40”S", "47o55’32”W,21o00’34”S", "47o55’28”W,21o00’34”S",
				"47o55’28”W,21o00’38”S", "47o55’33”W,21o00’39”S" };
		return coordenadasSensores;

	}

	public void verificarSensores(ListaSensorCrescente lista) {

		boolean ph, ni, fo, po, ca, ma, en;
		NO aux = lista.getLista();
		while (aux != null) {
			Sensor s = aux.getDado();

			System.out.println(
					"============================================================================================");
			System.out.println("\n\t>> SENSOR " + s.getNumeroSensor() + " <<");
			System.out.println(" >> COORDENADAS: " + s.getCoordenadas() + " << \n");
			ph = verificarParametro(s.getPh(), Constantes.PH_MIN.getValor(), Constantes.PH_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getPh(), ph, "- PH: "));

			ni = verificarParametro(s.getNitrogenio(), Constantes.NITROGENIO_MIN.getValor(),
					Constantes.NITROGENIO_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getNitrogenio(), ni, "- NITROGÊNIO: "));

			fo = verificarParametro(s.getFosforo(), Constantes.FOSFORO_MIN.getValor(),
					Constantes.FOSFORO_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getFosforo(), fo, "- FÓSFORO: "));

			po = verificarParametro(s.getPotassio(), Constantes.POTASSIO_MIN.getValor(),
					Constantes.POTASSIO_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getPotassio(), po, "- POTÁSSIO: "));

			ca = verificarParametro(s.getCalcio(), Constantes.CALCIO_MIN.getValor(), Constantes.CALCIO_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getCalcio(), ca, "- CÁLCIO: "));

			ma = verificarParametro(s.getMagnesio(), Constantes.MAGNESIO_MIN.getValor(),
					Constantes.MAGNESIO_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getMagnesio(), ma, "- MAGNÉSIO: "));

			en = verificarParametro(s.getEnxofre(), Constantes.ENXOFRE_MIN.getValor(),
					Constantes.ENXOFRE_MAX.getValor());
			System.out.println(s.mostrarValidosInvalidos(s.getEnxofre(), en, "- ENXOFRE: "));

			boolean[] arrBoolean = { ph, ni, fo, po, ca, ma, en };
			System.out.println("\n");
			s.setQtd(contadora(arrBoolean));
			aux = aux.getProx();
		}
	}

	private boolean verificarParametro(double valorAtributo, double valorMinimo, double valorMaximo) {
		if (valorAtributo > valorMinimo && valorAtributo < valorMaximo) {
			return false;
		} else {
			return true;
		}
	}

	private int contadora(boolean arr[]) {
		int cont = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				cont++;
			}
		}
		return cont;
	}

	public FilaSensor destinarSensores(FilaSensor fila, Sensor s, ListaSensorCrescente lista) {
		NO aux = lista.getLista();
		while (aux != null) {
			s = aux.getDado();
			if (s.getQtd() > 3) {
				String coord = aux.getDado().getCoordenadas();
				lista.remove(coord);
				fila.enqueue(s);
			}

			aux = aux.getProx();
		}
		return fila;
	}

	public void sensoresParametrosRuins(Sensor s, ListaSensorCrescente lista) {

		NO aux = lista.getLista();
		while (aux != null) {
			s = aux.getDado();
			if (s.getQtd() > 3) {
				System.out.println(s.toString());
			}

			aux = aux.getProx();
		}
	}

	public String caseNumeroQuatro(Scanner teclado, String opcaoPergunta, FilaSensor fila) {
		do {
			System.out.println("\n\n\n\t\t >>>> FILA DE ANÁLISE <<<<");
			System.out.println("\n\n\t >> DESEJA EXIBIR OS SENSORES QUE ESTÃO NA FILA DE ANÁLISE? (S/N) << ");
			opcaoPergunta = teclado.next().toUpperCase();
			if (opcaoPergunta.equals("S")) {
				if (!fila.isEmpty()) {
					fila.exibirTodos();// apresentando fila de sensores para análise

					do {
						if(!fila.isEmpty()) {
							System.out.println("\n\n\t >> DIGITE: <<");
							System.out.println("<A>: PARA ANÁLISAR PARÂMETROS INDIVIDUALMENTE;"
									+ "\n<X>: VOLTAR PARA O MENU");
							opcaoPergunta = teclado.next().toUpperCase();
						}else {
							System.out.println("\n\n\t >> DIGITE: <<");
							System.out.println("<X>: VOLTAR PARA O MENU");
							opcaoPergunta = teclado.next().toUpperCase();
						}
						switch (opcaoPergunta) {
						case "A":
							String periodo = "";
							do {
								if (!fila.isEmpty()) {
									System.out.println(fila.first());

									System.out.println("\n\n ESSES PARÂMETROS PODEM SER REAJUSTADOS EM:"
											+ "\n\t<C>: CURTO PERÍODO DE TEMPO;" + "\n\t<L>: LONGO PERÍODO DE TEMPO;"
													+ "\n\t<S>: SAIR DA ANÁLISE.");
									periodo = teclado.next().toUpperCase();
									if (periodo.equals("C")) {
										System.out.println(
												"\n\n\t>> RELÁTORIO GERADO E ENVIADO PARA EQUIPE DE REPARO RÁPIDO! << \n");
										System.out.println(fila.dequeue());
										System.out
												.println("\n\n\t>>>> SENSOR ACIMA RETIRADO DA FILA DE ANÁLISE! <<<< ");
									} else if (periodo.equals("L")) {
										System.out.println(
												"\n\n\t>> RELÁTORIO GERADO E ENVIADO PARA EQUIPE DE PESQUISA E GRANDES REPAROS! << \n");
										System.out.println(fila.dequeue() + "\n");
										System.out
												.println("\n\n\t>>>> SENSOR ACIMA RETIRADO DA FILA DE ANÁLISE! <<<< ");
									} else if(periodo.equals("S")){
										if(!fila.isEmpty()) {
											System.out.println("\n\t >> SAINDO DA ANÁLISE, MAS AINDA HÁ SENSORES NA FILA!!! << ");
											opcaoPergunta = "N";
										}else {
											System.out.println("\n\t >> SAINDO DA ANÁLISE SEM SENSORES NA FILA!");
											opcaoPergunta = "N";
										}
										periodo = "G";
										
									}else {
										System.out.println("\n\n>> OPÇÃO INVÁLIDA!! <<");
										periodo = "C";
									}
								} else {
									System.out.println("\n\n\t >> FILA DE ANÁLISE VAZIA!! <<");
									periodo = "F";
								}
							} while (periodo.equals("C") || periodo.equals("L"));
							break;
						case "X":
							if(!fila.isEmpty()) {
								System.out.println("\n\t >> SAINDO DA ANÁLISE, MAS AINDA HÁ SENSORES NA FILA!!! << ");
								opcaoPergunta = "N";
							}else {
								System.out.println("\n\t >> SAINDO DA ANÁLISE SEM SENSORES NA FILA!");
								opcaoPergunta = "N";
							}
							break;
						default:
							System.out.println("\n\n\t >> OPÇÃO INVÁLIDA!! <<");
							break;
						}
					} while (!opcaoPergunta.equals("N"));

				} else {
					System.out.println("\n\n\t\t>> FILA DE ANÁLISE VAZIA!! <<");
					opcaoPergunta = "N";
				}
			} else if (opcaoPergunta.equals("N")) {
				System.out.println("\n\t   >> VOLTANDO PARA O MENU <<");
				opcaoPergunta = "N";
			} else {
				System.out.println("\n\t   >> OPÇÃO INVÁLIDA! <<");
			}
		} while (!opcaoPergunta.equals("N"));
		return opcaoPergunta;
	}

	public String apresentarFazenda() {
		return String.format(
				"\n\t\t\t\t>> SISTEMA: AgriBrain << \n\n\t\tFAZENENDA ANÁLISADA: Sol Verde\n\t\tENDEREÇO: Rodovia da Soja, km 10, Município da Esperança, Estado do Agronorte\n\t\tTELEFONE: (51)1122-3344 ");
	}
}
