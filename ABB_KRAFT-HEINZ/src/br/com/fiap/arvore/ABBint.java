package br.com.fiap.arvore;

import br.com.fiap.mensagem.Mensagem;

public class ABBint {
	
	private class ARVORE{
		Mensagem dado;
		ARVORE esq,dir;
	}
	
	//começa em null para dizer que a árvore está vazia
	public ARVORE root = null;
	
	public ARVORE inserir(ARVORE p, Mensagem info) {
		// insere elemento em uma ABB
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		}
		else if (info.getIdMensagem() < p.dado.getIdMensagem()) {
			p.esq= inserir (p.esq, info);
		} else {
			p.dir=inserir(p.dir, info);	
		}
		return p;
		}

	public void listaEmOrdem(ARVORE p) {
		if (p!=null) {
			listaEmOrdem(p.esq);
			System.out.print(" "+p.dado);
			listaEmOrdem(p.dir);
		}
	}
	
	public int contaNos(ARVORE p, int contador){
		
		if(p != null) {
			contador++;
			if(p.esq != null)
				contador = contaNos(p.esq, contador);
			if(p.dir != null)
				contador = contaNos(p.dir, contador);
		}
		return contador;
	}
	
	public boolean buscar(ARVORE p, int valor) {
        return buscarRecursivo(p, valor);
    }

    private boolean buscarRecursivo(ARVORE noAtual, int valor) {
        if (noAtual == null) {
            return false;
        }

        if (valor == noAtual.dado.getIdMensagem()) {
        	System.out.println(noAtual.dado);
            return true;
        } else if (valor < noAtual.dado.getIdMensagem()) {
            return buscarRecursivo(noAtual.esq, valor);
        } else {
            return buscarRecursivo(noAtual.dir, valor);
        }
    }
	
	
	
	

}
