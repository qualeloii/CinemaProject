package sistema.controle;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import GUI.Assento;
import sistema.conexao.Conexao;

public class KingsmanControl extends Control{
	private float preco = 18.0f;
	
	public void InsereDados(Assento assento) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			String sSQL = "Insert INTO cinema.kingsman Values(null,'"+assento.GetAssento()+"', '"+this.preco+"');";
			boolean res = Stmt.execute(sSQL);
			
			Stmt.close();
			BD.fecharBD();
		}
		catch (Exception exc) {
			JOptionPane.showMessageDialog(null,"OS dados nao puderam ser inseridos");
		}
	}
	public boolean HasComprado(String cadeira) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id, cadeira, valor FROM kingsman");
			while(rs.next()) {
				if (rs.getString(2).equals(cadeira)) {
					return true;
				}
			}
			Stmt.close();
			BD.fecharBD();
			return false;
		}
		catch(Exception exc) {
			return false;
		}
	}
	public void ValidarIngresso(Assento[] Lugares) {
		Conexao BD = new Conexao();
		try {
			Connection ExConn = BD.abrirBD();
			Statement Stmt = (Statement) ExConn.createStatement();
			ResultSet rs = Stmt.executeQuery("Select id, cadeira, valor FROM kingsman");
			while(rs.next()) {
				for (int i=1; i<Lugares.length; i++) {
					if (rs.getString(2).equals(Lugares[i].GetAssento())) {
						Lugares[i].Desabilitar();
						break;
					}
				}
			}
			Stmt.close();
			BD.fecharBD();
		}
		catch(Exception exc) {
			BD.fecharBD();
		}
		
	}
}
