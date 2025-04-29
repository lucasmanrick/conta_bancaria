package conta_bancaria.model;

import java.text.NumberFormat;

public class ContaCorrente extends Conta {
	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	} 
	
	
	@Override  // faz parte da sintaxe.
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		super.visualizar(); // traz tudo do metodo visualizar da classe super para esse metodo
		
		System.out.println("Limite da conta: " + nfMoeda.format(this.limite));
	}
	
	public boolean sacar(float quantia) {
		if ((this.getSaldo() + this.limite) < quantia) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - quantia);
		return true;
	}
	
	
}
