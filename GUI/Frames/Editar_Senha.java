package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Editar_Senha extends JFrame{
	public Editar_Senha(int id, String nome) {
		super(nome);
		this.setSize(350,150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		CriarComponentes(id);
		this.setVisible(true);
	}

	private void CriarComponentes(int id) {
		String url = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\view.png";
		String url2 = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\success.png";
		JLabel Senha = new JLabel("Senha");
		JPasswordField Senha_texto = new JPasswordField(20);
		JLabel NovaSenha = new JLabel("Nova Senha");
		JPasswordField NovaSenha_texto = new JPasswordField(20);
		JLabel ConfirmaSenha = new JLabel("Confirme a Senha");
		JPasswordField ConfirmaSenha_texto = new JPasswordField(20);
		
		ImageIcon icon = Avatar(url,10,10);
		ImageIcon icon2 = Avatar(url2,10,10);
		JButton view = new JButton(icon);
		JButton confirm = new JButton(icon2);
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NovaSenha_texto.setEchoChar('\u0000');
				}
		});
		this.setLayout(new MigLayout());
		this.add(Senha);
		this.add(Senha_texto,"gapleft 5, wrap");
		this.add(NovaSenha);
		this.add(NovaSenha_texto,"gapleft 5");
		this.add(view,"wrap");
		this.add(ConfirmaSenha);
		this.add(ConfirmaSenha_texto,"gapleft 5, wrap");
		this.add(confirm,"cell 3 3");
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				UserControl novo = new UserControl();
				String senha = String.valueOf(Senha_texto.getPassword());
				if(novo.GetSenha(id).equals(senha)) {
					String s1 = String.valueOf(NovaSenha_texto.getPassword());
					String s2 = String.valueOf(ConfirmaSenha_texto.getPassword());
					System.out.println(s1+"\n"+s2);
					if(s1.equals(s2)) {
						novo.EditarSenha(id, ConfirmaSenha_texto.getPassword());
					}
					else {
						JOptionPane.showMessageDialog(null,"Senhas não combinam!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Senha errada!");
				}
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null,"Senha não pode ser atualizada!");
					System.out.println(exc.getMessage());
				}
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
}
