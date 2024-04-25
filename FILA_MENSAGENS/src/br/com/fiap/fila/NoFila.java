package br.com.fiap.fila;

public class NoFila {
	
	private String elemento;
	private NoFila proximo;
	
	public NoFila(String elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public NoFila(String elemento, NoFila proximo) {
		this(elemento);
		this.proximo = proximo;
		
	}
	
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public NoFila getProximo() {
		return proximo;
	}
	public void setProximo(NoFila proximo) {
		this.proximo = proximo;
	}
}
