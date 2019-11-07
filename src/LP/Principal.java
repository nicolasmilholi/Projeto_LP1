package LP;

import java.util.ArrayList;
import java.util.Scanner;

//Projeto Feito por Nicolas Milholi & Jonas Campillay
//desde 5 de Setembro
//Objetivo: Adquirir conhecimento apartir da criação de um sistema Bancario, 
//Onde se utilizara varias ferramentas e metodos de aplicação novos.

public class Principal {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	static ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	static ArrayList<Agencia> listaAgencia = new ArrayList<Agencia>();
	static ArrayList<Gerente> listaGerente = new ArrayList<Gerente>();
	static ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	

	public static void main(String[] args) {
		
		Agencia agencia = new Agencia("teste1");
		Agencia agencia2 = new Agencia("teste2");
		Cliente cliente = new Cliente("Niclas", "123", "Serra");
		Cliente cliente2 = new Cliente("Junior", "456", "Serra");
		Cliente cliente3 = new Cliente("Junior", "789", "Serra");
		Gerente gerente = new Gerente("Nicolas", "357", "Serra");
		
		listaAgencia.add(agencia);
		listaAgencia.add(agencia2);
		listaCliente.add(cliente);
		listaCliente.add(cliente2);
		listaCliente.add(cliente3);
		listaGerente.add(gerente);
		

		String menuPrincipal = "1 - Acessar menu cliente\n" + "2 - Acessar menu conta\n" + "3 - Acessar menu agencia\n"
				+ "4 - Acessar menu gerente\n"+ "5 - Acessar menu funcionario\n" + "6 - Acessar menu dados\n";

		boolean sair = false;
		int op;

		try {
			do {
				System.out.println(menuPrincipal);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					menuCliente();

					break;

				case 2:
					menuConta();

					break;

				case 3:
					menuAgencia();
					break;

				case 4:
					menuGerente();
					break;

				case 5:
					menuFuncionario();
					break;
				case 6:
					menuDados();
					break;
				default:
					System.out.println("Informe ");
					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO Principal!");
		}

	}

	public static void menuCliente() {
		boolean sair = false;
		int op;
		String menuCliente = "1 - Criar Novo Cliente\n" + "2 - Consultar Cliente\n" + "3 - Excluir Cliente\n"
				+ "4 - Alterar dados do cliente\n" + "5 - Listar CLientes\n" + "0 - Menu anterior";

		try {
			do {
				System.out.println(menuCliente);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					 if(HandlerCliente.cadastrarCliente())
					 System.out.println("Cliente cadastrado com sucesso!");
					else
					System.out.println("Cliente não cadastrado.");
					
					break;

				case 2:

					 Cliente clientAux = HandlerCliente.consultarCliente();

					 if (clientAux != null)
					 System.out.println(clientAux.toString());
					else
					System.out.println("Cliente não encontrada");

					break;

				case 3:
					 
					 if(HandlerCliente.removeCliente())
						listaCliente.toString();
					 
					 else
						System.out.println("não removido");
					break;

				case 4:
					HandlerCliente.alterarCliente();
					break;

				case 5:
					 System.out.println(HandlerCliente.listarClientes());
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!" + e);
		}

	}

	public static void menuConta() {

		boolean sair = false;
		int op;
		String menuconta = "1 - Criar Conta\n" + "2 - Excluir Conta\n" + "3 - Consultar Conta\n"
				+ "4 - Alterar Dados de Conta\n" + "5 - Listar Contas\n" + "5 - Entrar na conta\n"+"0 - Menu anterior";

		try {
			do {
				System.out.println(menuconta);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					HandlerConta.cadastraConta();
					break;
				case 2:
					if(HandlerConta.removeConta())
						System.out.println("Conta removida");
					else
						System.out.println("Conta não removida");

					break;

				case 3:
					HandlerConta.consultaConta();
					

					break;

				case 4:
					 HandlerConta.alterarConta();
					break;
				case 5:
					 System.out.println("Lista de contas atualizada: /n" +
							 HandlerConta.listarContas());
					break;
					
				case 6:
					HandlerConta.entrarConta();
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}

	}

	public static void menuAgencia() {
		boolean sair = false;
		int op;
		String menuAgencia = "1 - Criar Nova Agencia\n" + "2 - Consultar Agencia\n" + "3 - Excluir Agencia\n"
				+ "4 - Alterar Dados de Agencia\n" + "5 - Listar Agencias\n" + "0 - Menu anterior";

		try {
			do {
				System.out.println(menuAgencia);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					HandlerAgencia.cadastrarAgencia();
					break;

				case 2:
					Agencia agenciaAux = HandlerAgencia.consultarAgencia();

					if (agenciaAux != null)
						System.out.println(agenciaAux.toString());
					else
						System.out.println("Agencia não encontrada");

					break;

				case 3:

					if (HandlerAgencia.removeAgencia())
						System.out.println(listaAgencia.toString());
					else
						System.out.println("Não foi possivel remover a agência");
					break;

				case 4:
					 HandlerAgencia.alterarAgencia();
					break;

				case 5:
					System.out.println(HandlerAgencia.listarAgencia());
					break;

				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}

	}

	public static void menuGerente() {

		boolean sair = false;
		int op;
		String menuGerente = "1 - Criar Novo Gerente\n" + "2 - Consultar Gerente\n" + "3 - Excluir Gerente\n"
				+ "4 - Alterar dados do gerente\n" + "5 - Listar Gerentes\n" + "6 - Virar mês" + "0 - Menu anterior\n";

		try {
			do {
				System.out.println(menuGerente);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					 HandlerGerente.cadastraGerente();
					break;

				case 2:
					 Gerente gerenteAux = HandlerGerente.consultarGerente();

					 if (gerenteAux != null)
					 System.out.println(gerenteAux.toString());
					 else
					 System.out.println("Gerente não encontrado");
					break;

				case 3:
					 HandlerGerente.removeGerente();
					break;

				case 4:
					 HandlerGerente.alterarGerente();
					break;

				case 5:
					 System.out.println("Lista de gerente atualizada: \n" +
					 HandlerGerente.listarGerente());
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}

	}

	public static void menuFuncionario() {
		boolean sair = false;
		int op;
		String menuCliente = "1 - Criar novo funcionario\n" + "2 - Consultar funcionario\n" + "3 - Excluir funcionario\n"
				+ "4 - Alterar dados do funcionario\n" + "5 - Listar funcionarios\n" + "0 - Menu anterior";

		try {
			do {
				System.out.println(menuCliente);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					 if(HandlerFuncionario.cadastrarFuncionario())
					 System.out.println("Funcionario cadastrado com sucesso!");
					else
					System.out.println("Funcionario não cadastrado.");
					
					break;

				case 2:

					 Funcionario funcionario = HandlerFuncionario.consultarFuncionario();

					 if (funcionario != null)
					 System.out.println(funcionario.toString());
					else
					System.out.println("Funcionario não encontrada");

					break;

				case 3:
					 
					 if(HandlerFuncionario.removeFuncionario())
						listaFuncionario.toString();
					 
					 else
						System.out.println("não removido");
					break;

				case 4:
					HandlerFuncionario.alterarFuncionario();
					break;

				case 5:
					 System.out.println(HandlerFuncionario.listarFuncionario());
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!" + e);
		}

	}
	
	public static void menuDados() {
		boolean sair = false;
		int op;

		String menuDados = " 1 - Carregar dados\n" + "2 - Salvar dados\n" + "0 - sair\n";

		try {
			do {
				System.out.println(menuDados);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:

					break;

				case 2:

					break;

				case 0:
					sair = true;
					break;
				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO pq ele desceu!");
		}

	}

}
