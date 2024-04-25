package br.com.fiap.mensagem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.fiap.funcionarioKraft.Funcionario;

public class Mensagem {

	private int idMensagem;
	private Funcionario responsavelPeloRegistro;
	private String dataRegistro;
	private String tipoMensagem;
	private String textoMensagem;
	private Random rad;

	public Mensagem() {

	}

	public Mensagem(Funcionario funcionario, String texto, String opp) {
		this.rad = new Random();
		this.setIdMensagem((this.rad.nextInt(1, 50))^2);
		this.responsavelPeloRegistro = funcionario;
		this.dataRegistro = setandoData();
		this.textoMensagem = texto;
		this.tipoMensagem = opp;
	}
	
	

	private void setIdMensagem(int idMensagem) {
		this.rad = new Random();
		int aleatorio = rad.nextInt(100, 1000)+1;
		this.idMensagem = (idMensagem + aleatorio-12);
	}

	public int getIdMensagem() {
		return idMensagem;
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

	private String setandoData() {
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataAtual.format(formato);
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"\n>> ID DA MENSAGEM:%d\nFuncionário responsável pela captura e registro......: %s\nData do registro.....: %s\nTipo de mensagem.....: %s\nTexto.....: %s\n",
				getIdMensagem(),getResponsavelPeloRegistro(), getDataRegistro(), getTipoMensagem(), getTextoMensagem());
	}

}
