package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Editar_Card extends JFrame {
	
	public Editar_Card(int id_user,String nome) {
		super(nome);
		this.setSize(400,130);
		this.setResizable(false);
		CriarComponentes(id_user);
		this.setVisible(true);
	}

	private void CriarComponentes(int id_user) {
		String url = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\success.png";
		ImageIcon icon = Avatar(url,10,10);
		JButton confirm = new JButton(icon);
		
		JLabel Cartao = new JLabel("Numero Cartao");
		JTextField cardnum = new JTextField(20);
		JLabel Codigo = new JLabel("Codigo de Segurança");
		JTextField security = new JTextField(10);
		
		this.setLayout(new MigLayout("wrap 2"));
		this.add(Cartao);
		this.add(cardnum);
		this.add(Codigo);
		this.add(security);	
		this.add(confirm,"cell 2 3");
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserControl novo = new UserControl();
				novo.EditarCard(id_user, cardnum.getText(), security.getText());
				Fechar();
			}
		});
	}
	private ImageIcon Avatar(String url, int x, int y) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(x,y, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	private void Fechar() {
		this.dispose();
	}
	/////////
}
