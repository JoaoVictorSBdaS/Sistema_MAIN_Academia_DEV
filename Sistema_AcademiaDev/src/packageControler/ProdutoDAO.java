package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Produto;

public class ProdutoDAO {
	public void create(Produto c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Produto VALUES(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCodigo());
			stmt.setString(3, c.getEstoque());
			stmt.setString(4, c.getPreco_um());
			stmt.setString(5, c.getTipo_um());
			stmt.setString(6, c.getData_Fab());
			stmt.setString(7, c.getData_Val());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Produto!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public ArrayList<Produto> Read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> Produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Produto");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto c = new Produto();
				c.setID_produto(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCodigo(rs.getString(3));
				c.setEstoque(rs.getString(4));
				c.setPreco_um(rs.getString(5));
				c.setTipo_um(rs.getString(6));
				c.setData_Fab(rs.getString(7));
				c.setData_Val(rs.getString(8));
				
				Produto.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return Produto;
		
	}
	
	
	public void Update(Produto c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Produto SET nome = ?, codigo = ?,"
					+ " estoque = ?, preco_um = ?, tipo_um = ?, data_Fab = ?, data_Val = ? WHERE codigo = ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCodigo());
			stmt.setString(3, c.getEstoque());
			stmt.setString(4, c.getPreco_um());
			stmt.setString(5, c.getTipo_um());
			stmt.setString(6, c.getData_Fab());
			stmt.setString(7, c.getData_Val());
			stmt.setString(8, c.getCodigo());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao alterar! Codigo errado ou inexistente!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public void Delete(String CNPJ) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
			try {
				stmt = con.prepareStatement("DELETE FROM Produto WHERE codigo = ?");
				stmt.setString(1, CNPJ);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao apagar! Produto possui registro de compra!", e);
			} finally {
				ConnectionDatabase.CloseConnection(con, stmt);
			}
				
	}
	
	public static ArrayList<Produto> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM produto where nome like ? or Codigo like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto c = new Produto();
				c.setID_produto(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCodigo(rs.getString(3));
				c.setEstoque(rs.getString(4));
				c.setPreco_um(rs.getString(5));
				c.setTipo_um(rs.getString(6));
				c.setData_Fab(rs.getString(7));
				c.setData_Val(rs.getString(8));
				
				produto.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return produto;
		
	}
}
