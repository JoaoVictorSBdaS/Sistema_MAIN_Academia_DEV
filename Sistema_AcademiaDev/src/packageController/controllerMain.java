package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controllerMain {

    @FXML
    private Button butVoltar;

    @FXML
    private Button butCliente;

    @FXML
    private Button butVendedor;

    @FXML
    private Button butFornecedor;

    @FXML
    private Button butProduto;

    @FXML
    private Button butRelatorioVenda;

    @FXML
    void butvoltar(ActionEvent event) {
    	Main.changerScreem("login");
    }
    
    @FXML
    void but_Cliente(ActionEvent event) {
    	Main.changerScreem("Cliente");
    }
    
    @FXML
    void VendedoresAction(ActionEvent event) {
    	Main.changerScreem("Vendedor");
    }
    
    @FXML
    void butFornecedor_action(ActionEvent event) {
    	Main.changerScreem("Fornecedor");
    }
    
    @FXML
    void butProduto_action(ActionEvent event) {
    	Main.changerScreem("Produto");
    }
    
    @FXML
    void butRelatorioVenda_action(ActionEvent event) {
    	Main.changerScreem("RelatorioVenda");
    }
}