package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
			primaryStage.setTitle("blue pen");
			
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageView/viewLogin.fxml"));
			login = new Scene(fxmlLogin);
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packageView/viewMain.fxml"));
			main = new Scene(fxmlMain);
			
			Parent fxmlCliente = FXMLLoader.load(getClass().getResource("/packageView/ViewCliente.fxml"));
			Cliente = new Scene(fxmlCliente);
			
			Parent fxmlVendedor = FXMLLoader.load(getClass().getResource("/packageView/ViewVendedor.fxml"));
			Vendedor = new Scene(fxmlVendedor);
			
			Parent fxmlFornecedor = FXMLLoader.load(getClass().getResource("/packageView/ViewFornecedor.fxml"));
			Fornecedor = new Scene(fxmlFornecedor);
			
			Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/packageView/ViewProduto.fxml"));
			Produto = new Scene(fxmlProduto);
			
			Parent fxmlRelatorioVenda = FXMLLoader.load(getClass().getResource("/packageView/ViewRelatorioVenda.fxml"));
			RelatorioVenda = new Scene(fxmlRelatorioVenda);
			
			primaryStage.setScene(login);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changerScreem (String tela)
	{
		if(tela.equals("login")){
		Stage.setScene(login);
		Stage.centerOnScreen();
		} else if(tela.equals("main")){
			Stage.setScene(main);
			Stage.centerOnScreen();
		}else if(tela.equals("Cliente")){
			Stage.setScene(Cliente);
			Stage.centerOnScreen();
		}else if(tela.equals("Vendedor")){
			Stage.setScene(Vendedor);
			Stage.centerOnScreen();
		}else if(tela.equals("Fornecedor")){
			Stage.setScene(Fornecedor);
			Stage.centerOnScreen();
		}else if(tela.equals("Produto")){
			Stage.setScene(Produto);
			Stage.centerOnScreen();
		}else if(tela.equals("RelatorioVenda")){
			Stage.setScene(RelatorioVenda);
			Stage.centerOnScreen();
		}
		
	}
	private static Stage cad;	
	
	public static void telaCadastroVend() throws IOException {
		FXMLLoader VendaCadastro = new FXMLLoader();
		VendaCadastro.setLocation(Main.class.getResource("/packageView/ViewRegistrarVenda.fxml"));
		Parent cadastroVenda = VendaCadastro.load();
		Scene scene2 = new Scene(cadastroVenda);
		
		cad = new Stage();
		cad.setTitle("cadastro/Edisão de venda - blue pen");
		cad.initModality(Modality.WINDOW_MODAL);
		cad.setScene(scene2);
		cad.centerOnScreen();
		cad.showAndWait();
	}
	
	public static void telaCadastroCliete() throws IOException {
		FXMLLoader Cliente = new FXMLLoader();
		Cliente.setLocation(Main.class.getResource("/packageView/ViewCadastraCliente.fxml"));
		Parent cliente = Cliente.load();
		Scene scene2 = new Scene(cliente);
		
		cad = new Stage();
		cad.setTitle("cadastro/Edisão de Cliete - blue pen");
		cad.initModality(Modality.WINDOW_MODAL);
		cad.setScene(scene2);
		cad.centerOnScreen();
		cad.showAndWait();
	}
	
	public static void telaCadastroFornecedor() throws IOException {
		FXMLLoader FornecedorCadastro = new FXMLLoader();
		FornecedorCadastro.setLocation(Main.class.getResource("/packageView/ViewCadastraFornecedor.fxml"));
		Parent fornecedorCadastro = FornecedorCadastro.load();
		Scene scene2 = new Scene(fornecedorCadastro);
		
		cad = new Stage();
		cad.setTitle("cadastro/Edisão de fornecedor - blue pen");
		cad.initModality(Modality.WINDOW_MODAL);
		cad.setScene(scene2);
		cad.centerOnScreen();
		cad.showAndWait();
	}
	
	public static void telaCadastroProduto() throws IOException {
		FXMLLoader ProdutoCadastro = new FXMLLoader();
		ProdutoCadastro.setLocation(Main.class.getResource("/packageView/ViewCadastraProduto.fxml"));
		Parent produtoCadastro = ProdutoCadastro.load();
		Scene scene2 = new Scene(produtoCadastro);
		
		cad = new Stage();
		cad.setTitle("cadastro/Edisão de produto - blue pen");
		cad.initModality(Modality.WINDOW_MODAL);
		cad.setScene(scene2);
		cad.centerOnScreen();
		cad.showAndWait();
	}
	
	public static void telaCadastroRV() throws IOException {
		FXMLLoader RVadastro = new FXMLLoader();
		RVadastro.setLocation(Main.class.getResource("/packageView/ViewCadastraVenda.fxml"));
		Parent rVadastro = RVadastro.load();
		Scene scene2 = new Scene(rVadastro);
		
		cad = new Stage();
		cad.setTitle("cadastro/Edisão de produto - blue pen");
		cad.initModality(Modality.WINDOW_MODAL);
		cad.setScene(scene2);
		cad.centerOnScreen();
		cad.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	/*
	try {
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root,400,400);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	} catch(Exception e) {
			e.printStackTrace();
	}
	*/
	/*
	public static void mainC(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
		ArrayList<Cliente> cliente = new ArrayList<>();
		ClienteDAO c = new ClienteDAO();
		
		//c.Delete("15236295241");
		//*
		Cliente cl = new Cliente();
		cl.setNome("joão");
		cl.setCPF_CNPJ("15236295241");
		cl.setEmail("joze do pe@mail");
		cl.setTelefone("12123456789");
		cl.setDataNasc("1990-04-11");
		cl.setDataPriCom("2024-08-21");
		cl.setEndereco("Rua do Tal, numeros");
		cl.setTipoJurid("pf");
		c.Update(cl);
		//c.create(cl);
		
		
		
		cliente = c.Read();
		
		for (int i = 0; i < cliente.size(); i++) {
		Cliente clt = cliente.get(i);
		
		System.out.println();
		System.out.print(clt.getIDCliente() + "| ");
		System.out.print(clt.getNome() + "| ");
		System.out.print(clt.getCPF_CNPJ() + "| ");
		System.out.print(clt.getEmail() + "| ");		
		System.out.print(clt.getTelefone() + "| ");
		System.out.print(clt.getDataNasc() + "| ");
		System.out.print(clt.getDataPriCom() + "| ");
		System.out.print(clt.getEndereco() + "| ");
		System.out.print(clt.getTipoJurid() + "| ");	
		}
				
		launch(args);
	}*/
	/*
	public static void main(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		VendedorDAO c = new VendedorDAO();
		
		//c.Delete("1");
		/*
		Vendedor cl = new Vendedor();
		cl.setNome("joão");
		cl.setCPF("1");
		cl.setEmail("joão@email.com");
		cl.setTelefone("6399236-5070");
		cl.setDataNasc("2000-08-21");
		cl.setDataCont("2024-08-23");
		cl.setTotal_vend("4858.46");
		cl.setEndereco("não te enteressa");
		c.Update(cl);
		//c.create(cl);//*//*
		
		vendedor = c.Read();
		
		for (int i = 0; i < vendedor.size(); i++) {
		Vendedor clt = vendedor.get(i);
		
		System.out.println();
		System.out.print(clt.getID_vendedor() + "| ");
		System.out.print(clt.getNome() + "| ");
		System.out.print(clt.getCPF() + "| ");
		System.out.print(clt.getEmail() + "| ");		
		System.out.print(clt.getTelefone() + "| ");
		System.out.print(clt.getDataNasc() + "| ");
		System.out.print(clt.getDataCont() + "| ");
		System.out.print(clt.getTotal_vend() + "| ");
		System.out.print(clt.getEndereco() + "| ");	
		}
				
		launch(args);
	}
	*/
	/*
	public static void main(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
		ArrayList<fornecedor> Fornecedor = new ArrayList<>();
		FornecedorDAO c = new FornecedorDAO();
		
		//c.Delete("1");
		/*
		fornecedor cl = new fornecedor();
		cl.setNome("não te entereça");
		cl.setCNPJ("1");
		cl.setEmail("não te entereça@email.com");
		cl.setTelefone("1234567890-");
		cl.setTipoJuridi("nt");
		//c.Update(cl);
		//c.create(cl);//*//*
		
		Fornecedor = c.Read();
		
		for (int i = 0; i < Fornecedor.size(); i++) {
		fornecedor clt = Fornecedor.get(i);
		
		System.out.println();
		System.out.print(clt.getID_fornecedor() + "| ");
		System.out.print(clt.getNome() + "| ");
		System.out.print(clt.getCNPJ() + "| ");
		System.out.print(clt.getEmail() + "| ");		
		System.out.print(clt.getTelefone() + "| ");
		System.out.print(clt.getTipoJuridi() + "| ");
		}
				
		launch(args);
	}
	*//*
	public static void main(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
		ArrayList<Produto> produto = new ArrayList<>();
		ProdutoDAO c = new ProdutoDAO();
		
		c.Delete("9");
		/*
		Produto cl = new Produto();
		cl.setNome("te entereça");
		cl.setCodigo("9");
		cl.setEstoque("123");
		cl.setPreco_um("1234");
		cl.setTipo_um("un");
		cl.setData_Fab("1234-12-01");
		cl.setData_Val("1234-12-02");
		
		c.Update(cl);
		//c.create(cl);//*//*
		
		produto = c.Read();
		
		for (int i = 0; i < produto.size(); i++) {
			Produto clt = produto.get(i);
		
		System.out.println();
		System.out.print(clt.getID_produto() + "| ");
		System.out.print(clt.getNome() + "| ");
		System.out.print(clt.getCodigo() + "| ");
		System.out.print(clt.getEstoque() + "| ");		
		System.out.print(clt.getPreco_um() + "| ");
		System.out.print(clt.getTipo_um() + "| ");
		System.out.print(clt.getData_Fab() + "| ");
		System.out.print(clt.getData_Val() + "| ");
		}
				
		launch(args);
	}
	*//*
	public static void main(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
		ArrayList<Compra> compra = new ArrayList<>();
		CompraDAO c = new CompraDAO();
		
		//c.Delete("...");
		
		Compra cl = new Compra();
		cl.setID_Compra("7");
		cl.setID_cliente("2");
		cl.setID_vendedor("2");
		cl.setID_produto("3");
		cl.setQuantidade("1000");
		cl.setPreco_total("38000");
		
		//c.Update(cl);
		//c.create(cl);//*//*
		
		compra = c.Read();
		
		for (int i = 0; i < compra.size(); i++) {
			Compra clt = compra.get(i);
		
		System.out.println();
		System.out.print(clt.getID_Compra() + "| ");
		System.out.print(clt.getID_cliente() + "| ");
		System.out.print(clt.getID_vendedor() + "| ");
		System.out.print(clt.getID_produto() + "| ");		
		System.out.print(clt.getQuantidade() + "| ");
		System.out.print(clt.getPreco_total() + "| ");
		}
				
	}*/

}
