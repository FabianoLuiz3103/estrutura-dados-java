package lista;

import sensores.Sensor;

public class ListaSensorCrescente {


	private NO lista = null;

	public NO getLista() {
		return lista;
	}

	//SENSORES ORDENADOS DO MAIOR PH PARA O MENOR PH
	public void insere(Sensor elem) {
		NO novo = new NO();
		novo.setDado(elem);
		if (lista == null) {
			novo.setProx(null);
			lista = novo;
		} else {
			if ((novo.getDado().getPh() < lista.getDado().getPh())) {
				novo.setProx(lista);
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				while (aux.getProx() != null && !achou) {
					if ((aux.getProx().getDado().getPh() < novo.getDado().getPh()))
						aux = aux.getProx();
					else
						achou = true;
				}
				novo.setProx(aux.getProx());
				aux.setProx(novo);
			}
		}
	}

	public boolean remove(String valor) {
		boolean achou = false;
		if (lista != null) {
			if (valor.equals(lista.getDado().getCoordenadas())) {
				achou = true;
				lista = lista.getProx();
			} else {
				NO aux = lista;
				while (aux.getProx() != null && !achou) {
					if (!aux.getProx().getDado().getCoordenadas().equals(valor))
						aux = aux.getProx();
					else {
						achou = true;
						aux.setProx(aux.getProx().getProx());
					}
				}
			}
		}
		return achou;
	}

	public int contaNos() {
		int cont = 0;
		NO aux = lista;
		while (aux != null) {
			cont++;
			aux = aux.getProx();
		}
		return cont;
	}

	public void apresenta() {
		NO aux = lista;
		while (aux != null) {
			System.out.println("\t " + aux.getDado().toString());
			aux = aux.getProx();
		}
	}

	public String consulta(String coordenada) {
		NO aux = lista;
		String naoEncontrou = "";

		while (aux != null) {
			if (aux.getDado().getCoordenadas().equals(coordenada))
				return aux.getDado().toString();
			else
				naoEncontrou = "\n\t >> COORDENADA NÃO ENCONTRADA << ";

			aux = aux.getProx();
		}
		return naoEncontrou;
	}

}
