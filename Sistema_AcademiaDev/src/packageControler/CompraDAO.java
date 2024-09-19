package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Compra;

public class CompraDAO {
	public void create(Compra c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Compra VALUES(?, ?, ?, ?, ?)");
			stmt.setString(1, c.getID_cliente());
			stmt.setString(2, c.getID_vendedor());
			stmt.setString(3, c.getID_produto());
			stmt.setString(4, c.getQuantidade());
			stmt.setString(5, c.getPreco_total());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Comprar!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public ArrayList<Compra> Read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> Compra = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select ID_Compra, v.nome, cl.nome, p.nome, cp.quantidade, cp.preco_total\r\n"
					+ "from Compra cp inner join Cliente cl on cl.ID_cliente = cp.ID_cliente\r\n"
					+ "inner join produto p on cp.ID_cliente = p.ID_produto\r\n"
					+ "inner join Vendedor v on cp.ID_vendedor = v.ID_vendedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Compra c = new Compra();
				c.setID_Compra(rs.getString(1));
				c.setID_vendedor(rs.getString(2));
				c.setID_cliente(rs.getString(3));
				c.setID_produto(rs.getString(4));
				c.setQuantidade(rs.getString(5));
				c.setPreco_total(rs.getString(6));
				
				Compra.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return Compra;
		
	}
	
	
	public void Update(Compra c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Compra SET ID_cliente = ?, ID_vendedor = ?,"
					+ " ID_produto = ?, quantidade = ?, preco_total = ? WHERE ID_Compra = ?");
			stmt.setString(1, c.getID_cliente());
			stmt.setString(2, c.getID_vendedor());
			stmt.setString(3, c.getID_produto());
			stmt.setString(4, c.getQuantidade());
			stmt.setString(5, c.getPreco_total());
			stmt.setString(6, c.getID_Compra());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao alterar! ID_Compra errado ou inexistente!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public void Delete(String CNPJ) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
			try {
				stmt = con.prepareStatement("DELETE FROM Compra WHERE ID_Compra = ?");
				stmt.setString(1, CNPJ);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao apagar! Compra ja possui registro", e);
			} finally {
				ConnectionDatabase.CloseConnection(con, stmt);
			}
				
	}
}
