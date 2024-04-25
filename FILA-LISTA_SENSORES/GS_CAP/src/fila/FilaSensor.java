package fila;

import sensores.Sensor;

public class FilaSensor {

	private class NO {
		Sensor dado;
		NO prox;
	}
	NO ini, fim;

	public void init() {
		ini = fim = null;
	}
	public boolean isEmpty() {
		if (ini == null && fim == null)
			return true;
		else
			return false;
	}
	public void enqueue(Sensor elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (isEmpty())
			ini = novo;
		else
			fim.prox = novo;
		fim = novo;
	}
	public Sensor dequeue() {
		Sensor v = ini.dado;
		ini = ini.prox;
		if (ini == null)
			fim = null;
		return v;
	}
	public Sensor first() {
		return (ini.dado);
	}
	
	public void exibirTodos() {
        NO noAtual = ini;
        while (noAtual != null) {
            System.out.println(noAtual.dado.toString());
            noAtual = noAtual.prox;
        }
    }

}
