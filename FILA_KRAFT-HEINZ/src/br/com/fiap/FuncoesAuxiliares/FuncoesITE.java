package br.com.fiap.FuncoesAuxiliares;


import br.com.fiap.fila.FilaMensagens;
import br.com.fiap.funcionarioKraft.DadosFuncionarios;
import br.com.fiap.funcionarioKraft.Funcionario;
import br.com.fiap.mensagem.Mensagem;

public class FuncoesITE {

	private String apresentacao;
	private String opp;
	private int indice;
	private Funcionario[] funcionario = new Funcionario[20];
	private Funcoes funcaoAux = new Funcoes();

	public boolean validarAcessoFuncionario(String rmInformado) {
		
		boolean[] validar = new boolean[20];
		DadosFuncionarios df = new DadosFuncionarios();
		for (int i = 0; i < 20; i++) {
			this.funcionario[i] = new Funcionario(df.nomesFuncionarios()[i], df.registrosMatricula()[i]);
			this.funcionario[i].fazerVetFuncionario();
			validar[i] = this.funcionario[i].validarFuncionario(rmInformado);

			if (validar[i]) {
				this.indice = i;
				this.apresentacao = this.funcionario[this.indice].apresetar();
				return validar[i];
			}
		}
		return false;
	}

	// Retorna o índice onde o rm foi validado 
	private int getIndice() {
		return this.indice;
	}
	
	// Apresenta o nome e rm do funcionário após login validado
	public String apresentarFuncionario() {
		return this.apresentacao;
	}

	//============================================================================================
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> FUNÇÕES (I.T.E.) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	// Inserir na fila <I>
	public void insert(FilaMensagens<Mensagem> filaAmbiental, FilaMensagens<Mensagem> filaSocial,
			FilaMensagens<Mensagem> filaGovernanca) {

		filaAmbiental.init();
		filaSocial.init();
		filaGovernanca.init();
		do {
			System.out.println("\n>>>>>> MENU PARA INSERIR MENSAGENS <<<<<<");
			this.opp = this.funcaoAux.opcao();
			switch (this.opp) {
			// a funcao mensagem recebe o funcionário na posiçao do indice validado
			case "E":
				filaAmbiental.enqueue(this.funcaoAux.mensagem(this.funcionario[getIndice()], this.opp));
				break;
			case "S":
				filaSocial.enqueue(this.funcaoAux.mensagem(this.funcionario[getIndice()], this.opp));
				break;
			case "G":
				filaGovernanca.enqueue(this.funcaoAux.mensagem(this.funcionario[getIndice()], this.opp));
				break;
			case "V":
				System.out.println("\t\tVOLTANDO PARA MENU PRINCIPAL");
				this.opp = "V";
				break;
			default:
				System.out.println("\t\tOPÇÃO INVÁLIDA");
				break;
			}
		} while (this.opp != "V");
	}
	
	//============================================================================================
    // Fazer triagem na fila <T>
	public void remove(FilaMensagens<Mensagem> filaAmbiental, FilaMensagens<Mensagem> filaSocial,
			FilaMensagens<Mensagem> filaGovernanca) {

		Mensagem msgRetirada = null;
		do {
			System.out.println("\n>>>>>> MENU PARA TRIAGEM(REMOÇÃO) DE MENSAGENS <<<<<<");
			this.opp = this.funcaoAux.opcao();
			String resp = null;
			switch (this.opp) {

			case "E":
				if (!filaAmbiental.isEmpty()) {
					System.out.println(">>>>>> AMBIENTAL <<<<<<");
					this.funcaoAux.perguntaRemove(filaAmbiental, msgRetirada, resp);
				} else
					System.out.println("\nFILA AMBIENTAL VAZIAL");

				break;
			case "S":
				if (!filaSocial.isEmpty()) {
					System.out.println(">>>>>> SOCIAL <<<<<<");
					this.funcaoAux.perguntaRemove(filaSocial, msgRetirada, resp);
				} else
					System.out.println("\nFILA SOCIAL VAZIA");
				break;
			case "G":
				if (!filaGovernanca.isEmpty()) {
					System.out.println(">>>>>> GOVERNANÇA <<<<<<");
					this.funcaoAux.perguntaRemove(filaGovernanca, msgRetirada, resp);
				} else
					System.out.println("\nFILA GOVERNANÇA VAZIA");
				break;
			case "V":
				System.out.println("\t\tVOLTANDO PARA MENU PRINCIPAL");
				this.opp = "V";
				break;
			default:
				System.out.println("\t\tOPÇÃO INVÁLIDA");
				break;
			}
		} while (this.opp != "V");
	}

	//============================================================================================
	// Exibir todas as filas <E>
	public void displayQueues(FilaMensagens<Mensagem> filaAmbiental, FilaMensagens<Mensagem> filaSocial,
			FilaMensagens<Mensagem> filaGovernanca) {
		System.out.println("\n>>>>>> EXIBINDO TODAS AS FILAS <<<<<<");

		System.out.println("\n=======================================");
		if (!filaAmbiental.isEmpty()) {
			System.out.println(">>>>>> FILA AMBIENTAL <<<<<<");
			filaAmbiental.exibirTodos();
		} else
			System.out.println("- FILA AMBIENTAL VAZIA!\n");

		System.out.println("\n=======================================");
		if (!filaSocial.isEmpty()) {
			System.out.println(">>>>>> FILA SOCIAL <<<<<<");
			filaSocial.exibirTodos();
		} else
			System.out.println("- FILA SOCIAL VAZIA!\n");

		System.out.println("\n=======================================");
		if (!filaGovernanca.isEmpty()) {
			System.out.println(">>>>>> FILA GOVERNANÇA <<<<<<");
			filaGovernanca.exibirTodos();
		} else
			System.out.println("- FILA GOVERNANÇA VAZIA!\n");

		// volta para o menu principal (I.T.E.X) direto
		System.out.println("\n\tVOLTANDO PARA MENU INICIAL...");
	}

}
