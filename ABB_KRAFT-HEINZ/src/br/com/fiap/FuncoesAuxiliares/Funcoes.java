package br.com.fiap.FuncoesAuxiliares;

import java.util.Scanner;

import br.com.fiap.fila.FilaMensagens;
import br.com.fiap.funcionarioKraft.Funcionario;
import br.com.fiap.mensagem.Mensagem;

public class Funcoes {

	private Scanner teclado = new Scanner(System.in);
	String opp;

	protected String opcao() {
		String opcaoMenuInterno;
		System.out.println("\n\t\tINSIRA" + "\n\t<E>: Para as mensagens sobre questões ambientais;"
				+ "\n\t<S>: Para as mensagens sobre questões sociais;"
				+ "\n\t<G>: Para as mensagens sobre questões de governança;" + "\n\t<V>: Voltar para menu principal.");
		opcaoMenuInterno = this.teclado.nextLine().toUpperCase();
		return opcaoMenuInterno;
	}

	protected Mensagem mensagem(Funcionario func, String op) {
		String texto;
		System.out.println("\nDigite o texto: ");
		texto = this.teclado.nextLine();
		Mensagem msg = new Mensagem(func, texto, tratarOpp(op));
		return msg;

	}

	private void fazerDequeue(FilaMensagens<Mensagem> fila, Mensagem msg, String opp) {

		if (!fila.isEmpty()) {
			msg = fila.dequeue();
			if (msg != null) {
				System.out.println("\n\t\t>>>> MENSAGEM TRATADA <<<<");
				System.out.println(msg);
			}
		} else
			System.out.println("FILA " + tratarOpp(opp) + " VAZIA! ");
	}

	// Pega uma letra da sigla ESG e retorna o que ela significa
	private String tratarOpp(String opp) {
		String nomeOpp = null;
		if (opp.equals("E"))
			nomeOpp = "AMBIENTAL";
		if (opp.equals("S"))
			nomeOpp = "SOCIAL";
		if (opp.equals("G"))
			nomeOpp = "GOVERNANÇA";
		return nomeOpp;
	}

	protected void perguntaRemove(FilaMensagens<Mensagem> fila, Mensagem msg, String resp) {
		System.out.println("\n\t\tMENSAGEM");
		System.out.println(fila.firstElement().toString());
		System.out.println("A MENSAGEM É ÚTIL PARA GERAÇÃO DOS DASHBOARDS? (S/N)");
		resp = this.teclado.nextLine().toUpperCase();
		if (resp.equals("N")) {
			fazerDequeue(fila, msg, this.opp);
			System.out.println(" --- >>> A mensagem foi descartada <<<");
		} else if (resp.equals("S")) {
			fazerDequeue(fila, msg, this.opp);
			System.out.println(" --- >>> A mensagem foi enviada para os dashboards <<< ");
		} else
			System.out.println("Opção inválida!");
	}

}
