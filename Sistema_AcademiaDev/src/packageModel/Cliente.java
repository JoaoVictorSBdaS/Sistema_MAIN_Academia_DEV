package packageModel;

public class Cliente {
	
	private String IDCliente;
	private String Nome;
	private String CPF_CNPJ;
	private String Email;
	private String Telefone;
	private String DataNasc;
	private String DataPriCom;
	private String Endereco;
	private String TipoJurid;
	
	public Cliente() {
		super();
	}

	public Cliente(String iDCliente, String nome, String cPF_CNPJ, String email, String telefone, String dataNasc,
			String dataPriCom, String endereco, String tipoJurid) {
		super();
		IDCliente = iDCliente;
		Nome = nome;
		CPF_CNPJ = cPF_CNPJ;
		Email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataPriCom = dataPriCom;
		Endereco = endereco;
		TipoJurid = tipoJurid;
	}
	
	public String getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(String iDCliente) {
		IDCliente = iDCliente;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}

	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}

	public String getDataPriCom() {
		return DataPriCom;
	}

	public void setDataPriCom(String dataPriCom) {
		DataPriCom = dataPriCom;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTipoJurid() {
		return TipoJurid;
	}

	public void setTipoJurid(String tipoJurid) {
		TipoJurid = tipoJurid;
	}
}