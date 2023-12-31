package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();

	}

	public static void operacoes() {

		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Agência---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|               Opção 1 - Criar conta                 |");
		System.out.println("|               Opção 2 - Depositar                   |");
		System.out.println("|               Opção 3 - Sacar                       |");
		System.out.println("|               Opção 4 - Transferir                  |");
		System.out.println("|               Opção 5 - Listar                      |");
		System.out.println("|               Opção 6 - Saldo                       |");
		System.out.println("|               Opção 7 - Sair                        |");
		System.out.println("=======================================================");

		int operacao = input.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;
		case 6:
			consultarSaldo();

		case 7:
			System.out.println("Saindo do Sistema.......");
			System.exit(0);

		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;

		}

	}
	

	private static void consultarSaldo() {
		
		System.out.println("Digite o nome da agência: ");
		String agencia = input.next();

		System.out.println("Digite o Número da Conta: ");
		int numeroConta = input.nextInt();
		
		System.out.println("Digite o Número da Senha: ");
		String senha = input.next();
		Conta conta = encontrarConta(numeroConta, agencia);
		if (conta != null) {
			if (senha.equals(conta.getPessoa().getSenha())) {
				System.out.println("Conta = "+ conta.getNumeroConta());
				System.out.println("Nome  = "+ conta.getPessoa().getNome());
				System.out.println("Saldo = "+ conta.getSaldo());

			} else {
				System.out.println("Senha incorreta!!!");
				operacoes();
			}
		} else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();

	}
	

	private static void listarContas() {
		
		System.out.println("Digite a senha de administrador!");
		String senha = input.next();
		
		if(senha.equals("admin")) {
			if (contasBancarias.size() > 0) {
				for (Conta conta : contasBancarias) {
					System.out.println(conta);
				}
			} else {
				System.out.println("--- Não há contas cadastradas ---");
			}
		}else {
			System.out.println("Você não tem privilégio de  administrador!");
		}

		

		operacoes();

	}
	

	private static void transferir() {
		
		System.out.println("\nDigite o número da conta para transferência:");
		int numeroContaRemetente = input.nextInt();
		
		System.out.println("Digite o nome da agência: ");
		String agencia = input.next();
		
        Conta contaRemetente = encontrarConta(numeroContaRemetente, agencia);
        if(contaRemetente != null) {
        	
        	System.out.println("\nDigite o número da conta do destinatário: ");
        	int numeroContaDestinatario = input.nextInt();
        	System.out.println("Digite o nome da agência: ");
    		String agenciaDestinatario = input.next();
        	
        	Conta contaDestinatario = encontrarConta(numeroContaDestinatario, agenciaDestinatario);
        	if(contaDestinatario != null) {
        		System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();
                
                System.out.println("Digite a senha:");
                String senha = input.next();
                
                if(senha.equals(contaDestinatario.getPessoa().getSenha())) {
                	contaDestinatario.transferencia(contaRemetente, valor);
                }
        	}

        	
        }else {
        	 System.out.println("--- Conta para transferência não encontrada ---");
        	
        }
		operacoes();
	}

	
	@SuppressWarnings("unused")
	private static void sacar() {
		System.out.println("Digite o nome da agência: ");
		String agencia = input.next();

		System.out.println("\nDigite o Número da Conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta, agencia);
		
		System.out.println("Conta = "+conta.getNumeroConta());
		System.out.println("Nome  = "+ conta.getPessoa().getNome());
		System.out.println("Saldo = "+ conta.getSaldo());
		
		if (conta != null) {
			
			System.out.println("Digite o valor do saque: ");
			double valorSaque = input.nextDouble();
			System.out.println("\nDigite a senha: ");
			String senha = input.next();
			if (senha.equals(conta.getPessoa().getSenha())) {
				
				if (valorSaque <= conta.getSaldo()) {
					conta.sacar(valorSaque);
					operacoes();
				} else {
					System.out.println("Valor indisponivel!");
					operacoes();
				}
			} else {
				System.out.println("Senha incorreta!");
				operacoes();
			}
		}else {
			System.out.println("conta não encontrada!");
			operacoes();
		}
	}
	

	private static Conta encontrarConta(int numeroConta, String agencia) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta cont : contasBancarias) {
				if (cont.getNumeroConta() == numeroConta && cont.getAgencia().equals(agencia))  {
					conta = cont;
				}
			}
		}
		return conta;
	}
	

	private static void depositar() {
		
		System.out.println("Digite o nome da agência: ");
		String agencia = input.next();
		

		System.out.println("Digite o Número da Conta: ");
		int numeroConta = input.nextInt();
		
		
		Conta conta = encontrarConta(numeroConta, agencia);

		if (conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();

			conta.depositar(valorDeposito);
		} else {
			System.out.println("--- Conta não encontrada ---");
		}

		operacoes();

	}
	
	

	private static void criarConta() {
		System.out.println("\nDigite o Valor de Deposito: ");
		double deposito = input.nextDouble();
		if (deposito < 1000) {
			System.out.println("Para abrir uma conta é necessário um deposito maior ou igual a R$ 1000,00.");
			operacoes();
		}

		System.out.println("\nDigite o Nome: ");
		String nome = input.next();

		int vezes = 0;
		boolean teste = false;
		String agencia = null;

		while (teste == false){
			System.out.println("Digite o nome da agencia: ");
			agencia = input.next();
			teste = agencia.matches("\\d{3}-\\d{1}");
			if (teste == false) {
				vezes++;
				if (vezes > 2) {

					operacoes();
				}

			}

		} 
		

		String cpf = null ; 
		vezes = 0;
		boolean cpfValido = false;
		
		while(cpfValido == false) {
			
			System.out.println("Digite um cpf válido!");
			cpf = input.next();
			cpfValido = Utils.validarCpf(cpf);
			
			vezes++;
			if(vezes > 2) {
				operacoes();
				
			}
			
		}
		
		String email = null ; 
		vezes = 0;
		
		boolean emailValido = false;
		while(emailValido == false) {
			
			System.out.println("Digite um email válido!");
			email = input.next();
			emailValido = Utils.validarEmail(email);
			
			vezes++;
			if(vezes > 2) {
				operacoes();
				
			}
			
		}
		
 
		System.out.println("Digite sua Senha: ");
		String senha = input.next();

		Pessoa cliente = new Pessoa(nome, email, cpf, senha);

		Conta conta = new Conta(cliente);
		
		conta.setAgencia(agencia);
		conta.depositar(deposito);

		contasBancarias.add(conta);
	
		System.out.println("--- Sua conta foi criada com sucesso! ---");

		operacoes();

	}
}
