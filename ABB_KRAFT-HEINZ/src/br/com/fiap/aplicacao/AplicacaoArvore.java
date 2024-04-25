package br.com.fiap.aplicacao;

import java.util.Scanner;

import br.com.fiap.arvore.ABBint;
import br.com.fiap.funcionarioKraft.Funcionario;
import br.com.fiap.mensagem.Mensagem;

public class AplicacaoArvore {
	
	public static void main(String[] args){
		ABBint abb = new ABBint();
		Funcionario func = new Funcionario("Fabiano Luiz", "FL96044");
		Funcionario func2 = new Funcionario("Yolanda Bi", "Yobi96055");
		
		
		Mensagem msg1 = new Mensagem(func, "RAIZ Ol�, mundo", "E");
		Mensagem msg2 = new Mensagem(func, "Ol�, heinz", "S");
		Mensagem msg3 = new Mensagem(func2, "Ol�, BBS", "G");
		Mensagem msg4 = new Mensagem(func, "A heinz � horr�vel", "E");
		Mensagem msg5 = new Mensagem(func, "Que empresa ruim", "S");
		Mensagem msg6 = new Mensagem(func2, "N�o gosto", "G");
		Mensagem msg7 = new Mensagem(func, "n�o consigo comer nada", "E");
		Mensagem msg8 = new Mensagem(func, "Ol�, heinz", "S");
		Mensagem msg9 = new Mensagem(func2, "Oxi, o que � isso", "G");
		Mensagem msg10 = new Mensagem(func, "Ol�, mundo", "E");
		Mensagem msg11 = new Mensagem(func, "Ol�, heinz", "S");
		Mensagem msg12 = new Mensagem(func2, "V�o se foder", "G");
		
		abb.root = abb.inserir(abb.root, msg1);
		abb.root = abb.inserir(abb.root, msg2);
		abb.root = abb.inserir(abb.root, msg3);
		abb.root = abb.inserir(abb.root, msg4);
		abb.root = abb.inserir(abb.root, msg5);
		abb.root = abb.inserir(abb.root, msg6);
		abb.root = abb.inserir(abb.root, msg7);
		abb.root = abb.inserir(abb.root, msg8);
		abb.root = abb.inserir(abb.root, msg9);
		abb.root = abb.inserir(abb.root, msg10);
		abb.root = abb.inserir(abb.root, msg11);
		abb.root = abb.inserir(abb.root, msg12);
		
		
		System.out.println(" Apresentando os elementos da ABB");
		abb.listaEmOrdem(abb.root);
		
		System.out.println("\n Quanditdade de n�s da ABB = " + abb.contaNos(abb.root, 0));
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o id que deseja buscar: ");
		int id = teclado.nextInt();
		System.out.println(abb.buscar(abb.root, id));
	
		
	}
}
