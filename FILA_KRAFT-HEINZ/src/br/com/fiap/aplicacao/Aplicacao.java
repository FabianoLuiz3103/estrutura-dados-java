package br.com.fiap.aplicacao;

// >>>>>>>>>>>>> INTEGRANTES <<<<<<<<<<<<<<<<<<<

/**
 * @author Fabiano Luiz Santos de Sanatana ---- RM:96044
 */

import java.util.Scanner;

import br.com.fiap.FuncoesAuxiliares.FuncoesITE;
import br.com.fiap.fila.FilaMensagens;
import br.com.fiap.mensagem.Mensagem;



public class Aplicacao {

	public static void main(String[] args) {

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
							funcaoIte.remove(filaAmbiental, filaSocial, filaGovernanca);
							break;
						case "E":
							funcaoIte.displayQueues(filaAmbiental, filaSocial, filaGovernanca);
							break;
						case "X":
							if (!filaAmbiental.isEmpty() || !filaSocial.isEmpty() || !filaGovernanca.isEmpty()) {
								System.out.println("\n\nERRO AO VOLTARA PARA A TELA DE LOGIN!");
								System.out.println("Ainda h� mensagens para serem tratadas!");
							}else {
								System.out.println("\nVOLTANDO PARA LOGIN! ");
								opcao = "O";
							}
							break;
						default:
							System.out.println("\nOP��O INV�LIDA! ");
							break;
						}

					} while (opcao != "O");
				} else
					System.out.println("\t\nFUNCION�RIO N�O ENCONTRADO / N�O CADASTRADO!");
			} else {
				System.out.println("\n"
						+ ""
						+ "FIM DA EXECU��O! ");
			}

		} while (login == 'S');
		teclado.close();
	}
}
