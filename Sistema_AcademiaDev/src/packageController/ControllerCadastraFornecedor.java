package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControler.FornecedorDAO;
import packageModel.fornecedor;

public class ControllerCadastraFornecedor implements Initializable{
	
	@FXML    private TextField textNome;
	@FXML    private TextField TextCNPJ;
    @FXML    private TextField TextEmail;
    @FXML    private TextField TextTelefone;
    @FXML    private TextField TextTipoJurid;
    
    @FXML    private Button btSalvar;
    @FXML    private Button btcancelar;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(ControllerFornecedor.fornecedorEditar != null) {
			textNome.setText(ControllerFornecedor.fornecedorEditar.getNome());
			TextCNPJ.setText(ControllerFornecedor.fornecedorEditar.getCNPJ());
			TextEmail.setText(ControllerFornecedor.fornecedorEditar.getEmail());
			TextTelefone.setText(ControllerFornecedor.fornecedorEditar.getTelefone());
			TextTipoJurid.setText(ControllerFornecedor.fornecedorEditar.getTipoJuridi());			
		}else {
			ControllerFornecedor.fornecedorEditar = null;
		}
	}
    
    @FXML
    void btSalvar_action(ActionEvent event) {
    	if(ControllerFornecedor.fornecedorEditar == null) {
			System.out.println("teste");
			fornecedor Fornecedor = new fornecedor();
			Fornecedor.setNome(textNome.getText());
			Fornecedor.setCNPJ(TextCNPJ.getText());
			Fornecedor.setEmail(TextEmail.getText());
			Fornecedor.setTelefone(TextTelefone.getText());
			Fornecedor.setTipoJuridi(TextTipoJurid.getText());
			FornecedorDAO fornecedo = new FornecedorDAO();
			fornecedo.create(Fornecedor);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			stage.close();
		}else {
			fornecedor Fornecedor = new fornecedor();
			Fornecedor.setNome(textNome.getText());
			Fornecedor.setCNPJ(TextCNPJ.getText());
			Fornecedor.setEmail(TextEmail.getText());
			Fornecedor.setTelefone(TextTelefone.getText());
			Fornecedor.setTipoJuridi(TextTipoJurid.getText());
			FornecedorDAO fornecedo = new FornecedorDAO();
			fornecedo.Update(Fornecedor);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			ControllerVendedor.VendedorEditar = null;
			stage.close();
		}
    }

    @FXML
    void btcancelar_action(ActionEvent event) {
    	TextCNPJ.setText("");
	    TextEmail.setText("");
	    TextTelefone.setText("");
	    TextTipoJurid.setText("");
	    textNome.setText("");
	    ControllerVendedor.VendedorEditar = null;
	    
	    Stage stage = (Stage) btcancelar.getScene().getWindow();
	    stage.close();
    }

}
