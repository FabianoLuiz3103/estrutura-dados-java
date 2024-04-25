package br.com.fiap.mensagem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.fiap.funcionarioKraft.Funcionario;

public class Mensagem {

	private Funcionario responsavelPeloRegistro;
	private String dataRegistro;
	 private String tipoMensagem; //NÃO IMPLEMENTADO!!!!
	private String textoMensagem;

	public Mensagem() {

	}

	public Mensagem(Funcionario funcionario, String texto, String opp) {
		this.responsavelPeloRegistro = funcionario;
		this.dataRegistro = setandoData();
		this.textoMensagem = texto;
		this.tipoMensagem = opp;
	}

	public Funcionario getResponsavelPeloRegistro() {
		return responsavelPeloRegistro;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public String getTipoMensagem() {
		return tipoMensagem;
	}

	public String getTextoMensagem() {
		return this.textoMensagem;
	}

	private
	String setandoData() {
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataAtual.format(formato);
	}

	@Override
	public String toString() {
		return String.format("\nFuncionário responsável pela captura e registro......: %s\nData do registro.....: %s\nTipo de mensagem.....: %s\nTexto.....: %s\n",
				getResponsavelPeloRegistro(), getDataRegistro(), getTipoMensagem(), getTextoMensagem());
	}

}
