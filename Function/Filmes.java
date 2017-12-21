package Functions;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import GUI.ComprarIngressoTela.*;
import GUI.Login_Filmes;
import net.miginfocom.swing.MigLayout;
import sistema.controle.UserControl;

public class Filmes implements ActionListener {
	private String buy_icon = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\buy.png";
	public Filmes() {
		
	}

	private ImageIcon Avatar(String url, int x, int y) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(x,y, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	private ImageIcon Icon(String url) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(15,15, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	private ImageIcon Imagem(String url) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(210, 300, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	public JPanel Atomic_Blonde (int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Atomic.jpg";
		String sinopse_txt = "Lorraine Broughton (Charlize Theron), uma agente disfar�ada do MI6, � enviada para Berlim durante a Guerra Fria para investigar o assassinato de um oficial e recuperar uma lista perdida de agentes duplos. Ao lado de David Percival (James McAvoy), chefe da localidade, a assassina brutal usar� todas as suas habilidades nesse confronto de espi�es.";
		
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("At�mica");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 115 min");
		JLabel genero = new JLabel("G�nero: A��o");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AtomicBlond_Frame novo = new AtomicBlond_Frame("At�mica",id_user);
			}
		});
		
		return painel;
	}
	public JPanel Baby_Driver(int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Baby_Driver.jpg";
		String sinopse_txt = "O jovem Baby (Ansel Elgort) tem uma mania curiosa: precisa ouvir m�sicas o tempo todo para silenciar o zumbido que perturba seus ouvidos desde um acidente na inf�ncia. Excelente motorista, ele � o piloto de fuga oficial dos assaltos de Doc (Kevin Spacey), mas n�o v� a hora de deixar o cargo, principalmente depois que se v� apaixonado pela gar�onete Debora (Lily James).";
		
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("Baby Driver");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 113 min");
		JLabel genero = new JLabel("G�nero: A��o");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BabyDriver_Frame novo = new BabyDriver_Frame("Baby Driver",id_user);
			}
		});
		
		return painel;
	}
	public JPanel Blade_Runner(int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Blade_Runner.jpg";
		String sinopse_txt = "Trinta anos ap�s os eventos do primeiro filme, um novo blade runner, o policial K (Ryan Gosling), do Departamento de Los Angeles, desenterra um segredo que tem o potencial de mergulhar o que sobrou da sociedade em caos. A descoberta de K o leva a uma jornada em busca de Rick Deckard (Ford), um antigo blade runner da LAPD que est� desaparecido h� tr�s d�cadas.";
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("Blade Runner");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 163 min");
		JLabel genero = new JLabel("G�nero: Fic��o Cient�fica");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BladeRunner_Frame novo = new BladeRunner_Frame("Blade Runner",id_user);
			}
		});
		
		return painel;
		
	}
	public JPanel Guardians_Galaxy(int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Galaxy.jpg";
		String sinopse_txt = "Agora j� conhecidos como os Guardi�es da Gal�xia, os guerreiros viajam ao longo do cosmos e lutam para manter sua nova fam�lia unida. Enquanto isso tentam desvendar os mist�rios da verdadeira paternidade de Peter Quill (Chris Pratt).";
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("Guardi�es da Galaxia 2");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 135 min");
		JLabel genero = new JLabel("G�nero: Fic��o Cient�fica");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuardiansGalaxy_Frame novo = new GuardiansGalaxy_Frame("Guardi�es da Galaxia 2",id_user);
			}
		});
		
		return painel;
		}
	public JPanel Kingsman(int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Kingsman.jpg";
		String sinopse_txt = "Kingsman: O C�rculo Dourado, nossos her�is enfrentam um novo deafio. Quando a sua sede � destru�da e o mundo feito ref�m, a jornada os leva � descoberta de uma organiza��o espi� aliada nos EUA chamada Statesman, que data de quando ambas foram fundadas. Em uma nova aventura que testa a for�a dos agentes e a aptid�o aos limites, essas duas organiza��es secretas de elite se unem para derrotar um inimigo em comum, a fim de salvar o mundo algo que est� se tornando um h�bito para Eggsy...";
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("Kingsman 2");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 141 min");
		JLabel genero = new JLabel("G�nero: A��o");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Kingsman_Frame novo = new Kingsman_Frame("Kingsman 2",id_user);
			}
		});
		
		return painel;
		}
	public JPanel Wonder_Woman(int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Wonder_Woman.jpg";
		String sinopse_txt = "Treinada desde cedo para ser uma guerreira imbat�vel, Diana Prince nunca saiu da paradis�aca ilha em que � reconhecida como princesa das Amazonas. Quando o piloto Steve Trevor se acidenta e cai em uma praia do local, ela descobre que uma guerra sem precedentes est� se espalhando pelo mundo e decide deixar seu lar certa de que pode parar o conflito. Lutando para acabar com todas as lutas, Diana percebe o alcance de seus poderes e sua verdadeira miss�o na Terra."; 
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("Mulher Maravilha");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 141 min");
		JLabel genero = new JLabel("G�nero: Fantasia");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WonderWoman_Frame novo = new WonderWoman_Frame("Mulher Maravilha",id_user);
			}
		});
		
		return painel;
		}
	public JPanel Murder(int id_user) {
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Murder.jpg";
		String sinopse_txt = "V�rias pessoas est�o fazendo uma viagem longa em um luxuoso trem, por�m, um terr�vel assassinato acontece. � bordo da composi��o o detetive Hercule Poirot que se voluntaria para iniciar uma varredura no local, ouvindo testemunhas e poss�veis suspeitos para descobrir o que de fato aconteceu.";
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		JLabel titulo = new JLabel("Assassinato no Expresso do Oriente");
		JTextArea sinopse = new JTextArea();
		JLabel ano = new JLabel ("Ano: 2017");
		JLabel tempo = new JLabel("Dura��o: 114 min");
		JLabel genero = new JLabel("G�nero: Drama, Suspense");
		
		ImageIcon buy = Icon(buy_icon);
		JButton comprar = new JButton(buy);
		
		titulo.setFont(new Font("Georgia",0,20));
		ano.setFont(new Font("Georgia",0,16));
		tempo.setFont(new Font("Georgia",0,16));
		genero.setFont(new Font("Georgia",0,16));
		
		sinopse.append(sinopse_txt);
		sinopse.setEditable(false);
		sinopse.setPreferredSize(new Dimension(300,100));
		sinopse.setFont(new Font("Georgia",0,16));
		sinopse.setLineWrap(true);
		sinopse.setWrapStyleWord(true);
		
		ImageIcon wallpaper = Imagem(url);
		JLabel imagem = new JLabel(wallpaper);
		
		
		painel.add(imagem, "dock west");
		painel.add(titulo,"align center");
		painel.add(ano,"gapleft 10");
		painel.add(genero,"gapleft10");
		painel.add(tempo,"gapleft 10");
		painel.add(sinopse, "gapleft 10");
		painel.add(comprar, "cell 2 5");
		
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Murder_Frame novo = new Murder_Frame("Assassinato no Expresso do Oriente",id_user);
			}
		});
		
		return painel;
		}

	public JPanel League_mini() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Soon\\league.jpg";
		
		ImageIcon icon = Avatar(url,50,60);
		JLabel Imagem = new JLabel(icon);
		JLabel Titulo = new JLabel("Liga da Justi�a");
		
		painel.add(Imagem,"dock west");
		painel.add(Titulo,"gapleft 10");
		return painel;
	}
	public JPanel Jumanji_mini() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Soon\\jumanji.jpg";
		
		ImageIcon icon = Avatar(url,50,60);
		JLabel Imagem = new JLabel(icon);
		JLabel Titulo = new JLabel("Jumanji");
		
		painel.add(Imagem,"dock west");
		painel.add(Titulo,"gapleft 10");
		return painel;
	}
	public JPanel Monkey_mini() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Soon\\monkey.jpg";
		
		ImageIcon icon = Avatar(url,50,60);
		JLabel Imagem = new JLabel(icon);
		JLabel Titulo = new JLabel("Planeta dos Macacos: A Guerra");
		
		painel.add(Imagem,"dock west");
		painel.add(Titulo,"gapleft 10");
		return painel;
	}
	public JPanel Jigsaw_mini() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Soon\\jigsaw.jpg";
		
		ImageIcon icon = Avatar(url,50,60);
		JLabel Imagem = new JLabel(icon);
		JLabel Titulo = new JLabel("Jogos Mortais: Jigsaw");
		
		painel.add(Imagem,"dock west");
		painel.add(Titulo,"gapleft 10");
		return painel;
	}
	public JPanel Trainspotting_mini() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("wrap"));
		String url = "C:\\Users\\Eloi C�mara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\Filmes\\Soon\\Trainspotting.jpg";
		
		ImageIcon icon = Avatar(url,50,60);
		JLabel Imagem = new JLabel(icon);
		JLabel Titulo = new JLabel("T2 Trainspotting");
		
		painel.add(Imagem,"dock west");
		painel.add(Titulo,"gapleft 10");
		return painel;
	}

}
