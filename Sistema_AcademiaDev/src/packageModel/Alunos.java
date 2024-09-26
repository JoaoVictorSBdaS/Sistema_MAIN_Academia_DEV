package packageModel;

public class Alunos {

	private String aluno_id;
	private String nome;
	private String CPF;
	private String email;
	private String senha;
	private String data_nascimento;
	private String endereco;
	private String telefone;
	private String informacoes_medicas;
	private String data_matricul;
	private String peso;
	private String altura;
	private String credencial;

	public Alunos() {
		super();
	}

	public Alunos(String aluno_id, String nome, String cPF, String email, String senha, String data_nascimento,
			String endereco, String telefone, String informacoes_medicas, String data_matricul, String peso,
			String altura, String credencial) {
		super();
		this.aluno_id = aluno_id;
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		this.senha = senha;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.informacoes_medicas = informacoes_medicas;
		this.data_matricul = data_matricul;
		this.peso = peso;
		this.altura = altura;
		this.credencial = credencial;
	}

	public String getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(String aluno_id) {
		this.aluno_id = aluno_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getInformacoes_medicas() {
		return informacoes_medicas;
	}

	public void setInformacoes_medicas(String informacoes_medicas) {
		this.informacoes_medicas = informacoes_medicas;
	}

	public String getData_matricul() {
		return data_matricul;
	}

	public void setData_matricul(String data_matricul) {
		this.data_matricul = data_matricul;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCredencial() {
		return credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

}
