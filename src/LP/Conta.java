package LP;

import java.util.ArrayList;

public abstract class Conta {
	protected static int contador = 0;
	protected double saldo;
	protected int codigoConta;
	protected Cliente cliente;
	protected ArrayList<Operacao> lstOperacoes;

	public Conta() {
	}

	public Conta(int codigo) {
		this.codigoConta = codigo;
	}

	public Conta(double saldo, Cliente cliente) {
		this.saldo = saldo;
		this.codigoConta = ++contador;
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setCodigo(int codigo) {
		this.codigoConta = codigo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (codigoConta != other.codigoConta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", codigoConta=" + codigoConta + ", cliente=" + cliente + "]";
	}
	
	public abstract void viraMes();

	public void addOperacao(Operacao operacao) {
		
		this.lstOperacoes.add(operacao);
		
	}

	public boolean sacar(double valor) {
		boolean ok = false;
		if (this.saldo - valor >= 0) {
			this.saldo -= valor;
			ok = true;
		}
		return ok;
	}
	
	public boolean depositar(double valor) {
			this.saldo += valor;
			return true;
	}
	
	public boolean transferir(double valor, Conta conta) {
		
		if(this.getSaldo()>0) {
			this.sacar(valor);
			conta.depositar(valor);
			return true;
		}else {
			return false;
		}
	
	}

	public String extrato() {
		String saida = "";
		
		saida = lstOperacoes.toString();
		
		return saida;
		
	}
}
