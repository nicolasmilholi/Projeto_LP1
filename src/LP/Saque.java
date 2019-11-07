package LP;

import java.util.Date;

public class Saque implements Operacao {

	private Conta contaOrigem;
	private double valor;
	private Date data = new Date();

	public Saque(Conta objConta, double valor) {
		this.contaOrigem = objConta;
		this.valor = valor;
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
