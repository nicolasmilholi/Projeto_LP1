package LP;

public class Funcionario extends Pessoa {
	protected String cargo;

	public Funcionario(String nome, String cpf, String endereco, String cargo) {
		super(nome, cpf, endereco);
		this.cargo = cargo;
	}
	
	public Funcionario(String cpf) {
		super(cpf);
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	

	public String toString() {
		return "Funcionario [cargo=" + cargo + ", nome=" + nome + "]";
	}

}
