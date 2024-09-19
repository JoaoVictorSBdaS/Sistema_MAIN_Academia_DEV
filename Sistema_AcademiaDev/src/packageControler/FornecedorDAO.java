package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.fornecedor;

public class FornecedorDAO {
	public void create(fornecedor c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO fornecedor VALUES(?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getTipoJuridi());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Vendedor! Vendedor ja registrado!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public ArrayList<fornecedor> Read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<fornecedor> fornecedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				fornecedor c = new fornecedor();
				c.setID_fornecedor(rs.getString(3));
				c.setNome(rs.getString(2));
				c.setCNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setTipoJuridi(rs.getString(6));
				
				fornecedor.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return fornecedor;
		
	}
	
	
	public void Update(fornecedor c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE fornecedor SET nome = ?, CNPJ = ?,"
					+ " email = ?, telefone = ?, tipoJurd = ? WHERE CNPJ = ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getTipoJuridi());
			stmt.setString(6, c.getCNPJ());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao alterar! CNPJ errado ou inexistente!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public void Delete(String CNPJ) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
			try {
				stmt = con.prepareStatement("DELETE FROM fornecedor WHERE CNPJ = ?");
				stmt.setString(1, CNPJ);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao apagar! fornecedor possui registro de compra!", e);
			} finally {
				ConnectionDatabase.CloseConnection(con, stmt);
			}
				
	}
	
	public ArrayList<fornecedor> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<fornecedor> fornecedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedor where nome like ? or CNPJ like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				fornecedor c = new fornecedor();
				c.setID_fornecedor(rs.getString(3));
				c.setNome(rs.getString(2));
				c.setCNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setTipoJuridi(rs.getString(6));
				
				fornecedor.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return fornecedor;
		
	}
}
