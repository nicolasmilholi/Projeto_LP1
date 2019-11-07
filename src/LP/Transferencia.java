package LP;

import java.util.Date;

public class Transferencia implements Operacao {

	private double valor;
	private Date data;
	private Conta destino, contaOrigem;

	public Transferencia(double valor, Conta contaOrigem, Conta destino) {
		super();
		this.valor = valor;
		this.destino = destino;
		this.contaOrigem = contaOrigem;
		this.data = new Date();
	}

	@Override
	public boolean efetuar() {

		if (this.contaOrigem.transferir(valor, destino)) {

			this.contaOrigem.addOperacao(this);
			return true;
		} else
			return false;

	}

}
