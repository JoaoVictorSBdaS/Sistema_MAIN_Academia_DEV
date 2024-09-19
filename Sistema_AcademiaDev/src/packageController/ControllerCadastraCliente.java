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
import packageControler.ClienteDAO;
import packageModel.Cliente;

public class ControllerCadastraCliente implements Initializable{
	
	@FXML    private TextField textNome;
	@FXML    private TextField TextCPF_CNPJ;
	@FXML    private TextField TextEmail;
	@FXML    private TextField TextTelefone;
	@FXML    private TextField textEndereco;
	@FXML    private TextField TextTipoJurid;
	@FXML    private DatePicker dataNac;
	@FXML    private DatePicker dataCopra;
	
    @FXML    private Button btSalvar;
    @FXML    private Button btcancelar;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(ControllerCliente.ClienteEditar != null) {
			textNome.setText(ControllerCliente.ClienteEditar.getNome());
			TextCPF_CNPJ.setText(ControllerCliente.ClienteEditar.getCPF_CNPJ());
			TextEmail.setText(ControllerCliente.ClienteEditar.getEmail());
			TextTelefone.setText(ControllerCliente.ClienteEditar.getTelefone());
			textEndereco.setText(ControllerCliente.ClienteEditar.getEndereco());
			TextTipoJurid.setText(ControllerCliente.ClienteEditar.getTipoJurid());			
		}else {
			ControllerCliente.ClienteEditar = null;
		}
	}
    
    @FXML
    void btSalvar_action(ActionEvent event) {
    	if(ControllerCliente.ClienteEditar == null) {
			System.out.println("teste");
			Cliente cliente = new Cliente();
			cliente.setNome(textNome.getText());
			cliente.setCPF_CNPJ(TextCPF_CNPJ.getText());
			cliente.setEmail(TextEmail.getText());
			cliente.setTelefone(TextTelefone.getText());
			cliente.setTipoJurid(TextTipoJurid.getText());
			cliente.setDataNasc(dataNac.getValue().toString());
			cliente.setDataPriCom(dataCopra.getValue().toString());
			cliente.setEndereco(textEndereco.getText());
			ClienteDAO Client = new ClienteDAO();
			Client.create(cliente);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			stage.close();
		}else {
			Cliente cliente = new Cliente();
			cliente.setNome(textNome.getText());
			cliente.setCPF_CNPJ(TextCPF_CNPJ.getText());
			cliente.setEmail(TextEmail.getText());
			cliente.setTelefone(TextTelefone.getText());
			cliente.setTipoJurid(TextTipoJurid.getText());
			cliente.setDataNasc(dataNac.getValue().toString());
			cliente.setDataPriCom(dataCopra.getValue().toString());
			cliente.setEndereco(textEndereco.getText());
			ClienteDAO Client = new ClienteDAO();
			Client.Update(cliente);
			Stage stage = (Stage) btcancelar.getScene().getWindow();
			ControllerCliente.ClienteEditar = null;
			stage.close();
		}
    }

    @FXML
    void btcancelar_action(ActionEvent event) {
    	textNome.setText("");
		TextCPF_CNPJ.setText("");
		TextEmail.setText("");
		TextTelefone.setText("");
		textEndereco.setText("");
		TextTipoJurid.setText("");
		ControllerCliente.ClienteEditar = null;	    
		
	    Stage stage = (Stage) btcancelar.getScene().getWindow();
	    stage.close();
    }
}
