package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Editar_User extends JFrame implements ActionListener {
	public Editar_User(String nome,int id_user,JLabel perfil) {
		super(nome);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		CriarComponentes(id_user);
		CriarMenu(id_user,perfil);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(325,215);
		this.setVisible(true);
	}

	private void CriarComponentes(int id_user) {
		UserControl novo = new UserControl();
		String nome = novo.GetNome(id_user);
		String apelido = novo.GetApelido(id_user);
		String card = novo.GetNumCard(id_user);
		String email = novo.GetEmail(id_user);
		String url = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\success.png";
		String url2 = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\edit.png";
		
		JButton []edit = new JButton[4];
		edit_button(edit,url2);
		JLabel Nome = new JLabel("Nome:");
		JLabel Apelido = new JLabel("Apelido");
		JLabel Email = new JLabel("Email:");
		JLabel Card = new JLabel("Cartão");
		JTextField nome_texto = new JTextField();
		nome_texto.setText(nome);
		nome_texto.setEditable(false);
		JTextField apelido_texto = new JTextField(30);
		apelido_texto.setText(apelido);
		apelido_texto.setEditable(false);
		JTextField email_texto = new JTextField(50);
		email_texto.setText(email);
		email_texto.setCaretPosition(0);
		email_texto.setEditable(false);
		JTextField card_texto = new JTextField(20);
		card_texto.setText(card);
		card_texto.setEditable(false);

		
		
		ImageIcon save_icon = Avatar(url,15,15);
		JButton save = new JButton(save_icon);
		
		this.setLayout(new MigLayout("wrap 3"));
		this.add(Nome);
		this.add(nome_texto);
		this.add(edit[0]);
		this.add(Apelido);
		this.add(apelido_texto);
		this.add(edit[1]);
		this.add(Email);
		this.add(email_texto);
		this.add(edit[2]);
		if(novo.HasCard(id_user) == -1) {
			this.add(Card);
			this.add(card_texto);
			this.add(edit[3]);
			edit[3].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card_texto.setEditable(true);
					}
			});
		}
		this.add(save,"cell 3 4");
		edit[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nome_texto.setEditable(true);
				}
		});
		edit[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apelido_texto.setEditable(true);
				}
		});
		edit[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				email_texto.setEditable(true);
				}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				novo.Editar(id_user, nome_texto.getText(), apelido_texto.getText());
				novo.EditarEmail(id_user, email_texto.getText());
				JOptionPane.showMessageDialog(null,"OS dados foram atualizados com sucesso!");
				Fechar();
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null,"OS dados nao puderam ser atualizados!");	
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
	private void CriarMenu(int id_user, JLabel label) {
		JMenuBar Menu = new JMenuBar();
		this.setJMenuBar(Menu);
		
		JMenu Editar = new JMenu("Editar");
		JMenuItem Change_pass = new JMenuItem("Alterar Senha");
		JMenuItem Add_card = new JMenuItem("Adicionar Cartao");
		JMenuItem Change_icon = new JMenuItem("Alterar Foto de Perfil");
		
		Editar.add(Change_pass);
		Editar.add(Add_card);
		Editar.add(Change_icon);
		
		Menu.add(Editar);
		
		Change_pass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Editar_Senha novo = new Editar_Senha(id_user,"Editar Senha");
			}
		});
		Add_card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserControl novo = new UserControl();
				System.out.println(novo.HasCard(id_user));
				if(novo.HasCard(id_user) == 1) {
					Editar_Card novoCard = new Editar_Card(id_user,"Cadastrar Cartao");
				}
				else {
					JOptionPane.showMessageDialog(null,"Cartao ja cadastrado!\nMaximo de 1 cartao por pessoa!");
				}
			}
		});
		Change_icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION){
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					label.setIcon(Avatar(path,80,80));		
				}
				
			}
		});
	}
	private void edit_button(JButton[] b,String url) {
		ImageIcon icon = Avatar(url,12,12);
		for (int i=0;i<b.length;i++) {
			b[i] = new JButton(icon);
		}
	}
	private void Fechar() {
		this.dispose();
	}
	
}
