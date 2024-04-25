package br.com.fiap.entidades;

public class Mensagem {
	
	private String nome;
	private String email;
	private String telefone;
	private int opcao;
	private String textoMensagem;
	
	public Mensagem() {
		
	}
	public Mensagem(String nome, String email, String telefone, int opcao, String texto) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.opcao = opcao;
		this.textoMensagem = texto;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getEmail() {
		return this.email;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public int getOpcao() {
		return this.opcao;
	}
	public String getTextoMensagem() {
		return this.textoMensagem;
	}
	@Override
	public String toString() {
		return String.format("Nome....: %s\nEmail....: %s\nTelefone:"
				+ " %s\nOpção de mensagem....: %d\nMensagem....: %s\n", 
				getNome(), getEmail(), getTelefone(), getOpcao(), getTextoMensagem());
	}

}
