package sistema.controle;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import GUI.Assento;
import sistema.conexao.Conexao;

public class UserControl {
	public boolean InsereDados(String nome, String apelido, String email, char[] senha2) {
		String senha = String.valueOf(senha2);
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			String sSQL = "Insert INTO cinema.usuario Values(null,'"+nome+"', '"+apelido+"','"+email+"','"+senha+"',null,null);";
			boolean res = Stmt.execute(sSQL);
			
			JOptionPane.showMessageDialog(null,(!res)?"Dados inseridos com sucesso":""+
			"Os dados nao puderam ser inseridos!");
			Stmt.close();
			BD.fecharBD();
			return true;
		}
		catch (Exception exc) {
			BD.fecharBD();
			JOptionPane.showMessageDialog(null,"OS dados nao puderam ser inseridos");
			return false;
		}
	}
	public boolean ExisteUser(String email) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha FROM usuario");
			while(rs.next()) {
				if (rs.getString(4).equals(email)) {
					JOptionPane.showMessageDialog(null,"Email ja cadastrado");
					return true;
				}
			}
			Stmt.close();
			BD.fecharBD();
			return false;
		}
		catch(Exception exc) {
			BD.fecharBD();
			return false;
		}
	}
	public int Login(String email, char[] senha2) {
		String senha = String.valueOf(senha2);
		Conexao BD = new Conexao();
		int id = -1;
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha, num_card FROM usuario");
			
			while(rs.next()) {
				if ((rs.getString(4).equals(email)) && (rs.getString(5).equals(senha))) {
					id = rs.getInt(1);
					break;
				}
			}
			if (id == -1) {
				JOptionPane.showMessageDialog(null,"E-mail ou senha incorretos!");
			}
			Stmt.close();
			BD.fecharBD();
			return id;
		}
		catch(Exception exc) {
			BD.fecharBD();
			return id;
		}
	}
	public String GetNome(int id_user) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha, num_card FROM usuario");
			while (rs.next()) {
				if(rs.getInt(1) == id_user) {
					return rs.getString(2);
				}
			}
			Stmt.close();
			BD.fecharBD();
			String error = "null";
			return error;
		}
		catch (Exception exc) {
			BD.fecharBD();
			String error = "null";
			return error;
		}	
	}
	public String GetApelido(int id_user) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha, num_card FROM usuario");
			while (rs.next()) {
				if(rs.getInt(1) == id_user) {
					return rs.getString(3);
				}
			}
			Stmt.close();
			BD.fecharBD();
			String error = "null";
			return error;
		}
		catch (Exception exc) {
			BD.fecharBD();
			String error = "null";
			return error;
		}	
	}
	public String GetEmail(int id_user) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha FROM usuario");
			while (rs.next()) {
				if(rs.getInt(1) == id_user) {
					return rs.getString(4);
				}
			}
			Stmt.close();
			BD.fecharBD();
			String error = "null";
			return error;
		}
		catch (Exception exc) {
			BD.fecharBD();
			String error = "null";
			return error;
		}	
	}
	public String GetSenha(int id_user) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha, num_card FROM usuario");
			while (rs.next()) {
				if(rs.getInt(1) == id_user) {
					return rs.getString(5);
				}
			}
			Stmt.close();
			BD.fecharBD();
			String error = "null";
			return error;
		}
		catch (Exception exc) {
			BD.fecharBD();
			String error = "null";
			return error;
		}	
	}
	public String GetNumCard(int id_user) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha, num_card FROM usuario");
			while (rs.next()) {
				if(rs.getInt(1) == id_user) {
					return rs.getString(6);
				}
			}
			Stmt.close();
			BD.fecharBD();
			String error = "null";
			return error;
		}
		catch (Exception exc) {
			BD.fecharBD();
			String error = "null";
			return error;
		}	
	}
	public int HasCard(int id_user) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id_user, nome, apelido, email, senha, num_card FROM usuario");
			while (rs.next()) {
				String card = rs.getString(6);
				System.out.println(card);
				if((rs.getInt(1) == id_user) && (card == null)) {
					return 1;
				}
			}
			Stmt.close();
			BD.fecharBD();
			return -1;
		}
		catch (Exception exc) {
			BD.fecharBD();
			return -1;
		}	
		
	}
	public void Editar(int id_user, String nome, String apelido) {
		Conexao BD = new Conexao();
		int res;
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			res = Stmt.executeUpdate("UPDATE cinema.usuario SET nome = '"+nome+"', apelido = '"+apelido+"' WHERE id_user = '"+id_user+"'");
			if (res==1) {
			}
			Stmt.close();
			BD.fecharBD();
		}
		catch (Exception exc) {
			BD.fecharBD();
			System.out.println(exc.getMessage());
		}
	}
	public void EditarEmail(int id_user, String email) {
		Conexao BD = new Conexao();
		int res;
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			res = Stmt.executeUpdate("UPDATE cinema.usuario SET email = '"+email+"' WHERE id_user = '"+id_user+"'");
			if (res==1) {
			}
			Stmt.close();
			BD.fecharBD();
		}
		catch (Exception exc) {
			BD.fecharBD();
			System.out.println(exc.getMessage());
		}
	}
	public void EditarSenha(int id_user, char[] senha2) {
		String senha = String.valueOf(senha2);
		Conexao BD = new Conexao();
		int res;
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			res = Stmt.executeUpdate("UPDATE cinema.usuario SET senha = '"+senha+"' WHERE id_user = '"+id_user+"'");
			if (res==1) {
				JOptionPane.showMessageDialog(null,"Senha atualizada!");
			}
			Stmt.close();
			BD.fecharBD();
		}
		catch (Exception exc) {
			BD.fecharBD();
			JOptionPane.showMessageDialog(null,"Senha não pode ser atualizada!");
			System.out.println(exc.getMessage());
		}
	}
	public void EditarCard(int id_user,String card,String security2) {
		int security = Integer.parseInt(security2);
		Conexao BD = new Conexao();
		int res;
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			res = Stmt.executeUpdate("UPDATE cinema.usuario SET num_card = '"+card+"', confirm_num = '"+security+"' WHERE id_user = '"+id_user+"'");
			if (res==1) {
				JOptionPane.showMessageDialog(null,"Cartão Atualizado!");
			}
			Stmt.close();
			BD.fecharBD();
		}
		catch (Exception exc) {
			BD.fecharBD();
			JOptionPane.showMessageDialog(null,"Cartao nao pode ser atualizado!");
			System.out.println(exc.getMessage());
		}
	}
}
