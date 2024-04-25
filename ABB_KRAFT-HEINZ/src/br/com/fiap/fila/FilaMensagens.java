package br.com.fiap.fila;

public class FilaMensagens <TIPO> {

	private NoFila <TIPO> ini, fim;

	public FilaMensagens() {

	}
	
	public void init() {
		this.ini = null;
		this.fim = null;
	}

	public NoFila<TIPO> getIni() {
		return ini;
	}

	public void setIni(NoFila<TIPO> ini) {
		this.ini = ini;
	}

	public NoFila<TIPO> getFim() {
		return fim;
	}

	public void setFim(NoFila<TIPO> fim) {
		this.fim = fim;
	}

	public void enqueue(TIPO elemento) {
		NoFila<TIPO> no = new NoFila<TIPO>(elemento);
		no.setProximo(null);
		if (isEmpty()) {
			this.ini = no;
		} else {
			this.fim.setProximo(no);
		}
		this.fim = no;
	}

	public TIPO dequeue() {
		TIPO valorRemovido = this.ini.getElemento();
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

	public TIPO firstElement() {
		TIPO valor = this.ini.getElemento();
		return valor;
	}
	
	 public void exibirTodos() {
	        NoFila<TIPO> noAtual = ini;
	        while (noAtual != null) {
	            System.out.println(noAtual.getElemento());
	            noAtual = noAtual.getProximo();
	        }
	    }
	 
}
