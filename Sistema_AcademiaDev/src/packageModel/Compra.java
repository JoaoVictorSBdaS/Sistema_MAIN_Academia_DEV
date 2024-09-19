package packageModel;

public class Compra {
	private String ID_Compra;
	private String ID_cliente;
	private String ID_vendedor;
	private String ID_produto;
	private String quantidade;
	private String preco_total;
	
	public Compra() {
		super();
	}

	public Compra(String iD_Compra, String iD_cliente, String iD_vendedor, String iD_produto, String quantidade,
			String preco_total) {
		super();
		ID_Compra = iD_Compra;
		ID_cliente = iD_cliente;
		ID_vendedor = iD_vendedor;
		ID_produto = iD_produto;
		this.quantidade = quantidade;
		this.preco_total = preco_total;
	}
	
	public String getID_Compra() {
		return ID_Compra;
	}
	public void setID_Compra(String iD_Compra) {
		ID_Compra = iD_Compra;
	}
	public String getID_cliente() {
		return ID_cliente;
	}
	public void setID_cliente(String iD_cliente) {
		ID_cliente = iD_cliente;
	}
	public String getID_vendedor() {
		return ID_vendedor;
	}
	public void setID_vendedor(String iD_vendedor) {
		ID_vendedor = iD_vendedor;
	}
	public String getID_produto() {
		return ID_produto;
	}
	public void setID_produto(String iD_produto) {
		ID_produto = iD_produto;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco_total() {
		return preco_total;
	}
	public void setPreco_total(String preco_total) {
		this.preco_total = preco_total;
	}
	
	
}
