package LP;

import java.util.Date;

public class Depositar implements Operacao {
	private Conta contaOrigem;
	private double valor;
	private Date data;

	public Depositar(Conta contaOrigem, double valor) {
		this.contaOrigem = contaOrigem;
		this.valor = valor;
		this.data = new Date();
	}

	@Override
	public boolean efetuar() {
		if (this.contaOrigem.sacar(valor)) {
			this.contaOrigem.addOperacao(this);
			return true;
		} else
			return false;

	}
}
