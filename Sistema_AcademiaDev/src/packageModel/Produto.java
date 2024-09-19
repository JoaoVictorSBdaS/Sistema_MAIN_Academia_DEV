package packageModel;

public class Produto {

	private String ID_produto;
	private String Nome;
	private String Codigo;
	private String estoque;
	private String preco_um;
	private String tipo_um;
	private String data_Fab;
	private String data_Val;
	
	public Produto() {
		super();
	}
	
	public Produto(String iD_produto, String nome, String codigo, String estoque, String preco_um, String tipo_um,
			String data_Fab, String data_Val) {
		super();
		ID_produto = iD_produto;
		Nome = nome;
		Codigo = codigo;
		this.estoque = estoque;
		this.preco_um = preco_um;
		this.tipo_um = tipo_um;
		this.data_Fab = data_Fab;
		this.data_Val = data_Val;
	}
	public String getID_produto() {
		return ID_produto;
	}
	public void setID_produto(String iD_produto) {
		ID_produto = iD_produto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getEstoque() {
		return estoque;
	}
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
	public String getPreco_um() {
		return preco_um;
	}
	public void setPreco_um(String preco_um) {
		this.preco_um = preco_um;
	}
	public String getTipo_um() {
		return tipo_um;
	}
	public void setTipo_um(String tipo_um) {
		this.tipo_um = tipo_um;
	}
	public String getData_Fab() {
		return data_Fab;
	}
	public void setData_Fab(String data_Fab) {
		this.data_Fab = data_Fab;
	}
	public String getData_Val() {
		return data_Val;
	}
	public void setData_Val(String data_Val) {
		this.data_Val = data_Val;
	}
	
	
}
