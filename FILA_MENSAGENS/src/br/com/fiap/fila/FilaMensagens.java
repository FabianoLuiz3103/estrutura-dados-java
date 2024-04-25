package br.com.fiap.fila;

public class FilaMensagens {

	private NoFila ini, fim;
	private int tamanho;

	public FilaMensagens() {
		this.tamanho = 0;
		this.ini = null;
		this.fim = null;
	}

	public NoFila getIni() {
		return ini;
	}

	public void setIni(NoFila ini) {
		this.ini = ini;
	}

	public NoFila getFim() {
		return fim;
	}

	public void setFim(NoFila fim) {
		this.fim = fim;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void enqueue(String elemento) {
		NoFila no = new NoFila(elemento);
		no.setProximo(null);
		if (isEmpty()) {
			this.ini = no;
			tamanho++;
		} else {
			this.fim.setProximo(no);
			tamanho++;
		}
		this.fim = no;
	}

	public String dequeue() {
		String valorRemovido = this.ini.getElemento();
		this.ini = this.ini.getProximo();
		if (this.ini == null)
			this.fim = null;
		return valorRemovido;

	}

	public boolean isEmpty() {
		if (this.ini == null && this.fim == null)
			return true;
		else
			return false;
	}

	public String firstElement() {
		String valor = this.ini.getElemento();
		return valor;
	}
	
	 public void exibirTodos() {
	        NoFila noAtual = ini;
	        while (noAtual != null) {
	            System.out.println(noAtual.getElemento());
	            noAtual = noAtual.getProximo();
	        }
	    }
}
