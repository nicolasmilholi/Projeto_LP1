// Autor @Nicolas Milholi
package LP;


import java.util.Scanner;


public class Util {
	
	static Scanner entrada = new Scanner(System.in);
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// LEITURA
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// DE
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// DADOS
	public static int leInt(Scanner entrada) {
		int LeInt = Integer.valueOf(entrada.nextLine());
		return LeInt;
	}

	public static String leString(Scanner entrada) {
		String leString = entrada.nextLine();
		return leString;
	}

	public static Agencia procuraAgencia() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o codigo da ag�ncia");
		int codAgencia = leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);

		} else {
			System.out.println("Agencia n�o encontrada");
			agenciaAux = null;
		}
		return agenciaAux;

	}



public static void auxiliarAgencia() {
	String menuConta = "Digite a op��o desejada:\n" + "\n1 - Cadastrar Agencia" + "\n0 - Retornar ao menu anterior";

	int op1;

	do {
		System.out.println(menuConta);
		op1 = Util.leInt(entrada);
		try {
			switch (op1) {
			
			case 1:
				HandlerAgencia.cadastrarAgencia();

				break;

			case 0:

				break;

			default:
				System.out.println("Op��o invalida!");
				break;
			}

		} catch (Exception e) {
			System.out.println("Ocorreu um erro no processamento: " + e);
		}

	} while (op1 != 0);

}
/*public static void auxiliarCliente() {

	String menuConta = "Digite a op��o desejada:\n" + "\n1 - Cadastrar Agencia" + "\n2 - Cadastrar Gerente"
			+ "\n0 - Retornar ao menu anterior";

	int op1;

	do {
		System.out.println(menuConta);
		op1 = Util.leInt(entrada);
		try {
			switch (op1) {
			case 1:
				HandlerAgencia.cadastrarAgencia();
				System.out.println(Principal.listaAgencia.toString());

				break;

			case 2:
				HandlerGerencia.cadastraGerente();
				break;

			case 0:
				System.out.println("Retorno ao menu anterior.\n");
				break;

			default:
				System.out.println("Op��o invalida!");
				break;
			}

		} catch (Exception e) {
			System.out.println("Ocorreu um erro no processamento: " + e);
		}

	} while (op1 != 0);

}

*/

public static ContaPoupanca consultaContaP(Agencia agenciaAux) {
		
		/////////////
		boolean encontrou = false;
		System.out.println("Digite o codigo da conta que deseja consultar: ");
		int codConta1 = Util.leInt(entrada);
		ContaPoupanca contaAux1 = new ContaPoupanca(codConta1);
		int index1 = agenciaAux.getLstContas().indexOf(contaAux1);

		if (index1 >= 0) {
			contaAux1 = (ContaPoupanca) agenciaAux.getLstContas().get(index1);
			encontrou = true;
		} else {
			System.out.println("Conta n�o encontrada.");
		}
		if (encontrou) {
			return contaAux1;
		} else {
			return null;
		}

	}
