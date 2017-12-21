package sistema.conexao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conexao {
	Connection con;
	private Connection oConn;
	private Statement sStmt;
	
	public Conexao() {
		
	}
	public Connection abrirBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cinema";
			con = (Connection) DriverManager.getConnection(url,"root","3239");
			System.out.println("Conexao efetuada com sucesso");
			return con;
		}
		catch (Exception exc) {
			System.out.println("Erro ao abrir banco de dados");
			exc.printStackTrace();
			return null;
		}
	}
	public void fecharBD() {
		try {
			con.close();
			System.out.println("Conexao finalizada com sucesso");
		}
		catch (Exception exc) {
			System.out.println("Erro ao finalizar conexao"+ exc.getMessage());
		}
	}

}
