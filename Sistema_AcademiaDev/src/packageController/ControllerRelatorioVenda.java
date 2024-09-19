package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControler.CompraDAO;
import packageModel.Compra;

public class ControllerRelatorioVenda implements Initializable{

    @FXML    private Button btVoltarRelatorioVenda;
    @FXML    private Button btcadastrar;

    
    @FXML    private Button BT_ir_RelatorioVenda_1;
    @FXML    private Button BT_ir_RelatorioVenda_2;
    @FXML    private Button BT_ir_RelatorioVenda_3;
    @FXML    private Button BT_ir_RelatorioVenda_4;
    @FXML    private Button BT_ir_RelatorioVenda_6;

    @FXML    private TableView<Compra> tableRelatorio;
    @FXML    private TableColumn<Compra, String> ClienteRelatorio_table;
    @FXML    private TableColumn<Compra, String> ID_relatorio_table;
    @FXML    private TableColumn<Compra, String> PrecoTotal_Relatorio_table;
    @FXML    private TableColumn<Compra, String> ProdutoRelatorio_table;
    @FXML    private TableColumn<Compra, String> QuantidadeRelatorio_table;
    @FXML    private TableColumn<Compra, String> vendedorRelatorio_table;
    
    private ObservableList<Compra> arrayCompra;
    private CompraDAO compra = new CompraDAO();
    
    public static Compra CompraCadastra = new Compra();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	CarregarTableProduto();
	}
    
    @FXML
    void btcadastrarActionAction(ActionEvent event) throws IOException{
    	ControllerRelatorioVenda.CompraCadastra = null;
    	Main.telaCadastroRV();
    }
    
    public void CarregarTableProduto() {
    	arrayCompra = FXCollections.observableArrayList(compra.Read());
		
    	ID_relatorio_table.setCellValueFactory(new PropertyValueFactory<>("ID_Compra"));
    	vendedorRelatorio_table.setCellValueFactory(new PropertyValueFactory<>("ID_vendedor"));
    	ClienteRelatorio_table.setCellValueFactory(new PropertyValueFactory<>("ID_cliente"));		
    	ProdutoRelatorio_table.setCellValueFactory(new PropertyValueFactory<>("ID_produto"));		
    	QuantidadeRelatorio_table.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
    	PrecoTotal_Relatorio_table.setCellValueFactory(new PropertyValueFactory<>("Preco_total"));
		
		tableRelatorio.setItems(arrayCompra);
	}
    
    @FXML
    void btVoltarRelatorioVenda_action(ActionEvent event) {
    	Main.changerScreem("main");  
    }
    
    @FXML
    void BT_ir_RelatorioVenda_1_action(ActionEvent event) {
    	Main.changerScreem("Cliente");  
    }

    @FXML
    void BT_ir_RelatorioVenda_2_action(ActionEvent event) {
    	Main.changerScreem("Vendedor");  
    }

    @FXML
    void BT_ir_RelatorioVenda_3_action(ActionEvent event) {
    	Main.changerScreem("Fornecedor");  
    }

    @FXML
    void BT_ir_RelatorioVenda_4_action(ActionEvent event) {
    	Main.changerScreem("Produto");  
    }

    @FXML
    void BT_ir_RelatorioVenda_6_action(ActionEvent event) {
    	Main.changerScreem("RelatorioVenda");  
    }

}