package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Vendedor;

public class VendedorDAO {
	public void create(Vendedor c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Vendedor(nome, CPF, email, telefone, data_nasc, data_cont, total_vend, Endereco, Password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataCont());
			stmt.setString(7, c.getTotal_vend());
			stmt.setString(8, c.getEndereco());
			stmt.setString(9, c.getPassword());
			
			stmt.executeUpdate();
			System.out.println("Vendedor cadastrado!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Vendedor! Vendedor ja registrado!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public ArrayList<Vendedor> Read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> Vendedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Vendedor c = new Vendedor();
				c.setID_vendedor(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataCont(rs.getString(7));
				c.setTotal_vend(rs.getString(8));
				c.setEndereco(rs.getString(9));
				
				Vendedor.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return Vendedor;
		
	}
	
	
	public void Update(Vendedor c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Vendedor SET nome = ?, CPF = ?,"
					+ " email = ?, telefone = ?, data_nasc = ?, data_cont = ?, "
					+ "total_vend = ?, Endereco = ? , Password = ? WHERE CPF = ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataCont());
			stmt.setString(7, c.getTotal_vend());
			stmt.setString(8, c.getEndereco());
			stmt.setString(9, c.getPassword());
			stmt.setString(10, c.getCPF());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao alterar! CPF errado ou inexistente!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public void Delete(String Cpf) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
			try {
				stmt = con.prepareStatement("DELETE FROM Vendedor WHERE CPF = ?");
				stmt.setString(1, Cpf);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao apagar! Vendedor possui registro de compra!", e);
			} finally {
				ConnectionDatabase.CloseConnection(con, stmt);
			}
			
		
	}
	
	public Vendedor AutenticUser (String user, String password) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Vendedor vendedor = new Vendedor();
		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor WHERE Password = ? AND CPF = ?");
			stmt.setString(1, password);
			stmt.setString(2, user);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setID_vendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotal_vend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				v.setPassword(rs.getString(10));
				
				vendedor = v;
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro !", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}
		return vendedor;
		
	}
	
	public ArrayList<Vendedor> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor where nome like ? or CPF like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Vendedor c = new Vendedor();
				c.setID_vendedor(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataCont(rs.getString(7));
				c.setTotal_vend(rs.getString(8));
				c.setEndereco(rs.getString(9));
				c.setPassword(rs.getString(10));
				
				vendedor.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return vendedor;
		
	}
	
}
