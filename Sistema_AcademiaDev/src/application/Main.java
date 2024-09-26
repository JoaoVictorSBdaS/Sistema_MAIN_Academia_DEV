package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage Stage;
	private static Scene login;
	private static Scene main;
	private static Scene Cliente;
	private static Scene Vendedor;
	private static Scene Fornecedor;
	private static Scene Produto;
	private static Scene RelatorioVenda;

	@Override
	public void start(Stage primaryStage) {
		try {

			Stage = primaryStage;
			primaryStage.setTitle("Academia DEV");

			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageView/viewLogin.fxml"));
			login = new Scene(fxmlLogin);

			primaryStage.setScene(login);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void changerScreem(String tela) {
		if (tela.equals("login")) {
			Stage.setScene(login);
			Stage.centerOnScreen();
		} else if (tela.equals("main")) {
			Stage.setScene(main);
			Stage.centerOnScreen();
		} else if (tela.equals("Cliente")) {
			Stage.setScene(Cliente);
			Stage.centerOnScreen();
		} else if (tela.equals("Vendedor")) {
			Stage.setScene(Vendedor);
			Stage.centerOnScreen();
		} else if (tela.equals("Fornecedor")) {
			Stage.setScene(Fornecedor);
			Stage.centerOnScreen();
		} else if (tela.equals("Produto")) {
			Stage.setScene(Produto);
			Stage.centerOnScreen();
		} else if (tela.equals("RelatorioVenda")) {
			Stage.setScene(RelatorioVenda);
			Stage.centerOnScreen();
		}

	}

	/*
	 * private static Stage cad; public static void telaCadastroVend() throws
	 * IOException { FXMLLoader VendaCadastro = new FXMLLoader();
	 * VendaCadastro.setLocation(Main.class.getResource(
	 * "/packageView/ViewRegistrarVenda.fxml")); Parent cadastroVenda =
	 * VendaCadastro.load(); Scene scene2 = new Scene(cadastroVenda);
	 * 
	 * cad = new Stage(); cad.setTitle("cadastro/Edisão de venda - blue pen");
	 * cad.initModality(Modality.WINDOW_MODAL); cad.setScene(scene2);
	 * cad.centerOnScreen(); cad.showAndWait(); }
	 */

	public static void main(String[] args) {
		launch(args);
	}

}
