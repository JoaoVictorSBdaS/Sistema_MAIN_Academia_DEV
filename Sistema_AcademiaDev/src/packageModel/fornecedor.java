package packageModel;

public class fornecedor {

	private String ID_fornecedor;
	private String Nome;
	private String CNPJ;
	private String Email;
	private String Telefone;
	private String TipoJuridi;
	
	
	
	public fornecedor() {
		super();
	}

	public fornecedor(String iD_fornecedor, String nome, String cNPJ, String email, String telefone,
			String tipoJuridi) {
		super();
		ID_fornecedor = iD_fornecedor;
		Nome = nome;
		CNPJ = cNPJ;
		Email = email;
		Telefone = telefone;
		TipoJuridi = tipoJuridi;
	}

	public String getID_fornecedor() {
		return ID_fornecedor;
	}

	public void setID_fornecedor(String iD_fornecedor) {
		ID_fornecedor = iD_fornecedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
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

	public String getTipoJuridi() {
		return TipoJuridi;
	}

	public void setTipoJuridi(String tipoJuridi) {
		TipoJuridi = tipoJuridi;
	}
	
	
}
