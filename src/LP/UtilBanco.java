package LP;

import java.util.Iterator;
import java.util.Scanner;

public class UtilBanco {

	static Scanner entrada = new Scanner(System.in);

	public static void alteraContaC(ContaCorrente contaAux2) {
		boolean sair = false;
		int op;
		String menuAlteraConta = "Digite a opção desejada: " + "1 - Alterar limite\n" + "0 - Menu anterior\n";

		try {
			do {

				System.out.println(menuAlteraConta);
				op = entrada.nextInt();
				switch (op) {
				case 1:
					System.out.println("Digite novo limite: ");
					double limite = entrada.nextDouble();
					contaAux2.setLimite(limite);
					System.out.println("\nLimite alterado: " + contaAux2.toString());

					break;
				case 0:
					sair = true;
					break;

				default:
					System.out.println("Insira uma opção valida.");
					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}
	}

	public static void alteraContaP(ContaPoupanca contaAuxC) {
		boolean sair = false;
		int op;
		String menuAlteraConta = "Digite a opção desejada: " + "1 - Alterar limite\n" + "0 - Menu anterior\n";

		try {
			do {

				System.out.println(menuAlteraConta);
				op = entrada.nextInt();
				switch (op) {
				case 1:
					System.out.println("Digite novo rendimento: ");
					double rendimento = entrada.nextDouble();
					contaAuxC.setRendimento(rendimento);
					System.out.println("\nRendimento alterado: " + contaAuxC.toString());

					break;
				case 0:
					sair = true;
					break;

				default:
					System.out.println("Insira uma opção valida.");
					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}
	}

	public static void operacoesConta(Conta conta) {

		boolean saida1 = false;
		do {
			System.out.println("Digite a operação que deseja fazer:" + "\n1 - Sacar" + "\n2 - Depositar"
					+ "\n3 - Transferir" + "\n0 - sair");
			int op1 = Util.leInt(entrada);
			switch (op1) {
			case 1:
				/////
				System.out.println("Digite o valor que deseja sacar");
				double valor = Util.leDouble(entrada);

				Operacao operacao = new Saque(conta, valor);

				if (operacao.efetuar())
					
					
					//
					conta.lstOperacoes.add(operacao);
				
				
				
				else {
					System.err.println("Não foi possivel realizar");
				}

				System.out.println("Saldo atual: " + conta.getSaldo());
				//////
				break;
			case 2:

				System.out.println("Digite o valor que deseja depositar");
				double valor2 = Util.leDouble(entrada);

				Operacao operacao2 = new Depositar(valor2);

				if (operacao2.efetuar()) {
					conta.lstOperacoes.add(operacao2);
				} else {
					System.err.println("Não foi possivel realizar");
				}

				System.out.println("Saldo atual: " + conta.getSaldo());

				break;

			case 3:

				try {

					boolean saida2 = false;
					do {
						System.out.println("Deseja transferir para qual tipo de conta:" + "\n1 - Poupança"
								+ "\n2 - Corrente" + "\n0 - sair");
						int op2 = Util.leInt(entrada);
						switch (op2) {
						case 1:
							Agencia agencia1 = HandlerAgencia.consultarAgencia();
							Conta contaAux1 = Util.consultaContaP(agencia1);

							if (contaAux1 != null) {

								System.out.println("Digite o valor que deseja transferir");
								double valor3 = Util.leDouble(entrada);

								Operacao operacao3 = new Transferencia(valor3, conta, contaAux1);

								if (operacao3.efetuar()) {
									conta.lstOperacoes.add(operacao3);
								} else {
									System.err.println("Não foi possivel realizar");
								}

								System.out.println("Valor transferido " + "\n Saldo anterior: "
										+ (conta.getSaldo() + valor3) + "\nSaldo atual: " + conta.getSaldo() + "\n\n");

							} else {
								System.out.println("conta não encontrada");
							}
							break;
						case 2:
							Agencia agencia2 = HandlerAgencia.consultarAgencia();
							Conta contaAux2 = Util.consultaContaC(agencia2);

							if (contaAux2 != null) {

								System.out.println("Digite o valor que deseja transferir");
								double valor4 = Util.leDouble(entrada);

								Operacao operacao4 = new Transferencia(valor4, conta, contaAux2);

								if (operacao4.efetuar()) {
									conta.lstOperacoes.add(operacao4);
								} else {
									System.err.println("Não foi possivel realizar");
								}

								System.out.println("Valor transferido " + "\n Saldo anterior: "
										+ (conta.getSaldo() + valor4) + "\nSaldo atual: " + conta.getSaldo() + "\n\n");
							} else
								System.out.println("Conta não encontrada");
							break;
						case 0:
							saida2 = true;
							break;

						default:
							System.out.println("Opção Inválida");
							break;
						}
					} while (saida2);
				} catch (Exception e) {

				}

				break;
			case 0:
				saida1 = true;
				break;

			default:
				System.out.println("Opção Inválida");
				break;
			}
		} while (saida1);
	}

	public static boolean pesquisaCliente(String cpf) {
		boolean encontrado = false;

		Cliente clienteAux = new Cliente(cpf);
		Iterator<Cliente> iterador = Principal.listaCliente.iterator();
		iterador = Principal.listaCliente.iterator(); // para o iterador retornar para o início da lista

		while (iterador.hasNext() && !encontrado) {
			clienteAux = iterador.next(); // sem casting
			encontrado = clienteAux.getCpf().equals(cpf);
		}

		if (encontrado) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean pesquisaFuncionario(String cpf) {
		boolean encontrado = false;

		Funcionario funcionarioAux = new Funcionario(cpf);
		Iterator<Funcionario> iterador = Principal.listaFuncionario.iterator();
		iterador = Principal.listaFuncionario.iterator(); // para o iterador retornar para o início da lista

		while (iterador.hasNext() && !encontrado) {
			funcionarioAux = iterador.next(); // sem casting
			encontrado = funcionarioAux.getCpf().equals(cpf);
		}

		if (encontrado) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean pesquisaGerente(String cpf) {
		boolean encontrado = false;

		Gerente gerenteAux = new Gerente(cpf);
		Iterator<Gerente> iterador = Principal.listaGerente.iterator();
		iterador = Principal.listaGerente.iterator(); // para o iterador retornar para o início da lista

		while (iterador.hasNext() && !encontrado) {
			gerenteAux = iterador.next(); // sem casting
			encontrado = gerenteAux.getCpf().equals(cpf);
		}

		if (encontrado) {
			return true;
		} else {
			return false;
		}

	}

}
