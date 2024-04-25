package main;

/**
 *@author Fabiano Luiz Santos de Santana ---- RM:96044   
 *
 */

import java.util.Scanner;

import fila.FilaSensor;
import lista.ListaSensorCrescente;
import sensores.Funcoes;
import sensores.Sensor;

public class Aplicacao {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Sensor sensor = null;
		Funcoes funcao = new Funcoes();
		ListaSensorCrescente lista = new ListaSensorCrescente();
		FilaSensor fila = new FilaSensor();
		fila.init();//iniciando a fila
		int cont = 0;
		// -------------------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < funcao.sensoresJaRegistrados().length; i++) {
			sensor = new Sensor(funcao.sensoresJaRegistrados()[i], cont);// criando os primeiros sensores com as coordenadas fornecidas
			lista.insere(sensor);// adicionando os sensores criados na lista
          cont++;
		}
		// -------------------------------------------------------------------------------------------------------------------------

		System.out.println(funcao.apresentarFazenda());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		String opcaoPergunta;
		do {
			System.out.println("\n\n\n\n\t\t>>> MENU INICIAL <<<");
			System.out.println("\n\t\t\t >> DIGITE: <<");
			System.out.println(
					"\t<0>: PARA EXIBIR SENSORES REGISTRADOS;" + "\n\t<1>: PARA ADICIONAR NOVOS SENSORES;" + "\n\t<2>: PARA CONSULTAR UM SENSOR ESPEC�FICO"
							+ "\n\t<3>: PARA VERIFICAR PAR�METROS (DENTRO DO NORMAL/FORA DO NORMAL) DOS SENSORES;" + "\n\t<4>: PARA VERIFICAR A FILA DE AN�LISE"
									+ "\n\t<X>: PARA ENCERRAR O PROGRAMA!");
			opcaoPergunta = teclado.next().toUpperCase();

			switch (opcaoPergunta) {

			case "0":
				System.out.println("\n\n\t >> SENSORES REGISTRADOS <<<");
				System.out.println("\t >> ORDENA��O: DO MAIOR PH PARA O MENOR PH << ");
				lista.apresenta();
				break;
			case "1":

				do {
					System.out.println("\n\t >> DESEJA ADICIONAR SENSOR? (S/N) << ");
					opcaoPergunta = teclado.next().toUpperCase();
					if (opcaoPergunta.equals("S")) {
						System.out.println("\n\tINFORME AS COORDENADAS, ASSIM COMO NO EXEMPLO ABAIXO:");
						System.out.println("\t\t�47o55�44�W,21o00�34�S�");
						teclado.nextLine();
						String coordenadas = teclado.nextLine();
						sensor = new Sensor(coordenadas, cont);
						lista.insere(sensor);

						System.out.println("\n" + lista.consulta(coordenadas));
						System.out.println("\n\n\t>>>> ADICIONADO COM SUCESSO!! <<<<");
					}else if(opcaoPergunta.equals("N")) {
						System.out.println("\n\t   >> VOLTANDO PARA O MENU <<");
					}else {
						System.out.println("\n\t   >> OP��O INV�LIDA! <<");
					}
					cont++;
				} while (!opcaoPergunta.equals("N"));

				break;
			case "2":

				do {
					System.out.println("\n\n\t >> DESEJA CONSULTAR SENSOR? (S/N) << ");
					opcaoPergunta = teclado.next().toUpperCase();
					if (opcaoPergunta.equals("S")) {
						System.out.println("\n\tINFORME AS COORDENADAS, ASSIM COMO NO EXEMPLO ABAIXO:");
						System.out.println("\t\t�47o55�44�W,21o00�34�S�");
						teclado.nextLine();
						String coordenadas = teclado.nextLine();

						System.out.println("\n\n\t >> RESUTADO DA CONSULTA: << ");
						System.out.println("\n" + lista.consulta(coordenadas));
					}else if(opcaoPergunta.equals("N")) {
						System.out.println("\n\t   >> VOLTANDO PARA O MENU <<");
					}else {
						System.out.println("\n\t   >> OP��O INV�LIDA! <<");
					}
				} while (!opcaoPergunta.equals("N"));

				break;
			case "3":

				do {
					System.out.println("\n\n\t >> DESEJA VERIFICAR OS PAR�METROS DOS SENSORES? (S/N) << ");
					opcaoPergunta = teclado.next().toUpperCase();
					if (opcaoPergunta.equals("S")) {
						funcao.verificarSensores(lista);

						System.out.println(
								"\n\n\t >> DESEJA VERIFICAR QUAIS SENSORES EST�O COM MAIS DE 3 PAR�METROS INV�LIDOS? (S/N) <<");
						opcaoPergunta = teclado.next().toUpperCase();
						if (opcaoPergunta.equals("S")) {

							System.out.println("\n\n\t >>>>>> SENSORES COM MAIS DE 3 PAR�METROS INV�LIDOS: <<<<<<\n");
							funcao.sensoresParametrosRuins(sensor, lista);
								System.out.println("\n\n\t >> OS SENSORES ACIMA FORAM ENCAMINHADOS PARA A FILA DE AN�LISE!!  << ");
								fila = funcao.destinarSensores(fila, sensor, lista);
								opcaoPergunta = funcao.caseNumeroQuatro(teclado, opcaoPergunta, fila);//case numero quatro para evitar repeti��o de c�digo.
							
							
						}else if(opcaoPergunta.equals("N")) {
							System.out.println("\n\t   >> VOLTANDO PARA O MENU <<");
						}else {
							System.out.println("\n\t   >> OP��O INV�LIDA! <<");
						}
						
						
					}else if(opcaoPergunta.equals("N")) {
						System.out.println("\n\t   >> VOLTANDO PARA O MENU <<");
					}else {
						System.out.println("\n\t   >> OP��O INV�LIDA! <<");
					}
				} while (!opcaoPergunta.equals("N"));

				break;
				
			case "4":
				opcaoPergunta = funcao.caseNumeroQuatro(teclado, opcaoPergunta, fila);//case numero quatro para evitar repeti��o de c�digo.
				break;
			case "X":
				if(!fila.isEmpty()) {
					System.out.println("\n\n\t>> FALHA AO ENCERRAR O PROGRAMA!! <<");
					System.out.println("\n\n\t>> H� SENSORES NA FILA DE AN�LISE! <<");
					opcaoPergunta = "+";
				}else {
					System.out.println("\n\n\t >> FIM DA EXECU��O! << ");
				}
				break;
			default:
				System.out.println("\n\n\t >> OP��O INV�LIDA! <<");
				break;
			}

		} while (!opcaoPergunta.equals("X"));

		teclado.close();

	}

}
