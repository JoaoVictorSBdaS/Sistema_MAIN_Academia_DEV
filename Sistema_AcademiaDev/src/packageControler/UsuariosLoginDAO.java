package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Cliente;

public class UsuariosLoginDAO {
	
	public void create(Cliente c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Cliente VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataPriCom());
			stmt.setString(7, c.getEndereco());
			stmt.setString(8, c.getTipoJurid());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Criar! cliente ja registrado!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public ArrayList<Cliente> Read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIDCliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJurid(rs.getString(9));
				
				cliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return cliente;
		
	}
	
	
	public void Update(Cliente c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Cliente SET nome = ?, CPF_CNPJ = ?,"
					+ " email = ?, telefone = ?, data_nasc = ?, dataPrimComp = ?, "
					+ "Endereco = ?, tipoJurd = ? WHERE CPF_CNPJ = ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataPriCom());
			stmt.setString(7, c.getEndereco());
			stmt.setString(8, c.getTipoJurid());
			stmt.setString(9, c.getCPF_CNPJ());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao alterar! CPF_CNPJ errado ou inexistente!", e);
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt);
		}		
	}
	
	public void Delete(String Cpf_Cnpj) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
			try {
				stmt = con.prepareStatement("DELETE FROM Cliente WHERE CPF_CNPJ = ?");
				stmt.setString(1, Cpf_Cnpj);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao apagar! cliente possui registro de compra!", e);
			} finally {
				ConnectionDatabase.CloseConnection(con, stmt);
			}
				
	}
	
	public static ArrayList<Cliente> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente where nome like ? or CPF_CNPJ like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIDCliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJurid(rs.getString(9));
				
				cliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.CloseConnection(con, stmt, rs);
		}	
		return cliente;
		
	}
}
