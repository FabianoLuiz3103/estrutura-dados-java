//>>>>>>>>>>>>>>>> INTEGRANTES <<<<<<<<<<<<<<<<<<<<<<<<<<

/**
 * @author Fabiano Luiz Santos de Sanatana ---- RM:96044
 */

package br.com.fiap.aplicacao;

import java.util.Scanner;
import br.com.fiap.entidades.FuncaoApresentarFilas;
import br.com.fiap.entidades.Mensagem;
import br.com.fiap.fila.FilaMensagens;

public class AtendimentoMensagem {

	public static void main(String[] args) {
		FilaMensagens filaReclamacao = new FilaMensagens();
		FilaMensagens filaSugestao = new FilaMensagens();
		FilaMensagens filaResolucao = new FilaMensagens();

		Scanner teclado = new Scanner(System.in);
		int opcao, opcaoPerguntas;
		String nome, email, texto, telefone;
		Mensagem mensagem = null;

		do {
			System.out.println("\tOl�, x------x! Selecione uma op��o:");
			System.out.println("\t<0>: Encerrar o programa;" + "\n\t<1>: Enviar uma mensagem;"
					+ "\n\t<2>: Processar uma mensagem;" + "\n\t<3>: Fazer recebimento.");
			opcao = teclado.nextInt();
			switch (opcao) {
			// ENCERRAMENTO DO PROGRAMA
			case 0:
				if (filaReclamacao.isEmpty() && filaSugestao.isEmpty() && filaResolucao.isEmpty()) {
					System.out.println(">>>>>>>>>>>>>> FIM DA EXECU��O <<<<<<<<<<<<<<");
				} else {
					System.out.println("TEM MENSAGEM EM ALGUMA FILA\n");
					opcao = 4;
				}
				break;
			// ENVIAR MENSAGEM DE RECLAMA��O OU SUGEST�O
			case 1:
				do {
					System.out.println("\tQual � o tipo da mensagem? 1- Reclama��o / 2 - Sugest�o:");
					opcaoPerguntas = teclado.nextInt();
					if (opcaoPerguntas == 1 || opcaoPerguntas == 2) {
						System.out.println("\tInsira seu nome(opcional):");
						teclado.nextLine();
						nome = teclado.nextLine();
						System.out.println("\tInsira seu email:");
						email = teclado.nextLine();
						System.out.println("\tInsira seu telefone:");
						telefone = teclado.nextLine();
						System.out.println("\tInsira sua mensagem:");
						texto = teclado.nextLine();

						mensagem = new Mensagem(nome, email, telefone, opcaoPerguntas, texto);
						if (opcaoPerguntas == 1) {
							filaReclamacao.enqueue(mensagem.toString());
						} else if (opcaoPerguntas == 2) {
							filaSugestao.enqueue(mensagem.toString());
						} else {
							System.out.println("\tOP��O INV�LIDA!\n");
						}
					} else
						System.out.println("OP��O INV�LIDA!\n");
				} while (opcaoPerguntas != 1 && opcaoPerguntas != 2);
				break;
			// VER SE DA PARA RESPONDER MENSAGEM DE RECLAMA��O OU SUGEST�O
			case 2:
				// Apresentar fila de reclama��o e sugest�o
				new FuncaoApresentarFilas(filaReclamacao, filaSugestao);
				do {
					System.out.println("\tEscolha qual tipo de mensagem voc� quer responder:");
					System.out.println("\t1- Reclama��o / 2 - Sugest�o:\n");
					opcaoPerguntas = teclado.nextInt();
					
					if (opcaoPerguntas == 1 || opcaoPerguntas == 2) {
						String msgRetirada = null;

						if (opcaoPerguntas == 1 && !filaReclamacao.isEmpty())
							msgRetirada = filaReclamacao.dequeue();
						else if (opcaoPerguntas == 2 && !filaSugestao.isEmpty())
							msgRetirada = filaSugestao.dequeue();
						else
							System.out.println("\tFILA VAZIA\n");

						if (msgRetirada != null) {
							System.out.println(">>>>>> MENSAGEM <<<<<<\n");
							System.out.println(msgRetirada);
							String resp;
							System.out.println("\tA mensagem lida pode ser facilmente resopondida? (S/N)\n");
							resp = teclado.next().toUpperCase();
							if (resp.equals("S") || resp.equals("SIM"))
								System.out.println(
										"\t>>>>>>>> Enviada resposta para cliente: sua solicita��o j� foi resolvida. Obrigado!!! <<<<<<<<<\n");
							else if (resp.equals("N") || resp.equals("NAO") || resp.equals("N�O"))
								filaResolucao.enqueue(msgRetirada.toString());
							else
								System.out.println("RESPOSTA INV�LIDA!");
						}

					} else
						System.out.println("\tOP��O INV�LIDA!\n");

				} while (opcaoPerguntas != 1 && opcaoPerguntas != 2);
				// Apresentar fila de resolu��o, reclama��o e sugest�o
				new FuncaoApresentarFilas(filaResolucao, filaReclamacao, filaSugestao);
				break;
			// RESPONDER MENSAGENS PENDENTES
			case 3:
				if (!filaResolucao.isEmpty()) {
					filaResolucao.dequeue();
					System.out.println(
							"\t>>>>>>>>> Enviada resposta para cliente: sua solicita��o j� foi resolvida pelo setor respons�vel. Obrigado!!! <<<<<<<\n");
				} else
					System.out.println("\tFILA DE RESOLU��O VAZIA!\n");
				break;
			default:
				System.out.println("OP��O INV�LIDA!\n");
				break;
			}
		} while (opcao != 0);

		teclado.close();
	}

}
