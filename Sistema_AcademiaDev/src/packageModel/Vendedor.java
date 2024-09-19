package packageModel;

public class Vendedor {
	
	private String ID_vendedor;
	private String Nome;
	private String CPF;
	private String Email;
	private String Telefone;
	private String DataNasc;
	private String DataCont;
	private String total_vend;
	private String Endereco;
	private String Password;
	
	public Vendedor() {
		super();
	}

	public Vendedor(String iD_vendedor, String nome, String cPF, String email, String telefone, String dataNasc,
			String dataCont, String total_vend, String endereco , String password) {
		super();
		ID_vendedor = iD_vendedor;
		Nome = nome;
		CPF = cPF;
		Email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataCont = dataCont;
		this.total_vend = total_vend;
		Endereco = endereco;
		Password = password;
	}

	public String getID_vendedor() {
		return ID_vendedor;
	}

	public void setID_vendedor(String iD_vendedor) {
		ID_vendedor = iD_vendedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public String getDataCont() {
		return DataCont;
	}

	public void setDataCont(String dataCont) {
		DataCont = dataCont;
	}

	public String getTotal_vend() {
		return total_vend;
	}

	public void setTotal_vend(String total_vend) {
		this.total_vend = total_vend;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	


	
	
}
