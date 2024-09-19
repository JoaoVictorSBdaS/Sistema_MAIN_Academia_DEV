package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControler.ProdutoDAO;
import packageModel.Produto;

public class ControllerCadastraProduto implements Initializable{
	
	@FXML    private TextField textNome;
	@FXML    private TextField TextCodego;
    @FXML    private TextField Textestoque;
    @FXML    private TextField Textpreco;
    @FXML    private TextField textTipo_Un;
    @FXML    private DatePicker datafab;
    @FXML    private DatePicker dataval;
    
    @FXML    private Button btSalvar;
    @FXML    private Button btcancelar;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(ControllerProduto.ProdutoEditar != null) {
			textNome.setText(ControllerProduto.ProdutoEditar.getNome());
			TextCodego.setText(ControllerProduto.ProdutoEditar.getCodigo());
			Textestoque.setText(ControllerProduto.ProdutoEditar.getEstoque());
			Textpreco.setText(ControllerProduto.ProdutoEditar.getPreco_um());
			textTipo_Un.setText(ControllerProduto.ProdutoEditar.getTipo_um());		
		}else {
			ControllerProduto.ProdutoEditar = null;
		}
	}
    
    @FXML
    void btSalvar_action(ActionEvent event) {
    	if(ControllerProduto.ProdutoEditar == null) {
			System.out.println("teste");
			Produto produto = new Produto();
			produto.setNome(textNome.getText());
			produto.setCodigo(TextCodego.getText());
			produto.setEstoque(Textestoque.getText());
			produto.setPreco_um(Textpreco.getText());
			produto.setTipo_um(textTipo_Un.getText());			
			produto.setData_Val(datafab.getValue().toString());
			produto.setData_Fab(dataval.getValue().toString());
			ProdutoDAO pro = new ProdutoDAO();
			pro.create(produto);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			stage.close();
		}else {
			Produto produto = new Produto();
			produto.setNome(textNome.getText());
			produto.setCodigo(TextCodego.getText());
			produto.setEstoque(Textestoque.getText());
			produto.setPreco_um(Textpreco.getText());
			produto.setTipo_um(textTipo_Un.getText());
			produto.setData_Val(datafab.getValue().toString());
			produto.setData_Fab(dataval.getValue().toString());
			ProdutoDAO pro = new ProdutoDAO();
			pro.Update(produto);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			ControllerProduto.ProdutoEditar = null;
			stage.close();
		}
    }

    @FXML
    void btcancelar_action(ActionEvent event) {
    	textNome.setText("");
	    TextCodego.setText("");
	    Textestoque.setText("");
	    Textpreco.setText("");
	    textTipo_Un.setText("");
	    ControllerProduto.ProdutoEditar = null;
	    
	    Stage stage = (Stage) btcancelar.getScene().getWindow();
	    stage.close();
    }
}
