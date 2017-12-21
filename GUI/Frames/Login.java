package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;

import sistema.controle.UserControl;

public class Login extends JFrame implements ActionListener {
	private Ajuda novo;
	private JPanel Painel_Login;
	private JPanel Painel_Senha;
	private JPanel Painel_Completo;
	private JPanel Butao_Enter;
	private JTextField User_Login;
	private JPasswordField User_Senha;
	private JLabel Nome_Login;
	private JPanel Nome;
	private JButton Enter;
	private JMenuBar Menu;
	private JMenu Session;
	private JMenu Perfil;
	private JMenu Ajuda;
	private JMenuItem Encerrar;
	private JMenuItem Novo;
	private JMenuItem Editar;
	private JMenuItem Instr;
	
	
	public Login(String nome) {
		super(nome);
		CriarComponentes();
		CriarMenu();
	}

	private void CriarComponentes() {
		Painel_Login = new JPanel();
		Painel_Senha = new JPanel();
		Painel_Completo = new JPanel();
		Butao_Enter = new JPanel();
		User_Login = new JTextField(20);
		User_Senha = new JPasswordField(20);
		Nome_Login = new JLabel("Login");
		Nome = new JPanel();
		Nome.setLayout(new FlowLayout());
		
		ImageIcon user = IconeUser();
		ImageIcon pass = IconePass();
		ImageIcon enter = IconeEnter();
		JLabel Login = new JLabel(user);
		JLabel Senha = new JLabel(pass);
		Enter = new JButton(enter);
		
		Enter.setMaximumSize(new java.awt.Dimension(10, 10));
		
		
		Painel_Login.add(Login);
		Painel_Login.add(User_Login);
		Painel_Senha.add(Senha);
		Painel_Senha.add(User_Senha);
		Nome.add(Nome_Login);
		Butao_Enter.add(Enter);
		
		Nome_Login.setHorizontalAlignment(SwingConstants.CENTER);
		Enter.setHorizontalAlignment(SwingConstants.CENTER);
		Enter.setVerticalAlignment(SwingConstants.CENTER);
		
		
		Painel_Completo.setLayout(new BorderLayout());
		Painel_Completo.add(Painel_Login,BorderLayout.NORTH);
		Painel_Completo.add(Painel_Senha,BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout(0,15));
		this.add(Painel_Completo,BorderLayout.CENTER);
		this.add(Nome,BorderLayout.NORTH);
		this.add(Enter,BorderLayout.SOUTH);
		
		Enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserControl controle = new UserControl();
				String email = User_Login.getText();
				char[] senha = User_Senha.getPassword();
				if (controle.Login(email, senha) != -1) {
					Login_Filmes novo = new Login_Filmes("Filmes",controle.Login(email, senha));
					novo.setVisible(true);
					Fechar();
				}	
			}
		});
		
	}
	private ImageIcon IconeUser() {
		ImageIcon imageicon = new ImageIcon("C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\user.png");
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;
		
	}
	private ImageIcon IconePass() {
		ImageIcon imageicon = new ImageIcon("C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\password.png");
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;	
	}
	private ImageIcon IconeEnter() {
		ImageIcon imageicon = new ImageIcon("C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\enter.png");
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;	
		
	}
	private void CriarMenu() {
		JMenuBar Menu = new JMenuBar();
		this.setJMenuBar(Menu);
		
		JMenu Session = new JMenu("Sessão");
		JMenu Perfil = new JMenu("Perfil");
		JMenu Ajuda = new JMenu("Ajuda");
		
		JMenuItem Encerrar = new JMenuItem("Encerrar Sessão");
		JMenuItem Novo = new JMenuItem("Nova Sessão");
		JMenuItem Novo_Perfil = new JMenuItem("Novo Perfil");
		JMenuItem Instr = new JMenuItem("Instruções");
		
		Session.add(Novo);
		Session.add(Encerrar);
		Perfil.add(Novo_Perfil);
		Ajuda.add(Instr);
		Session.setEnabled(false);
		
		Menu.add(Session);
		Menu.add(Perfil);
		Menu.add(Ajuda);
		
		Instr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ajuda novo = new Ajuda("Instrução");
				novo.setVisible(true);
			}
		});
		
		Novo_Perfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Cadastro_User novo = new Cadastro_User();
			novo.setVisible(true);
			}
		});
		

	}
	public void Fechar() {
		this.dispose();
	}
}