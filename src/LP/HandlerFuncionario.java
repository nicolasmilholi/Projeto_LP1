package LP;

import java.util.Iterator;
import java.util.Scanner;

public class HandlerFuncionario {
	static Scanner entrada = new Scanner(System.in);

	public static boolean cadastrarFuncionario() {
		boolean inserido = false;

		if (!Principal.listaAgencia.isEmpty()) {

			System.out.println("Digite o CPF do Funcionario: ");
			String cpf = Util.leString(entrada);

			if (!UtilBanco.pesquisaFuncionario(cpf)) {

				System.out.println("Digite o nome: ");
				String nome = Util.leString(entrada);
				System.out.println("Digite o endereço: ");
				String endereco = Util.leString(entrada);
				System.out.println("Digite o cargo: ");
				String cargo = Util.leString(entrada);
				Funcionario funcionario = new Funcionario(nome, cpf, endereco, cargo);

				Principal.listaFuncionario.add(funcionario);
				inserido = true;
			}

		}
		return inserido;
	}

	public static boolean removeFuncionario() {
		// Ainda tem que ver
		boolean removido = false;

		Funcionario funcionario = consultarFuncionario();

		if (funcionario != null) {

			Principal.listaFuncionario.remove(funcionario);
			removido = true;

		} else {
			removido = false;
		}
		return removido;

	}

	public static String listarFuncionario() {
		String saida = "";

		if (Principal.listaFuncionario.size() > 0) {
			Iterator<Funcionario> iterador = Principal.listaFuncionario.iterator(); // para o iterador retornar para o
																					// início da

			while (iterador.hasNext()) {
				Funcionario funcionario = (Funcionario) iterador.next(); // necessidade de casting
				saida += funcionario.toString();
			}
		} else {
			saida += "Sem funcionarios registrados";
		}

		return saida;

	}

	public static Funcionario consultarFuncionario() {
		boolean encontrado = false;

		System.out.println("Digite o CPF do funcionario: ");
		String cpf = Util.leString(entrada);
		Funcionario funcionarioAux = new Funcionario(cpf);
		Iterator<Funcionario> iterador = Principal.listaFuncionario.iterator();
		iterador = Principal.listaFuncionario.iterator(); // para o iterador retornar para o início da lista

		while (iterador.hasNext() && !encontrado) {
			funcionarioAux = iterador.next(); // sem casting
			encontrado = funcionarioAux.getCpf().equals(cpf);
		}

		if (encontrado) {
			return funcionarioAux;
		} else {
			return null;
		}

	}

	public static void alterarFuncionario() {

		Funcionario funcionarioAux = consultarFuncionario();

		if (funcionarioAux != null) {
			boolean sair = false;
			int op;
			String menuAlteraCliente = "Digite a opção desejada: " + "1 - Alterar dados pessoais \n"
					+ "2 - Alterar cargo \n" + "0 - Retornar ao menu anterior\n";
			try {
				do {
					System.out.println(menuAlteraCliente);
					op = entrada.nextInt();
					switch (op) {
					case 1:
						System.out.println("Digite o novo endereço: ");
						String endereco = Util.leString(entrada);
						System.out.println("Digite o novo nome: ");
						String nome = Util.leString(entrada);
						funcionarioAux.setEndereco(endereco);
						funcionarioAux.setNome(nome);
						System.out.println("Dados alterados \n" + funcionarioAux.toString());
						break;
					case 2:
						System.out.println("Digite o novo cargo: ");
						String cargo = Util.leString(entrada);
						funcionarioAux.setCargo(cargo);
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

		} else {
			System.out.println("Cliente não encontrado!");

		}
	}

}
