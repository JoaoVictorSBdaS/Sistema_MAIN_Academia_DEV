package packageController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import packageControler.UsuariosLoginDAO;
import packageControler.CompraDAO;
import packageControler.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Compra;
import packageModel.Produto;

public class ControllerRealizarVenda implements Initializable {

	@FXML
	private Button btSalvar;
	@FXML
	private Button btcancelar;
	@FXML
	private Button btPesquisar;

	@FXML
	private TextField textNomeCliente;
	@FXML
	private TextField TextCodegoProduto;
	@FXML
	private TextField TextIDVendedor;
	@FXML
	private TextField TextQuntidadeProduto;
	@FXML
	private TextField TextVendedor;
	@FXML
	private TextField Text_precoTotal;
	@FXML
	private TextField tect_Desconto;
	@FXML
	private TextField textCPFVendedor;
	@FXML
	private TextField textCPFCliente;
	@FXML
	private TextField text_PreçoUnitario;
	@FXML
	private TextField text_Pesquisar;

	@FXML
	private TableView<Produto> table_realizarVenda;
	@FXML
	private TableColumn<Produto, String> codego_table;
	@FXML
	private TableColumn<Produto, String> nome_table;
	@FXML
	private TableColumn<Produto, String> peco_unc_table;
	@FXML
	private TableColumn<Produto, String> Quantidade_table;

	private ObservableList<Produto> arrayProduto;
	private ProdutoDAO produto = new ProdutoDAO();
	public static Produto Prod = new Produto();
	ArrayList<Cliente> cliente1 = new ArrayList<>();
	Cliente cliente2 = new Cliente();

	@FXML
	void btPesquisarAction(ActionEvent event) {
		arrayProduto = FXCollections.observableArrayList(ProdutoDAO.search(text_Pesquisar.getText()));

		codego_table.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		peco_unc_table.setCellValueFactory(new PropertyValueFactory<>("preco_um"));
		Quantidade_table.setCellValueFactory(new PropertyValueFactory<>("estoque"));

		table_realizarVenda.setItems(arrayProduto);
		table_realizarVenda.refresh();
	}

