package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import packageControler.VendedorDAO;
import packageModel.Vendedor;



public class controllerLogin implements Initializable{

    
	@FXML
    private Button but;
    @FXML
    private TextField textSenha;
    @FXML
    private PasswordField txtpasswuord;
    @FXML
    private TextField txtusuario;
    @FXML
    private ToggleButton verSenha;

    @FXML
    void VisualezarSenha(ActionEvent event) {
    	if(verSenha.isSelected()) {	
    		textSenha.setText(txtpasswuord.getText());
    		txtpasswuord.setVisible(false);
    		textSenha.setVisible(true);
    	}else {
    		txtpasswuord.setText(txtpasswuord.getText());
    		txtpasswuord.setVisible(true);
    		textSenha.setVisible(false);
    	}
    }

    VendedorDAO v = new VendedorDAO();
    public static Vendedor vendedor = new Vendedor();
    
    @FXML
    void btntest(ActionEvent event) {
    	
    	vendedor = v.AutenticUser(txtusuario.getText(), txtpasswuord.getText());
    	
    	if (vendedor.getPassword()!= null && vendedor.getCPF()!= null) {
    		Main.changerScreem("main");
    	}else {
			Alert erro = new Alert(Alert.AlertType.ERROR);
			erro.setTitle("falha ao realizar login!");
			erro.setHeaderText("ERRO");
			erro.setContentText("Usuario ou senha incorreta! verifique as informasoies");
			erro.show();
    	}

    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	if(verSenha.isSelected()) {	
    		textSenha.setText(txtpasswuord.getText());
    		txtpasswuord.setVisible(false);
    		textSenha.setVisible(true);
    	}else {
    		txtpasswuord.setText(txtpasswuord.getText());
    		txtpasswuord.setVisible(true);
    		textSenha.setVisible(false);
    	}
	}
}



