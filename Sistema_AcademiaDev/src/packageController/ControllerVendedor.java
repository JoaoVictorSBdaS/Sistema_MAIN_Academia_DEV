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
import packageControler.VendedorDAO;
import packageModel.Vendedor;

public class ControllerVendedor implements Initializable{

    @FXML    private Button BT_ir_vendedor_1;
    @FXML    private Button BT_ir_vendedor_2;
    @FXML    private Button BT_ir_vendedor_3;
    @FXML    private Button BT_ir_vendedor_4;
    @FXML    private Button BT_ir_vendedor_6;

    @FXML    private Button btVoltarVendedor;
    @FXML    private Button bt_escluir;
    @FXML    private Button bt_pesquisar;
    @FXML    private TextField text_pesquisar_vendedor;
    
    @FXML    private Button btEditar;
    @FXML    private Button btcadastra;
    
    @FXML    private TableView<Vendedor> tableVendedor;
    @FXML    private TableColumn<Vendedor, String> ID_Vendedor_table;
    @FXML    private TableColumn<Vendedor, String> CPF_table;
    @FXML    private TableColumn<Vendedor, String> Endereco_table;
    @FXML    private TableColumn<Vendedor, String> data_cont_table;
    @FXML    private TableColumn<Vendedor, String> data_nasc_table;
    @FXML    private TableColumn<Vendedor, String> email_table;
    @FXML    private TableColumn<Vendedor, String> nome_table;
    @FXML    private TableColumn<Vendedor, String> telefone_table;
    @FXML    private TableColumn<Vendedor, String> total_vend_table;
    
    private ObservableList<Vendedor> arrayVendedor;
    private VendedorDAO vendedor = new VendedorDAO();
    
    public static Vendedor VendedorEditar = new Vendedor();
    
    @FXML
    void btEditar_Action(ActionEvent event) throws IOException {
    	if(tableVendedor.getSelectionModel().getSelectedIndex() == -1) {
    		Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
        	mensagemDeErro.setContentText("Selecione um vendedor primeiro!"); 
        	mensagemDeErro.show();
    	} else {
    		int i = tableVendedor.getSelectionModel().getSelectedIndex();
    		VendedorEditar = tableVendedor.getItems().get(i);
    		Main.telaCadastroVend();
    	}
    }
    
    @FXML
    void btcadastra_Action(ActionEvent event) throws IOException{
    	ControllerVendedor.VendedorEditar = null;
    	Main.telaCadastroVend();
    }

    
    @FXML
    void bt_escluir_action(ActionEvent event){    
    	int i = tableVendedor.getSelectionModel().getSelectedIndex();
    	if(i == -1){
    	Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
    	mensagemDeErro.setContentText("Selecione um Vendedor primeiro!"); 
    	mensagemDeErro.show();
    	
    	}else {
    	Vendedor vendedor = new Vendedor();
    	vendedor = tableVendedor.getItems().get(i);
    	Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
    	mensagemDeAviso.setContentText("Deseja realmente excluir o vendedor: " + vendedor.getNome()); 
    	
    	Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

    	if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
    		VendedorDAO c = new VendedorDAO();
    		c.Delete(vendedor.getCPF());
    		
    		Alert mensagemDeExclusao= new Alert(Alert.AlertType.INFORMATION);
    		mensagemDeExclusao.setContentText("vendedor excluido com sucesso!");
    		mensagemDeExclusao.show();
    		CarregarTableVendedor(); 
    		}
    	}
    }

    @FXML
    void bt_pesquisar_action(ActionEvent event) {
    	arrayVendedor = FXCollections.observableArrayList(vendedor.search(text_pesquisar_vendedor.getText()));
		
		ID_Vendedor_table.setCellValueFactory(new PropertyValueFactory<>("ID_vendedor"));		
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CPF_table.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		email_table.setCellValueFactory(new PropertyValueFactory<>("Email"));		
		telefone_table.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		data_nasc_table.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		data_cont_table.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		total_vend_table.setCellValueFactory(new PropertyValueFactory<>("total_vend"));
		Endereco_table.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		
		tableVendedor.setItems(arrayVendedor);
    }

    
    @FXML
    void btVoltarVendedor_action(ActionEvent event) {
    	Main.changerScreem("main");
    }

    @FXML
    void BT_ir_vendedor_1_action(ActionEvent event) {
    	Main.changerScreem("Cliente");
    }

    @FXML
    void BT_ir_vendedor_2_action(ActionEvent event) {
    	Main.changerScreem("Vendedor");
    }

    @FXML
    void BT_ir_vendedor_3_action(ActionEvent event) {
    	Main.changerScreem("Fornecedor");
    }

    @FXML
    void BT_ir_vendedor_4_action(ActionEvent event) {
    	Main.changerScreem("Produto");
    }


    @FXML
    void BT_ir_vendedor_6_action(ActionEvent event) {
    	Main.changerScreem("RelatorioVenda");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableVendedor();
	}
	
	public void CarregarTableVendedor() {
		arrayVendedor = FXCollections.observableArrayList(vendedor.Read());
		
		ID_Vendedor_table.setCellValueFactory(new PropertyValueFactory<>("ID_vendedor"));		
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CPF_table.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		email_table.setCellValueFactory(new PropertyValueFactory<>("Email"));		
		telefone_table.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		data_nasc_table.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		data_cont_table.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		total_vend_table.setCellValueFactory(new PropertyValueFactory<>("total_vend"));
		Endereco_table.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		
		tableVendedor.setItems(arrayVendedor);
	}
    
}