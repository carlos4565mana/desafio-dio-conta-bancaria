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
        System.out.println("|               Opção 6 - Sair                        |");
        System.out.println("=======================================================");
        
        int operacao = input.nextInt();
    	
    	switch(operacao) {
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
        	 System.out.println("Saindo do Sistema.......");
        	 System.exit(0);
        	 
         default:
             System.out.println("Opção inválida!");
             operacoes();
             break;

    	}
	

}

	public static void listarContas() {
	
		
	}

	public static void transferir() {
		
		
	}

	public static void sacar() {
	
		System.out.println("Digite o Número da Conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		System.out.println(conta);
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta cont : contasBancarias) {
				if(cont.getNumeroConta() == numeroConta) {
					conta = cont;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		
		System.out.println("Digite o Número da Conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

		
	}
	

	public static void criarConta() {
		
		System.out.println("\nDigite o Nome: ");
		String nome =  input.next();
		
		System.out.println("\nDigite o Email: ");
        String email = input.next();
        
        System.out.println("\nDigite o CPF: ");
        String cpf = input.next();
        
        System.out.println("Digite sua Senha: ");
        String senha = input.next();
        
        Pessoa cliente = new Pessoa(nome, cpf, email, senha);
        
        Conta conta = new Conta(cliente);
        
        contasBancarias.add(conta);
        int teste = conta.getNumeroConta();
        System.out.println(teste);
        System.out.println(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");
        operacoes();
        
	}
}
