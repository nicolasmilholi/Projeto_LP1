package LP;

import java.util.Scanner;

import LP.Util;

import java.util.Iterator;

public class HandlerAgencia {
	static Scanner entrada = new Scanner(System.in);

	public static void cadastrarAgencia() {

		System.out.println("Digite o nome da ag�ncia: ");
		String nome = Util.leString(entrada);

		Agencia agencia = new Agencia(nome);
		Principal.listaAgencia.add(agencia);

		System.out.println("Agencia cadastrada\n" + agencia.toString() + "\n\n");
	}

	public static String listarAgencia() {
		String saida = "";

		if (Principal.listaAgencia.size() > 0) {
			Iterator<Agencia> iterador = Principal.listaAgencia.iterator(); // para o iterador retornar para o in�cio da
			// lista
			while (iterador.hasNext()) {
				Agencia agencia = (Agencia) iterador.next(); // necessidade de casting
				saida += agencia.toString();
			}
		} else {
			saida += "Sem agencias registradas";
		}

		return saida;

	}

	public static Agencia consultarAgencia() {
		// ta ok
		System.out.println("\nDigite o codigo da ag�ncia: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);

		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			return Principal.listaAgencia.get(index);

		} else {

			return null;
		}
	}

	public static boolean removeAgencia() {

		// ta ok
		Agencia agencia = consultarAgencia();

		if (agencia != null) {
			Principal.listaAgencia.remove(agencia);
			return true;
		} else {
			return false;
		}

	}

	public static void alterarAgencia() {
		// ta ok
		Agencia agencia = consultarAgencia();

		if (agencia != null) {

			boolean sair = false;
			int op;
			String menuAlteraAgencia = "Digite a op��o desejada: " + "1 - Alterar nome da ag�ncia  \n"
					+ "0 - Menu anterior\n";

			try {
				do {
					System.out.println(menuAlteraAgencia);
					op = Util.leInt(entrada);
					switch (op) {
					case 1:
						System.out.println("Digite novo nome da ag�ncia: ");
						String nome = entrada.nextLine();
						agencia.setNome(nome);
						System.out.println("\nNome alterado: " + agencia.toString());
						break;

					case 0:
						sair = true;
						break;

					default:
						System.out.println("Insira uma op��o valida.");
						break;
					}

				} while (!sair);
			} catch (Exception e) {
				System.out.println("ERRO!");
			}

		} else {
			System.out.println("Agencia n�o encontrado!");

		}
	}
}
