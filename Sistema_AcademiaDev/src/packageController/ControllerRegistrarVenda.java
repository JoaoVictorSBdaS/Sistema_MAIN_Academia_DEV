package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControler.VendedorDAO;
import packageModel.Vendedor;

public class ControllerRegistrarVenda implements Initializable{

	@FXML    private TextField TextCPF;
    @FXML    private TextField TextEmail;
    @FXML    private TextField TextTelefone;
    @FXML    private TextField TextVendido;
    @FXML    private TextField textNome;
    @FXML    private TextField textEndereco;  
    @FXML    private DatePicker dataNaci;
    @FXML    private DatePicker datacont;
    @FXML    private PasswordField senha;
    
    @FXML    private Button btSalvar;
    @FXML    private Button btcancelar;
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(ControllerVendedor.VendedorEditar != null) {
			textNome.setText(ControllerVendedor.VendedorEditar.getNome());
			TextCPF.setText(ControllerVendedor.VendedorEditar.getCPF());
			TextTelefone.setText(ControllerVendedor.VendedorEditar.getTelefone());
			TextVendido.setText(ControllerVendedor.VendedorEditar.getTotal_vend());
			TextEmail.setText(ControllerVendedor.VendedorEditar.getEmail());
			textEndereco.setText(ControllerVendedor.VendedorEditar.getEndereco());			
		}else {
			ControllerVendedor.VendedorEditar = null;
		}
	}
	
	@FXML
    void btSalvar_action(ActionEvent event) {
		if(ControllerVendedor.VendedorEditar == null) {
			System.out.println("teste");
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(textNome.getText());
			vendedor.setCPF(TextCPF.getText());
			vendedor.setEmail(TextEmail.getText());
			vendedor.setTelefone(TextTelefone.getText());
			vendedor.setTotal_vend(TextVendido.getText());
			vendedor.setDataNasc(dataNaci.getValue().toString());
			vendedor.setDataCont(datacont.getValue().toString());
			vendedor.setEndereco(textEndereco.getText());
			vendedor.setPassword(senha.getText());
			VendedorDAO ved = new VendedorDAO();
			ved.create(vendedor);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			stage.close();
		}else {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(textNome.getText());
			vendedor.setCPF(TextCPF.getText());
			vendedor.setEmail(TextEmail.getText());
			vendedor.setTelefone(TextTelefone.getText());
			vendedor.setTotal_vend(TextVendido.getText());
			vendedor.setDataNasc(dataNaci.getValue().toString());
			vendedor.setDataCont(datacont.getValue().toString());
			vendedor.setEndereco(textEndereco.getText());
			vendedor.setPassword(senha.getText());
			VendedorDAO ved = new VendedorDAO();
			ved.Update(vendedor);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			ControllerVendedor.VendedorEditar = null;
			stage.close();
		}
    }
	
	@FXML
    void btcancelar_action(ActionEvent event) {
		TextCPF.setText("");
	    TextEmail.setText("");
	    TextTelefone.setText("");
	    TextVendido.setText("");
	    textNome.setText("");
	    ControllerVendedor.VendedorEditar = null;
	    
	    Stage stage = (Stage) btcancelar.getScene().getWindow();
	    stage.close();
    }

}