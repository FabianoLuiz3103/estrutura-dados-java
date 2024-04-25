package lista;

import sensores.Sensor;

public class NO {

	private Sensor dado;
	private NO prox;
	
	public Sensor getDado() {
		return dado;
	}
	
	public NO getProx() {
		return prox;
	}

	protected void setDado(Sensor dado) {
		this.dado = dado;
	}

	protected void setProx(NO prox) {
		this.prox = prox;
	}
	
	

}
