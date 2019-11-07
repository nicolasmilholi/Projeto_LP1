package LP;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
	static Scanner entrada = new Scanner(System.in);
	
	
	
	private double rendimento = 0.5;

	public ContaPoupanca(int codConta) {
		super(codConta);
	}

	public ContaPoupanca( double saldo, double rendimento, Cliente cliente) {
		super(saldo, cliente);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}


	@Override
	public String toString() {
		return "ContaPoupanca [rendimento=" + rendimento + ", saldo=" + saldo + ", codigoConta=" + codigoConta
				+ ", cliente=" + cliente + "]";
	}

	public void viraMes() {
		this.saldo += this.saldo * rendimento;
	}
	
}
