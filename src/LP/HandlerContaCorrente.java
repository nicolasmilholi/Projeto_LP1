package LP;

import java.util.Scanner;

import LP.Util;

public class HandlerContaCorrente extends HandlerConta {
	static Scanner entrada = new Scanner(System.in);

	public static void criarContaCorrente() {

		if (!Principal.listaCliente.isEmpty()) {

			Cliente cliente = HandlerCliente.consultarCliente();
			Agencia agencia = HandlerAgencia.consultarAgencia();

			if (cliente != null && agencia != null) {
				System.out.println("Informe o limite do cliente");
				double limite = Util.leDouble(entrada);
				System.out.println("Informe o saldo do cliente");
				double saldo = Util.leDouble(entrada);

				ContaCorrente contaAux = new ContaCorrente(saldo, limite, cliente);

				agencia.inserirConta(contaAux);
				System.out.println("Conta Criada\n");

			}
		}
	}

	public static ContaCorrente consultaContaC(Agencia agencia) {
		
		
		System.out.println("Digite o codigo da conta");
		int cod = Util.leInt(entrada);
		ContaCorrente conta = new ContaCorrente(cod);

		if (agencia != null) {
			int index = agencia.lstContas.indexOf(conta);

		if(index >-1)
			conta = (ContaCorrente) agencia.lstContas.get(index);
		}
		
		if(conta!=null)
		return conta;
		else
		return null;
	}


	}

