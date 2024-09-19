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
import packageControler.ProdutoDAO;
import packageModel.Produto;

public class ControllerProduto implements Initializable{

    @FXML    private Button btVoltarProduto;
    @FXML    private Button bt_escluir;
    @FXML    private Button bt_pesquisar;
    @FXML    private TextField text_pesquisar;
    @FXML    private Button cadastrar;
    @FXML    private Button editar;

    @FXML    private Button BT_ir_vendedor_1;
    @FXML    private Button BT_ir_vendedor_2;
    @FXML    private Button BT_ir_vendedor_3;
    @FXML    private Button BT_ir_vendedor_4;
    @FXML    private Button BT_ir_vendedor_6;

    @FXML    private TableView<Produto> tableProduto;
    @FXML    private TableColumn<Produto, String> dataVal_table;
    @FXML    private TableColumn<Produto, String> ID_produto_table;
    @FXML    private TableColumn<Produto, String> codigo_table;
    @FXML    private TableColumn<Produto, String> data_Fab_table;
    @FXML    private TableColumn<Produto, String> estoque_table;
    @FXML    private TableColumn<Produto, String> nome_table;
    @FXML    private TableColumn<Produto, String> preco_um_table;
    @FXML    private TableColumn<Produto, String> tipo_um_table;
    
    private ObservableList<Produto> arrayProduto;
    private ProdutoDAO produto = new ProdutoDAO();
    public static Produto ProdutoEditar = new Produto();


    @FXML
    void cadastrar_action(ActionEvent event) throws IOException {
    	ControllerProduto.ProdutoEditar = null;
    	Main.telaCadastroProduto();
    }

    @FXML
    void editar_action(ActionEvent event) throws IOException{
    	if(tableProduto.getSelectionModel().getSelectedIndex() == -1) {
    		Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
        	mensagemDeErro.setContentText("Selecione um vendedor primeiro!"); 
        	mensagemDeErro.show();
    	} else {
    		int i = tableProduto.getSelectionModel().getSelectedIndex();
    		ProdutoEditar = tableProduto.getItems().get(i);
    		Main.telaCadastroProduto();
    	}
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

    @FXML
    void btVoltarProduto_action(ActionEvent event) {
    	Main.changerScreem("main");
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableVendedor();
	}
	
	public void CarregarTableVendedor() {
		arrayProduto = FXCollections.observableArrayList(produto.Read());
		
		ID_produto_table.setCellValueFactory(new PropertyValueFactory<>("ID_produto"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		codigo_table.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		estoque_table.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		preco_um_table.setCellValueFactory(new PropertyValueFactory<>("preco_um"));
		tipo_um_table.setCellValueFactory(new PropertyValueFactory<>("tipo_um"));
		data_Fab_table.setCellValueFactory(new PropertyValueFactory<>("data_Fab"));		
		dataVal_table.setCellValueFactory(new PropertyValueFactory<>("data_Val"));		
		
		tableProduto.setItems(arrayProduto);
	}
	
	@FXML
    void bt_escluir_action(ActionEvent event) {
		int i = tableProduto.getSelectionModel().getSelectedIndex();
    	if(i == -1){
    	Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
    	mensagemDeErro.setContentText("Selecione um produto primeiro!"); 
    	mensagemDeErro.show();
    	
    	}else {
    		Produto produto = new Produto();
    		produto = tableProduto.getItems().get(i);
    		Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
    		mensagemDeAviso.setContentText("Deseja realmente excluir o cliente: " + produto.getNome()); 
    	
    		Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

    		if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
    			ProdutoDAO c = new ProdutoDAO();
    			c.Delete(produto.getCodigo());
    		
    			Alert mensagemDeExclusao= new Alert(Alert.AlertType.INFORMATION);
    			mensagemDeExclusao.setContentText("produto excluido com sucesso!");
    			mensagemDeExclusao.show();
    			CarregarTableVendedor(); 
    		
    		}
    	}
    }

    @FXML
    void bt_pesquisar_action(ActionEvent event) {
    	arrayProduto = FXCollections.observableArrayList(ProdutoDAO.search(text_pesquisar.getText()));
		
		ID_produto_table.setCellValueFactory(new PropertyValueFactory<>("ID_produto"));
		nome_table.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		codigo_table.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		estoque_table.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		preco_um_table.setCellValueFactory(new PropertyValueFactory<>("preco_um"));
		tipo_um_table.setCellValueFactory(new PropertyValueFactory<>("tipo_um"));
		data_Fab_table.setCellValueFactory(new PropertyValueFactory<>("data_Fab"));		
		dataVal_table.setCellValueFactory(new PropertyValueFactory<>("data_Val"));		
		
		tableProduto.setItems(arrayProduto);
    }
}