public static ContaCorrente consultaContaC(Agencia agenciaAux) {
	boolean encontrou = false;
	System.out.println("Digite o codigo da conta que deseja consultar: ");
	int codConta2 = entrada.nextInt();
	ContaCorrente contaAux2 = new ContaCorrente(codConta2);
	int index2 = agenciaAux.getLstContas().indexOf(contaAux2);

	if (index2 >= 0) {
		contaAux2 = (ContaCorrente) agenciaAux.getLstContas().get(index2);

		encontrou = true;

	} else {
		System.out.println("Conta n�o encontrada.");
	}
	if (encontrou) {
		return contaAux2;
	} else {
		return null;
	}

}
	
	
	
	

	public static double leDouble(Scanner entrada) {
		Double LeDouble = Double.valueOf(entrada.nextLine());
		return LeDouble;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// VETOR
	// preenche o vetor automaticamente
	public static void populaVet(int vet[], int min, int max) {

		for (int i = 0; i < vet.length; i++) {
			vet[i] = Util.geraIntAleatorio(min, max);
		}

		// o usu�rio preenche o vetor
	}

	public static void populaVetNulo(String[] vet) {
		// Popula o vetor com aleat�rios de min a max
		for (int i = 0; i < vet.length; i++) {
			vet[i] = "*";
		}
	}

	public static void populaVetUsuario(int vet[], Scanner entrada) {

		for (int i = 0; i < vet.length; i++) {
			System.out.println("Digite o " + (i + 1) + "� valor");
			vet[i] = Util.leInt(entrada);
		}

	}

	// exibe o vetor no console
	public static void imprimeVet(int vet[]) {
		String saida = "";
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] < 10) {
				saida += "|0" + vet[i];
			} else {
				saida += "|" + vet[i];
			}
		}
		saida += "|";
		System.out.println(saida);
	}

	// exibe o vetor de String
	public static void imprimeVetString(String vet[]) {
		String saida = "";
		for (int i = 0; i < vet.length; i++) {
			saida += "|" + vet[i];
		}
		saida += "|";
		System.out.println(saida);
	}

	// transforma o vetor em ordem crescente
	public static int[] OrdenaVet(int vet[]) {

		for (int i = 0; i < vet.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j] < vet[index])
					index = j;
			}

			int menorValor = vet[index];
			vet[index] = vet[i];
			vet[i] = menorValor;
		}
		return vet;
	}

	// proucura o maior valor no vetor
	public static int maiorValorVet(int vet[]) {
		int maior = vet[0];
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] >= maior) {
				maior = vet[i];
			}
		}
		return maior;

	}

	public static int[] getNumerosRepetidos(int[] vetor) {
		int qtd = 0;
		boolean isRepetido = false, isOnArray = false;
		int[] repetidos = new int[vetor.length];

		for (int i = 0; i < vetor.length; i++) {
			isRepetido = Util.procuraIntRepetido(vetor, vetor[i]);
			isOnArray = Util.intOnVet(repetidos, vetor[i]);

			if (isRepetido && !isOnArray) {
				repetidos[qtd] = vetor[i];
				qtd++;
			}
		}
		return repetidos;

	}

	public static boolean intOnVet(int[] vetor, int numero) {
		int cont = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == numero) {
				cont++;
			}
		}
		if (cont == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean procuraIntRepetido(int[] vetor, int numero) {
		int cont = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == numero) {
				cont++;
			}
		}

		if (cont > 1) {
			return true;
		} else {
			return false;
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// MATRIZ
	public static void populaMatriz(int[][] matriz, int min, int max) {

		// Popula o vetor com aleat�rios de min a max
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = Util.geraIntAleatorio(min, max);
			}

		}
	}

	public static void populaMatrizNulo(String[][] matriz) {
		// Popula o vetor com aleat�rios de min a max
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = "*";
			}
		}
	}

	public static void imprimeMatriz(int[][] matriz) {
		String result = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {

				if (matriz[i][j] < 10) {
					result += "|0" + matriz[i][j];
				} else {
					result += "|" + matriz[i][j];
				}
			}
			result += "|\n";

		}

		System.out.println(result);
	}

	public static void imprimeMatriz(String[][] matriz) {
		String result = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				result += matriz[i][j] + "|";

			}
			result += "\n";

		}
		System.out.println(result);

	}

	public static int procuraMaiorValorMatriz(int matriz[][]) {
		int maior = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] > maior) {
					maior = matriz[i][j];
				}
			}
		}
		return maior;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ENTRADAS
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ALEATORIAS
	public static int geraIntAleatorio(int min, int max) {
		int numAleatorio = min + (int) (Math.random() * ((max - min) + 1));

		return numAleatorio;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// CALCULO
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// VARIADOS
	// calcula a m�dia
	public static double calculaMedia(int A, int B, int C) {
		double media = (double) (A + B + C) / 3;

		return media;

	}

	// calcula o tempo a partir da entrada dos segundos
	public static String calculaHoraMinutosSegundos(int tempo) {
		int minutos = (tempo / 60);
		int horas = minutos / 60;
		int segundos = tempo % 60;
		minutos -= 60;
		String resul = horas + "'" + minutos + "''" + segundos + "'''";
		return resul;
	}

	public static boolean valorLogicoPrimo(int numeroVerificado) {
		boolean primo = true;

		if (numeroVerificado == 0 || numeroVerificado == 1)
			primo = false;

		else {
			for (int i = 2; primo && i < numeroVerificado; i++) {
				if ((numeroVerificado % i) == 0) {
					primo = false;

				}
			}
		}

		return primo;
	}

	/// teste se um numero � perfeito (1+2+3 = 6)
	public static boolean testeNumPerfeito(int numPerfeito) {
		int soma = 0;

		for (int i = 1; i < numPerfeito - 1; i++) {
			if (numPerfeito % i == 0) {
				soma += i;
			}
		}
		if (soma == numPerfeito) {
			return true;
		} else
			return false;
	}

}
