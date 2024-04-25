package br.com.fiap.aplicacao;

// >>>>>>>>>>>>> INTEGRANTES <<<<<<<<<<<<<<<<<<<

/**
 * @author Eduardo Henriques Bertelli --------  RM:92966
 * @author Fabiano Luiz Santos de Sanatana ---- RM:96044
 * @author Fernando Igino Machado ------------- RM:94712
 * @author Gustavo Crosera Lobo --------------- RM:93202
 * @author Lucas Aguido Mazzeto --------------- RM:93303
 */

import java.util.Scanner;

import br.com.fiap.FuncoesAuxiliares.FuncoesITE;
import br.com.fiap.fila.FilaMensagens;
import br.com.fiap.mensagem.Mensagem;

public class Aplicacao {

	public static void main(String[] args) {

		// USAR ESSES REGISTROS DE MATR�CULA DOS "FUNCION�RIOS" PARA FAZER LOGIN E
		// SEGUIR COM O PORGRAMA:
		// 12345A, 23456B, 34567C, 45678D, 56789E, 67890F, 78901G, 89012H, 90123I,
		// 01234J, 23456K, 34567L, 45678M, 56789N, 67890O, 78901P, 89012Q, 90123R,
		// 01234S, 12345T.
		FilaMensagens<Mensagem> filaAmbiental = new FilaMensagens<Mensagem>();
		FilaMensagens<Mensagem> filaSocial = new FilaMensagens<Mensagem>();
		FilaMensagens<Mensagem> filaGovernanca = new FilaMensagens<Mensagem>();
		Scanner teclado = new Scanner(System.in);
		String rmInformado;
		boolean validado;
		char login;
		String opcao;

		do {

			System.out.println("\n\nOl�, deseja fazer login? (S/N)");
			System.out.println("  N - PARA ENCERRAR PROGRAMA!");
			login = teclado.nextLine().toUpperCase().charAt(0);

			if (login == 'S' && (filaAmbiental.isEmpty() && filaSocial.isEmpty() && filaGovernanca.isEmpty())) {

				System.out.println("\nInforme seu rm:");
				rmInformado = teclado.nextLine();
				FuncoesITE funcaoIte = new FuncoesITE();
				validado = funcaoIte.validarAcessoFuncionario(rmInformado);

				if (validado) {
					System.out.println("\n\t\tBEM VINDO(A)");
					System.out.println(funcaoIte.apresentarFuncionario());

					do {
						System.out.println("\n\t\tINSIRA" + "\n\t<I>: Para menu de inser��o;"
								+ "\n\t<T>: Para menu de triagem;" + "\n\t<E>: Para menu de exibi��o;"
								+ "\n\t<X>: Para voltar para menu de login.");
						opcao = teclado.nextLine().toUpperCase();

						switch (opcao) {
						case "I":
							funcaoIte.insert(filaAmbiental, filaSocial, filaGovernanca);
							break;
						case "T":
							funcaoIte.triagem(filaAmbiental, filaSocial, filaGovernanca);
							break;
						case "E":
							funcaoIte.displayQueues(filaAmbiental, filaSocial, filaGovernanca);
							break;
						case "X":
							if (!filaAmbiental.isEmpty() || !filaSocial.isEmpty() || !filaGovernanca.isEmpty()) {
								System.out.println("\n\nERRO AO VOLTARA PARA A TELA DE LOGIN!");
								System.out.println("Ainda h� mensagens para serem tratadas!");
							} else {
								System.out.println("\nVOLTANDO PARA LOGIN! ");
								opcao = "-";
							}
							break;
						default:
							System.out.println("\nOP��O INV�LIDA! ");
							break;
						}

					} while (!opcao.equals("-"));
				} else
					System.out.println("\t\nFUNCION�RIO N�O ENCONTRADO / N�O CADASTRADO!");
			} else {
				System.out.println("\n" + "" + "FIM DA EXECU��O! ");
			}

		} while (login == 'S');
		teclado.close();
	}
}
