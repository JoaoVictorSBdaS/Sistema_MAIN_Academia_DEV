package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
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
import packageControler.UsuariosLoginDAO;
import packageModel.Cliente;

public class ControllerUsuarios implements Initializable {

	@FXML
	private Button BTVoltarCliente;

	@FXML
	private Button bt_ir_cliente_1;
	@FXML
	private Button bt_ir_cliente_2;
	@FXML
	private Button bt_ir_cliente_3;
	@FXML
	private Button bt_ir_cliente_4;
	@FXML
	private Button bt_ir_cliente_6;
	@FXML
	private Button bt_Deletar_Cliente;

	@FXML
	private TableView<Cliente> tableCliente;
	@FXML
	private TableColumn<Cliente, String> ID_cliente_table;
	@FXML
	private TableColumn<Cliente, String> CPF_CNPJ_table;
	@FXML
	private TableColumn<Cliente, String> Endereco_table;
	@FXML
	private TableColumn<Cliente, String> dataPrimComp_table;
	@FXML
	private TableColumn<Cliente, String> data_nasc_table;
	@FXML
	private TableColumn<Cliente, String> email_table;
	@FXML
	private TableColumn<Cliente, String> nome_table;
	@FXML
	private TableColumn<Cliente, String> telefone_table;
	@FXML
	private TableColumn<Cliente, String> tipoJurd_table;

	@FXML
	private Button btCadastra;
	@FXML
	private Button btEditar;
	@FXML
	private Button bt_pesquisar_cliente;
	@FXML
	private TextField text_pesquisa_cliente;

	private ObservableList<Cliente> arrayCliente;
	private UsuariosLoginDAO cliente = new UsuariosLoginDAO();
	public static Cliente ClienteEditar = new Cliente();

	@FXML
	void btCadastra_action(ActionEvent event) throws IOException {
		ControllerUsuarios.ClienteEditar = null;
		Main.telaCadastroCliete();
	}

	@FXML
	void btEditar_action(ActionEvent event) throws IOException {
		if (tableCliente.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Cliente primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableCliente.getSelectionModel().getSelectedIndex();
			ClienteEditar = tableCliente.getItems().get(i);
			Main.telaCadastroCliete();
		}
	}

	@FXML
	void bt_pesquisar_cliente_action(ActionEvent event) {
		arrayCliente = FXCollections.observableArrayList(UsuariosLoginDAO.search(text_pesquisa_cliente.getText()));

		ID_cliente_table.setCellValueFactory(new PropertyValueFactory<>("IDCliente"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CPF_CNPJ_table.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		email_table.setCellValueFactory(new PropertyValueFactory<>("Email"));
		telefone_table.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		data_nasc_table.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		Endereco_table.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		Endereco_table.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		tipoJurd_table.setCellValueFactory(new PropertyValueFactory<>("TipoJurid"));

		tableCliente.setItems(arrayCliente);
		tableCliente.refresh();
	}

	@FXML
	void BTVoltarCliente_action(ActionEvent event) {
		Main.changerScreem("main");
	}

	@FXML
	void Deletar_Cliente(ActionEvent event) {
		int i = tableCliente.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro!");
			mensagemDeErro.show();

		} else {
			Cliente cliente = new Cliente();
			cliente = tableCliente.getItems().get(i);
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o cliente: " + cliente.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				UsuariosLoginDAO c = new UsuariosLoginDAO();
				c.Delete(cliente.getCPF_CNPJ());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Cliente excluido com sucesso!");
				mensagemDeExclusao.show();
				CarregarTableCliente();

			}
		}
	}

	@FXML
	void bt_ir_cliente_1_action(ActionEvent event) {
		Main.changerScreem("Cliente");
	}

	@FXML
	void bt_ir_cliente_2_action(ActionEvent event) {
		Main.changerScreem("Vendedor");
	}

	@FXML
	void bt_ir_cliente_3_action(ActionEvent event) {
		Main.changerScreem("Fornecedor");
	}

	@FXML
	void bt_ir_cliente_4_action(ActionEvent event) {
		Main.changerScreem("Produto");
	}

	@FXML
	void bt_ir_cliente_6_action(ActionEvent event) {
		Main.changerScreem("RelatorioVenda");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableCliente();
	}

	public void CarregarTableCliente() {
		arrayCliente = FXCollections.observableArrayList(cliente.Read());

		ID_cliente_table.setCellValueFactory(new PropertyValueFactory<>("IDCliente"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CPF_CNPJ_table.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		email_table.setCellValueFactory(new PropertyValueFactory<>("Email"));
		telefone_table.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		data_nasc_table.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		dataPrimComp_table.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		Endereco_table.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		tipoJurd_table.setCellValueFactory(new PropertyValueFactory<>("TipoJurid"));

		tableCliente.setItems(arrayCliente);
	}

}
