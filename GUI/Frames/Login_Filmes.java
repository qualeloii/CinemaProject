package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Functions.Filmes;
import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Login_Filmes extends JFrame implements ActionListener {
	private String buy_icon = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\buy.png";
	Filmes filme = new Filmes();
	
	public Login_Filmes(String nome, int id_user) {
		super(nome);
		Perfil(id_user);
		CriarMenu();
		CriarComponentes(id_user);
		this.setSize(900,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void CriarComponentes(int id_user) {
		JPanel Menu_top = Perfil(id_user);
		JPanel Menu_Filmes = new JPanel();
		JLabel EmBreve = new JLabel("Em Breve");
		
		Menu_Filmes.setLayout(new MigLayout("wrap"));
		Menu_Filmes.add(EmBreve,"dock north, gapleft 55");
		Menu_Filmes.add(filme.League_mini());
		Menu_Filmes.add(filme.Jumanji_mini());
		Menu_Filmes.add(filme.Monkey_mini());
		Menu_Filmes.add(filme.Jigsaw_mini());
		Menu_Filmes.add(filme.Trainspotting_mini());
		
		JPanel Filmes = new JPanel();
		JSeparator[] Barras = new JSeparator[7];
		for (int i=0;i<7;i++) {
			Barras[i] = Barra();
		}
		
		Filmes.setLayout(new MigLayout("wrap"));
		Filmes.add(filme.Atomic_Blonde(id_user));
		Filmes.add(Barras[1]);
		Filmes.add(filme.Baby_Driver(id_user));
		Filmes.add(Barras[2]);
		Filmes.add(filme.Blade_Runner(id_user));
		Filmes.add(Barras[3]);
		Filmes.add(filme.Guardians_Galaxy(id_user));
		Filmes.add(Barras[4]);
		Filmes.add(filme.Kingsman(id_user));
		Filmes.add(Barras[5]);
		Filmes.add(filme.Wonder_Woman(id_user));
		Filmes.add(Barras[6]);
		Filmes.add(filme.Murder(id_user));
		

		
		JScrollPane ScrollFilme = new JScrollPane(Filmes,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ScrollFilme.setPreferredSize(new Dimension(625,800));
		JScrollPane Filmes_Breve = new JScrollPane(Menu_Filmes,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//ScrollFilme.setPreferredSize(new Dimension(80,50));
		
		JSplitPane Menu = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Menu_top,Filmes_Breve);
		Menu.setPreferredSize(new Dimension(275,100));
		
		this.setLayout(new MigLayout());
		this.add(Menu, "east");
		this.add(ScrollFilme, "cell 0 0 4 4");
		
	}
	private ImageIcon Avatar(String url, int x, int y) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(x,y, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	private JSeparator Barra() {
		JSeparator barra = new JSeparator();
		barra.setPreferredSize(new Dimension(600,0));
		return barra;
	}
	private JPanel Perfil(int id_user) {
		UserControl novo = new UserControl();
	
		String url = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\avatar.png";
		String url2 = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\settings.png";
		String url3 = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\pay.png";
		JPanel perfil = new JPanel();
		
		ImageIcon icon = Avatar(url,80,80);
		JLabel icon_perfil = new JLabel(icon);
		String nome =  novo.GetNome(id_user) +"("+novo.GetApelido(id_user)+")";
		JLabel Nome = new JLabel(nome);
		
		
		ImageIcon config_icon = Avatar(url2,10,10);
		JButton config = new JButton(config_icon);
		config.setPreferredSize(new Dimension(5,5));
		
		perfil.setLayout(new MigLayout("wrap"));
		perfil.add(icon_perfil,"align center");
		perfil.add(Nome,"align left");
		perfil.add(config, "cell 2 4");
		
		config.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Editar_User novo = new Editar_User("Editar Dados",id_user,icon_perfil);
			}
		});

		return perfil;
	}
	private void CriarMenu() {
		JMenuBar Menu = new JMenuBar();
		this.setJMenuBar(Menu);
		
		JMenu Session = new JMenu("Sessão");
		
		JMenuItem Encerrar = new JMenuItem("Encerrar Sessão");
		JMenuItem Novo = new JMenuItem("Nova Sessão");
		
		Session.add(Novo);
		Session.add(Encerrar);
		
		Menu.add(Session);

		
		Encerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			EncerrarSessao();
			}
		});
		Novo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			NovaSessao();
			}
		});
		

	}
	private void EncerrarSessao() {
		System.exit(0);
	}
	private void NovaSessao() {
		Login novo = new Login("Login");
		novo.pack();
		novo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		novo.setResizable(false);
		novo.setLocationRelativeTo(null);
		novo.setVisible(true);
		this.dispose();
	}
}
