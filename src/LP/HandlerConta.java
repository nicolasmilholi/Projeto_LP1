package LP;

import java.util.Scanner;

public class HandlerConta {

	static Scanner entrada = new Scanner(System.in);

	public static void consultaConta() {

		Agencia agencia = HandlerAgencia.consultarAgencia();

		if (agencia != null) {
			try {

				boolean saida = false;
				do {
					System.out.println("Consultar Conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:
						Conta contaAux1 = HandlerContaPoupanca.consultaContaP(agencia);

						if (contaAux1 != null) {
							System.out.println(contaAux1.toString());
							

						} else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 2:
						Conta contaAux2 = HandlerContaCorrente.consultaContaC(agencia);

						if (contaAux2 != null) {
							System.out.println(contaAux2.toString());
							

						} else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 0:
						saida = true;
						break;

					default:
						System.out.println("Opção Inválida");
						break;
					}
				} while (saida);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	public static void alterarConta() {

		Agencia agencia = HandlerAgencia.consultarAgencia();

		if (agencia != null) {

			try {

				boolean saida = false;
				do {
					System.out.println("Alterar Conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:
						ContaPoupanca contaAux1 = HandlerContaPoupanca.consultaContaP(agencia);

						if (contaAux1 != null) {
							UtilBanco.alteraContaP(contaAux1);
						} else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 2:
						ContaCorrente contaAux2 = HandlerContaCorrente.consultaContaC(agencia);

						if (contaAux2 != null) {
							UtilBanco.alteraContaC(contaAux2);
						} else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 0:
						saida = true;
						break;

					default:
						System.out.println("Opção Inválida");
						break;
					}
				} while (saida);
			} catch (Exception e) {
			}
		}
	}

	public static boolean removeConta() {
		
		boolean excluiu = false;

		Agencia agencia = HandlerAgencia.consultarAgencia();
		

		if (agencia != null) {

			try {

				boolean saida = false;
				do {
					System.out.println("Remover Conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:
						ContaPoupanca contaAux1 = HandlerContaPoupanca.consultaContaP(agencia);
						

						if (contaAux1 != null) {
							agencia.lstContas.remove(contaAux1);
							excluiu = true;

						} else {
							excluiu = false;
						}

						break;
					case 2:

						ContaCorrente contaAux2 = HandlerContaCorrente.consultaContaC(agencia);

						if (contaAux2 != null) {
							agencia.lstContas.remove(contaAux2);
							excluiu = true;

						} else {
							excluiu = false;
						}

						break;
					case 0:
						saida = true;
						break;

					default:
						System.out.println("Opção Inválida");
						break;
					}
				} while (saida);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("Agencia não encontrada!");
			return false;
		}
		return excluiu;

	}

	public static String listarContas() {
		String saida = "";

		Agencia agencia = HandlerAgencia.consultarAgencia();

		if (agencia != null) {
			saida += agencia.lstContas.toString();

		} else {
			saida += "Agencia não encontrada!";
		}

		return saida;
	}

	public static void cadastraConta() {
		boolean trava = false;
		do {

			System.out.println("1 - Criar Conta Poupança\n" + "2 - Criar Conta Corrente\n" + "0 - Voltar");
			int op1 = Util.leInt(entrada);
			switch (op1) {
			case 1:
				HandlerContaPoupanca.criarContaPoupanca();
				break;
			case 2:
				HandlerContaCorrente.criarContaCorrente();

				break;
			case 0:
				trava = true;
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			break;
		} while (trava);
		
	}

	public static void entrarConta() {
		Agencia agenciaAux = HandlerAgencia.consultarAgencia();

		if (agenciaAux != null) {
			try {

				boolean saida = false;
				do {
					System.out.println("Entrar na conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:
						Conta contaAux1 = Util.consultaContaP(agenciaAux);

						if (contaAux1 != null) {
							UtilBanco.operacoesConta(contaAux1);

						} else {
							System.out.println("conta não encontrada");
						}
						break;
					case 2:
						Conta contaAux2 = Util.consultaContaC(agenciaAux);

						if (contaAux2 != null)
							UtilBanco.operacoesConta(contaAux2);

						else
							System.out.println("Conta não encontrada");
						break;
					case 0:
						saida = true;
						break;

					default:
						System.out.println("Opção Inválida");
						break;
					}
				} while (saida);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}




