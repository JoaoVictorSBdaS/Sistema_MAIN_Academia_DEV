package packageConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDatabase {

	
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://:192.168.72.225:51860;encrypt=false;databaseName=AcademiaDEV";
	private final static String user = "sa";
	private final static String password = "Senailab05";
	
	
	public static Connection getConnection() {
	
		try {
			Class.forName(Driver);
			System.out.println("conexão estabelecida!");
			return DriverManager.getConnection(URL, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro de Conexão", e);
		}
	}
	
	
	public static void closeConnection(Connection con) {
		try {if(con != null) {
			con.close();
			System.out.println("conexão fechada!");
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void CloseConnection (Connection con, PreparedStatement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CloseConnection (Connection con, PreparedStatement stmt, ResultSet rs) {
		CloseConnection(con,stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

