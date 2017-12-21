package GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Ajuda extends JFrame{
	private String instrucao = "Fa�a login para ver filmes disponiveis para a compra de ingresso!\n"
			+ "Sess�o -> Nova Sess�o:\t Encerra a sess�o e volta para tela de login.\n"
			+ "Sess�o -> Encerrar Sess�o:\t Finaliza a sess�o e encerra o programa.\n"
			+ "Perfil -> Novo Perfil:\t Cadastro para poder utilizar o programa.";
	
	public Ajuda(String nome) {
		super(nome);
		CriarComponentes();
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void CriarComponentes() {
		JLabel Titulo = new JLabel("Instru��o");
		
		JTextPane texto = new JTextPane();
		texto.setText(instrucao);
		texto.setFont(new Font("Book Antigua",0,16));
		texto.setEditable(false);
		
		JPanel Painel = new JPanel();
		Painel.setLayout(new BorderLayout());
		
		Painel.add(Titulo,BorderLayout.NORTH);
		Painel.add(texto,BorderLayout.CENTER);
		this.add(Painel);
		
	}
	

}
