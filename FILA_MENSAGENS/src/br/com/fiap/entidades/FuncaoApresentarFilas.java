package br.com.fiap.entidades;

import br.com.fiap.fila.FilaMensagens;

public class FuncaoApresentarFilas {

	//CONSTRUTOR RESPONS�VEL POR EXIBIR S� AS FILAS DE RECLAMA��O E SUGEST�O, ANTES DA FILA DE 
	//RESOLU��O COME�AR A SER PREENCHIDA.
	public FuncaoApresentarFilas(FilaMensagens filaReclamacao, FilaMensagens filaSugestao) {
		if(!filaReclamacao.isEmpty()) {
			System.out.println(">>>>>> FILA DE RECLAMA��O <<<<<<\n");
			filaReclamacao.exibirTodos();
		}else
			System.out.println("- FILA DE RECLAMA��O VAZIA!\n");
		
		if(!filaSugestao.isEmpty()) {
			System.out.println(">>>>>> FILA DE SUGEST�O <<<<<<\n");
			filaSugestao.exibirTodos();
		}else
			System.out.println("- FILA DE SUGESTAO VAZIA!\n");
		
	}
	
	//SOBREGARGA DE CONSTRUTOR RESPONS�VEL POR EXIBIR AS FILAS DE RECLAMA��O E SUGEST�O, COM A FILA DE 
	//RESOLU��O PODENDO J� ESTAR PREENCHIDA 
	public FuncaoApresentarFilas(FilaMensagens filaResolucao, FilaMensagens filaReclamacao, FilaMensagens filaSugestao) {
		
		this(filaReclamacao, filaSugestao);
		if(!filaResolucao.isEmpty()) {
			System.out.println(">>>>>> FILA DE RESOLUCAO <<<<<<\n");
			filaResolucao.exibirTodos();
		}else
			System.out.println("- FILA DE RESOLUCAO VAZIA!\n");
	}
}
