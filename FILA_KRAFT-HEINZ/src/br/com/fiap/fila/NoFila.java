package br.com.fiap.fila;

public class NoFila <TIPO> {
	
	private TIPO elemento;
	private NoFila<TIPO> proximo;
	
	public NoFila(TIPO elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public NoFila(TIPO elemento, NoFila<TIPO> proximo) {
		this(elemento);
		this.proximo = proximo;
		
	}
	
	public TIPO getElemento() {
		return elemento;
	}
	public void setElemento(TIPO elemento) {
		this.elemento = elemento;
	}
	public NoFila<TIPO> getProximo() {
		return proximo;
	}
	public void setProximo(NoFila<TIPO> proximo) {
		this.proximo = proximo;
	}
}
