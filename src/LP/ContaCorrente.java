package LP;

import java.util.Scanner;

public class ContaCorrente extends Conta {
	private double limite;
	private double juros = 0.03;
	private double tarifa = 20;

	static Scanner entrada = new Scanner(System.in);
	

	public ContaCorrente(int cod){
		super(cod);
	}
	
	public ContaCorrente( double saldo, double limite, Cliente cliente) {
		super(saldo, cliente);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getJuros() {
		return juros;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void viraMes() {
		this.saldo -= this.saldo * juros;
		this.saldo -= tarifa;
	}

	public boolean sacar(double valor) {
		boolean saque = false;

		if (this.saldo - valor <= 0 ) {
			this.saldo -= valor;
			saque = true;
		}

		return saque;
	}


	@Override
	public String toString() {
		return "ContaCorrente [limite=" + limite + ", saldo=" + saldo + ", codigoConta=" + codigoConta + ", cliente="
				+ cliente + "]";
	}

	
}
