package GUI;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Cadastro_User extends JDialog implements ActionListener{
	JTextField escrever_nome;
	JTextField escrever_apelido;
	JTextField escrever_email;
	JPasswordField escrever_senha;
	
	public Cadastro_User() {
		this.setResizable(false);
		this.setModal(true);
		this.setSize(380,200);
		this.setLocationRelativeTo(null);
		CriarComponentes();
	}

	private void CriarComponentes() {
		JLabel nome = new JLabel("Nome");
		escrever_nome = new JTextField(20);
		JLabel apelido = new JLabel("Apelido");
		escrever_apelido = new JTextField(20);
		JLabel email = new JLabel("Email");
		escrever_email = new JTextField(20);
		JLabel senha = new JLabel("Senha");
		escrever_senha = new JPasswordField(20);
		
		ImageIcon butao = Confirmar();
		JButton confirmar = new JButton(butao);
		
		JPanel Painel_Nome = new JPanel();
		Painel_Nome.setLayout(new FlowLayout());
		Painel_Nome.add(nome);
		Painel_Nome.add(escrever_nome);
		JPanel Painel_Apelido = new JPanel();
		Painel_Apelido.setLayout(new FlowLayout());
		Painel_Apelido.add(apelido);
		Painel_Apelido.add(escrever_apelido);
		JPanel Painel_Email = new JPanel();
		Painel_Email.setLayout(new FlowLayout());
		Painel_Email.add(email);
		Painel_Email.add(escrever_email);
		JPanel Painel_Senha = new JPanel();
		Painel_Senha.setLayout(new FlowLayout());
		Painel_Senha.add(senha);
		Painel_Senha.add(escrever_senha);
		
		this.setLayout(new MigLayout("wrap"));
		this.add(Painel_Nome);
		this.add(Painel_Apelido);
		this.add(Painel_Email);
		this.add(Painel_Senha);
		this.add(confirmar,"cell 3 3");
		
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CriarUser()) {
					fechar();
				}
				else {
					limpar();
				}
			}
		});
	}
	private ImageIcon Confirmar() {
		ImageIcon imageicon = new ImageIcon("C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\confirmar_cadastro.png");
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;
	}
	private boolean CriarUser() {
		try{
			UserControl novo = new UserControl();
			String nome = escrever_nome.getText();
			String apelido = escrever_apelido.getText();
			String email = escrever_email.getText();
			char[] senha = escrever_senha.getPassword();
			if (!novo.ExisteUser(email)) {
				novo.InsereDados(nome, apelido, email, senha);
				return true;
			}
			return false;
		}
		catch (Exception exc) {
			return false;
		}	
	}
	private void fechar () {
		this.dispose();
	}
	private void limpar() {
		this.escrever_apelido.setText("");
		this.escrever_nome.setText("");
		this.escrever_email.setText("");
		this.escrever_senha.setText("");
		
	}
}