package conta_bancaria.model;

import java.text.NumberFormat;

public abstract class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	//Metodo Bancario
	
	public boolean sacar(float quantia) {
		if (this.saldo < quantia) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		this.setSaldo(this.saldo - quantia);
		return true;
	}
	
	public void depositar (float quantia) {
		if (quantia <= 0) {System.out.println("valor invalido para depositar!"); return;}
		this.setSaldo(this.saldo + quantia);
	}
	
	//Metodo de visualização
	
	public void visualizar() {
		String tipo = "";
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		System.out.println("******************************");
		System.out.println("        DADOS DA CONTA        ");
		System.out.println("******************************");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Número da agencia: " + this.agencia);
		switch (this.tipo) {
			case 1 -> tipo = "Conta Corrente";
			case 2 -> tipo = "Conta Poupança";
			default -> tipo = "Invalido";
		}
		System.out.println("tipo da conta: " + tipo);
		System.out.println("titular da conta: " + this.titular);
		System.out.println("saldo da conta: " + nfMoeda.format(this.saldo));
	}
	
	
}
