package br.com.fiap.funcionarioKraft;

public class Funcionario {

	private String nome;
	private String rmFuncionario;

	public Funcionario() {

	}

	public Funcionario(String nome, String rmFuncionario) {
		this.nome = nome;
		this.rmFuncionario = rmFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public String getRmFuncionario() {
		return rmFuncionario;
	}

	public String[] fazerVetFuncionario() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(this.nome);
		sbf.append(',');
		sbf.append(this.rmFuncionario);

		String[] vetFuncionarios = new String[20];
		for (int i = 0; i < vetFuncionarios.length; i++) {
			vetFuncionarios[i] = sbf.toString();
		}
		return vetFuncionarios;
	}

	// separando a string(atributos) que já estão associados a uma posição do vetor
	// Funcionário
	public boolean validarFuncionario(String rmInformado) {
		String[] quebrado = null;
		for (int i = 0; i < 20; i++) {
			quebrado = fazerVetFuncionario()[i].split(",");
		}

		if (rmInformado.equals(quebrado[1])) {
			return true;
		} else {
			return false;
		}
	}
	
	public String apresetar() {
		return String.format("\n\t  > %s <\n", getNome());
	}

	@Override
	public String toString() {
		return String.format("%s,  "
				+ "Matrícula.....: %s", getNome(), getRmFuncionario());
	}
	
}
