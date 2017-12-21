package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Recibo extends JFrame {
	
	public Recibo(String nome, int id,float valor) {
		super(nome);
		this.setSize(200,140);
		CriarComponentes(id,valor);
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
	}

	private void CriarComponentes (int id_user, float valor) {
		UserControl novo = new UserControl();
		String nome = novo.GetNome(id_user);
		String email = novo.GetEmail(id_user);
		
		JLabel ID = new JLabel("ID:"+id_user);
		JLabel Nome = new JLabel("Nome:"+nome);
		JLabel Preco = new JLabel("Total:R$"+valor);
		
		this.setLayout(new MigLayout());
		this.setBackground(Color.yellow);
		
		this.add(ID,"wrap, align center ");
		this.add(Nome,"wrap");
		this.add(Preco,"align center");
		
		
	}
	

}
