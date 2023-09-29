package programa;

public class Conta {
	private static int contadorContas = 1020;
	
	private int numeroConta;
	private String agencia;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta( Pessoa pessoa) {
		this.numeroConta = contadorContas;
		this.pessoa = pessoa;
		contadorContas += 1;
	
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	 public String toString() {

	        return "\nBank account: " + this.getNumeroConta() +
	                "\nCliente: " + this.pessoa.getNome() +
	                "\nCPF: " + this.pessoa.getCpf() +
	                "\nEmail: " + this.pessoa.getEmail() +
	                "\n" ;
	    }

	public void depositar(Double valor) {
		if(valor > 0) {
			this.saldo = getSaldo() + valor;
			System.out.println("Seu depósito foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar o depósito.");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo()>= valor) {
			this.saldo = getSaldo() - valor;
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar o Saque!");
		}
	}
	
	
	
}
