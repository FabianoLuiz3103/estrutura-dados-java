package br.com.fiap.entidades;

import br.com.fiap.fila.FilaMensagens;

public class FuncaoApresentarFilas {

	//CONSTRUTOR RESPONSÁVEL POR EXIBIR SÓ AS FILAS DE RECLAMAÇÃO E SUGESTÃO, ANTES DA FILA DE 
	//RESOLUÇÃO COMEÇAR A SER PREENCHIDA.
	public FuncaoApresentarFilas(FilaMensagens filaReclamacao, FilaMensagens filaSugestao) {
		if(!filaReclamacao.isEmpty()) {
			System.out.println(">>>>>> FILA DE RECLAMAÇÃO <<<<<<\n");
			filaReclamacao.exibirTodos();
		}else
			System.out.println("- FILA DE RECLAMAÇÃO VAZIA!\n");
		
		if(!filaSugestao.isEmpty()) {
			System.out.println(">>>>>> FILA DE SUGESTÃO <<<<<<\n");
			filaSugestao.exibirTodos();
		}else
			System.out.println("- FILA DE SUGESTAO VAZIA!\n");
		
	}
	
	//SOBREGARGA DE CONSTRUTOR RESPONSÁVEL POR EXIBIR AS FILAS DE RECLAMAÇÃO E SUGESTÃO, COM A FILA DE 
	//RESOLUÇÃO PODENDO JÁ ESTAR PREENCHIDA 
	public FuncaoApresentarFilas(FilaMensagens filaResolucao, FilaMensagens filaReclamacao, FilaMensagens filaSugestao) {
		
		this(filaReclamacao, filaSugestao);
		if(!filaResolucao.isEmpty()) {
			System.out.println(">>>>>> FILA DE RESOLUCAO <<<<<<\n");
			filaResolucao.exibirTodos();
		}else
			System.out.println("- FILA DE RESOLUCAO VAZIA!\n");
	}
}
