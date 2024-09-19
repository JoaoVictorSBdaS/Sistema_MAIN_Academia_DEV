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
import packageControler.FornecedorDAO;
import packageModel.fornecedor;

public class ControllerFornecedor implements Initializable{
    
    @FXML    private Button BT_ir_fornecdor_1;
    @FXML    private Button BT_ir_fornecdor_2;
    @FXML    private Button BT_ir_fornecdor_3;
    @FXML    private Button BT_ir_fornecdor_4;
    @FXML    private Button BT_ir_fornecdor_6;

    @FXML    private Button btVoltarFornecedor;
    @FXML    private Button bt_pesquisar;
    @FXML    private TextField text_pesquisar;
    @FXML    private Button bt_escluir;    
    @FXML    private Button btcadastrar;
    @FXML    private Button bteditar;
    
    @FXML    private TableView<fornecedor> tableFornecedor;
    @FXML    private TableColumn<fornecedor, String> CNPJ_table;
    @FXML    private TableColumn<fornecedor, String> ID_fornecedor_table;
    @FXML    private TableColumn<fornecedor, String> email_table;
    @FXML    private TableColumn<fornecedor, String> nome_table;
    @FXML    private TableColumn<fornecedor, String> telefone_table;
    @FXML    private TableColumn<fornecedor, String> tipoJurd_table;

    private ObservableList<fornecedor> arrayfornecedor;
    private FornecedorDAO Fornecedor = new FornecedorDAO();
    public static fornecedor fornecedorEditar = new fornecedor();
    

    @FXML
    void btcadastrar_action(ActionEvent event) throws IOException {
    	ControllerFornecedor.fornecedorEditar = null;
    	Main.telaCadastroFornecedor();
    }

    @FXML
    void bteditar_action(ActionEvent event) throws IOException {
    	if(tableFornecedor.getSelectionModel().getSelectedIndex() == -1) {
    		Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
        	mensagemDeErro.setContentText("Selecione um Fornecedor primeiro!"); 
        	mensagemDeErro.show();
    	} else {
    		int i = tableFornecedor.getSelectionModel().getSelectedIndex();
    		fornecedorEditar = tableFornecedor.getItems().get(i);
    		Main.telaCadastroFornecedor();
    	}
    }
    
    @FXML
    void btVoltarFornecedor_action(ActionEvent event) {
    	Main.changerScreem("main");
    }

    @FXML
    void BT_ir_fornecdor_1_action(ActionEvent event) {
    	Main.changerScreem("Cliente");
    }

    @FXML
    void BT_ir_fornecdor_2_action(ActionEvent event) {
    	Main.changerScreem("Vendedor");
    }

    @FXML
    void BT_ir_fornecdor_3_action(ActionEvent event) {
    	Main.changerScreem("Fornecedor");
    }

    @FXML
    void BT_ir_fornecdor_4_action(ActionEvent event) {
    	Main.changerScreem("Produto");
    }

    @FXML
    void BT_ir_fornecdor_6_action(ActionEvent event) {
    	Main.changerScreem("RelatorioVenda");
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTablefornecedor();
	}
	
	public void CarregarTablefornecedor() {
		arrayfornecedor = FXCollections.observableArrayList(Fornecedor.Read());
		
		ID_fornecedor_table.setCellValueFactory(new PropertyValueFactory<>("ID_fornecedor"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));		
		CNPJ_table.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));		
		email_table.setCellValueFactory(new PropertyValueFactory<>("Email"));
		telefone_table.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		tipoJurd_table.setCellValueFactory(new PropertyValueFactory<>("TipoJuridi"));
		
		tableFornecedor.setItems(arrayfornecedor);
	}
	
	@FXML
    void br_pesquisar_action(ActionEvent event) {

		arrayfornecedor = FXCollections.observableArrayList(Fornecedor.search(text_pesquisar.getText()));
		
		ID_fornecedor_table.setCellValueFactory(new PropertyValueFactory<>("ID_fornecedor"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));		
		CNPJ_table.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));		
		email_table.setCellValueFactory(new PropertyValueFactory<>("Email"));
		telefone_table.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		tipoJurd_table.setCellValueFactory(new PropertyValueFactory<>("TipoJuridi"));
		
		tableFornecedor.setItems(arrayfornecedor);
		tableFornecedor.refresh();
    }

    @FXML
    void bt_escluir_action(ActionEvent event) {
    	int i = tableFornecedor.getSelectionModel().getSelectedIndex();
    	if(i == -1){
    	Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
    	mensagemDeErro.setContentText("Selecione um fornecedor primeiro!"); 
    	mensagemDeErro.show();
    	
    	}else {
    		fornecedor fornecedor = new fornecedor();
    		fornecedor = tableFornecedor.getItems().get(i);
    		Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
    		mensagemDeAviso.setContentText("Deseja realmente excluir o cliente: " + fornecedor.getNome()); 
    	
    	Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

    	if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
    		FornecedorDAO c = new FornecedorDAO();
    		c.Delete(fornecedor.getCNPJ());
    		
    		Alert mensagemDeExclusao= new Alert(Alert.AlertType.INFORMATION);
    		mensagemDeExclusao.setContentText("FornecedorDAO excluido com sucesso!");
    		mensagemDeExclusao.show();
    		CarregarTablefornecedor(); 
    		}
    	}
    }
}