	@FXML
	void btSalvar_action(ActionEvent event) {
		if (cliente2 != null && Prod != null && TextIDVendedor != null) {
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso
					.setContentText("Deseja realmente Salvar a venda para o vendedor : " + TextVendedor.getText());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
				mensagemDeExclusao.show();
				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();
				compra.setID_cliente(cliente2.getIDCliente());
				compra.setID_vendedor(TextIDVendedor.getText());
				compra.setID_produto(Prod.getID_produto());
				compra.setQuantidade(TextQuntidadeProduto.getText());
				compra.setPreco_total(Text_precoTotal.getText());
				compraDAO.create(compra);

				textCPFCliente.setText("");
				TextCodegoProduto.setText("");
				textNomeCliente.setText("");
				text_PreçoUnitario.setText("");
				tect_Desconto.setText("");
				Text_precoTotal.setText("");
				TextQuntidadeProduto.setText("");
				textCPFVendedor.setText("");
				text_Pesquisar.setText("");

				cliente2 = null;
			}
		} else {
			Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
			mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
			mensagemDeExclusao.show();
		}
	}

	@FXML
	void btcancelar_action(ActionEvent event) {

		ControllerRelatorioVenda.CompraCadastra = null;

		Stage stage = (Stage) btcancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableProdutoVenda();
		CarregarTableClienteVenda();

		cliente2 = null;
		// Parte do código responsável por carregar de forma automática as informações
		// do vendedor para preencher os campos ID, CPF e Nome
		// do vendedor na tela de Registrar venda, de acordo com o usuário que realizou
		// Login.
		//
		textCPFVendedor.setText(controllerUsuariosLogin.vendedor.getCPF());
		TextVendedor.setText(controllerUsuariosLogin.vendedor.getNome());
		TextIDVendedor.setText(controllerUsuariosLogin.vendedor.getID_vendedor());
		TextQuntidadeProduto.setText("0");

		/**
		 * Método responsável por adicionar automaticamento o nome, código e preço
		 * unitário do produto nos camps da tela Registrar venda Este método será
		 * ativado quando o usuário der 2 CLIQUES em uma linha da tabela. As informações
		 * dessa linha irão prenncher os campos respectivios do produto a ser vendido.
		 */
		table_realizarVenda.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = table_realizarVenda.getSelectionModel().getSelectedIndex();
				Prod = table_realizarVenda.getItems().get(i);
				TextCodegoProduto.setText(Prod.getCodigo());
				text_PreçoUnitario.setText(Prod.getPreco_um());
				text_Pesquisar.setText(Prod.getNome());
			}
		});

		table_ClienteVenda.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = table_ClienteVenda.getSelectionModel().getSelectedIndex();
				cliente11 = table_ClienteVenda.getItems().get(i);
				nome_Cliente.setText(cliente11.getNome());
				codego_CPF.setText(cliente11.getCPF_CNPJ());
			}
		});

	}

	@FXML
	void definirPrecoTotal(KeyEvent event) {
		if (TextQuntidadeProduto.getText() != "" && TextQuntidadeProduto.getText() != null) {

			double quantidade = Double.parseDouble(TextQuntidadeProduto.getText());

			if (quantidade < 30) {
				tect_Desconto.setText("");
				double precoTotal = Double.parseDouble(text_PreçoUnitario.getText())
						* Double.parseDouble(TextQuntidadeProduto.getText());
				Text_precoTotal.setText(Double.toString(precoTotal));

			} else {

				double precoTotal = (Double.parseDouble(text_PreçoUnitario.getText())
						* Double.parseDouble(TextQuntidadeProduto.getText()));
				precoTotal = precoTotal * 0.85;
				Text_precoTotal.setText(Double.toString(precoTotal));
				Double desconto = precoTotal * 0.15;
				tect_Desconto.setText(Double.toString(desconto));

			}
		}
	}

	public void CarregarTableProdutoVenda() {

		arrayProduto = FXCollections.observableArrayList(produto.Read());

		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		codego_table.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		peco_unc_table.setCellValueFactory(new PropertyValueFactory<>("preco_um"));
		Quantidade_table.setCellValueFactory(new PropertyValueFactory<>("estoque"));

		table_realizarVenda.setItems(arrayProduto);
	}

	public void CarregarTableClienteVenda() {
		arrayCliente = FXCollections.observableArrayList(UsuariosLoginDAO.search(text_PesquisarCliente.getText()));

		nome_Cliente.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		codego_CPF.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));

		table_ClienteVenda.setItems(arrayCliente);
		table_ClienteVenda.refresh();
	}

	@FXML
	private TextField text_PesquisarCliente;

	@FXML
	private Button btPesquisarCliente;

	@FXML
	private TableView<Cliente> table_ClienteVenda;
	@FXML
	private TableColumn<Cliente, String> nome_Cliente;
	@FXML
	private TableColumn<Cliente, String> codego_CPF;

	private ObservableList<Cliente> arrayCliente;
	private Cliente cliente11 = new Cliente();

	@FXML
	void btPesquisarClienteAction(ActionEvent event) {
		arrayCliente = FXCollections.observableArrayList(UsuariosLoginDAO.search(text_PesquisarCliente.getText()));

		nome_Cliente.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		codego_CPF.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));

		table_ClienteVenda.setItems(arrayCliente);
		table_ClienteVenda.refresh();
	}

	@FXML
	void definirCliente(KeyEvent evente) {
		if (UsuariosLoginDAO.search(textCPFVendedor.getText()) != null) {
			cliente1 = UsuariosLoginDAO.search(textCPFCliente.getText());
			cliente2 = cliente1.get(0);
			textNomeCliente.setText(cliente2.getNome());
		}
	}
}
