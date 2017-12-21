package GUI.ComprarIngressoTela;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import GUI.Assento;
import net.miginfocom.swing.MigLayout;
import sistema.controle.WonderWomanControl;

public class WonderWoman_Frame extends JFrame {
	private Assento[] Lugares = new Assento[50];
	private WonderWomanControl c = new WonderWomanControl();
	
	public WonderWoman_Frame(String nome, int id_user) {
		super(nome);
		CriarLugares_A(Lugares,id_user);
		CriarLugares_B(Lugares,id_user);
		CriarLugares_C(Lugares,id_user);
		CriarLugares_D(Lugares,id_user);
		CriarLugares_E(Lugares,id_user);
		this.setSize(520,370);
		CriarComponentes();
		this.setVisible(true);
	}
	private ImageIcon Avatar(String url, int x, int y) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(x,y, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	private void CriarComponentes() {
		JPanel Tela = Tela();
		
		this.setLayout(new MigLayout());
		this.add(Tela,"dock north");
		this.add(Lugares[1]);
		for(int i=2; i<=48;i++) {
			if (i==8) {
				this.add(Lugares[i],"wrap");
			}
			else if (i==9) {
				this.add(Lugares[i],"align right");
			}
			else if (i==18) {
				this.add(Lugares[i],"wrap");
			}
			else if (i==19) {
				this.add(Lugares[i],"align right");
			}
			else if (i==28) {
				this.add(Lugares[i],"wrap");
			}
			else if (i==29) {
				this.add(Lugares[i],"align right");
			}
			else if (i==38) {
				this.add(Lugares[i],"wrap");
			}
			else if (i==39) {
				this.add(Lugares[i],"align right");
			}
			else if (i==48) {
				this.add(Lugares[i],"wrap");
			}
			else {
				this.add(Lugares[i]);
			}
			ValidarIngressos(Lugares);
		}
	}
	private void CriarLugares_A(Assento[] lugar,int id_user) { // 8 lugares A(1-8)
		String Fileira = "A-";
		for(int i=1; i<=8;i++) {
			String aux = Fileira;
			aux = aux + i;
			lugar[i] = new Assento(id_user,c);
			lugar[i].SetLugar(aux);
		}
	}
	private void CriarLugares_B(Assento[] lugar, int id_user) { // 10 lugares B(9-18)
		String Fileira = "B-";
		for(int i=9; i<=18;i++) {
			String aux = Fileira;
			aux = aux + i;
			lugar[i] = new Assento(id_user,c);
			lugar[i].SetLugar(aux);
		}
	}
	private void CriarLugares_C(Assento[] lugar, int id_user) { // 10 lugares C(19-28)
		String Fileira = "C-";
		for(int i=19; i<=28;i++) {
			String aux = Fileira;
			aux = aux + i;
			lugar[i] = new Assento(id_user,c);
			lugar[i].SetLugar(aux);
		}
	}
	private void CriarLugares_D(Assento[] lugar, int id_user) { // 10 lugares D(29-38)
		String Fileira = "D-";
		for(int i=29; i<=38;i++) {
			String aux = Fileira;
			aux = aux + i;
			lugar[i] = new Assento(id_user,c);
			lugar[i].SetLugar(aux);
		}
	}
	private void CriarLugares_E(Assento[] lugar, int id_user) { // 10 lugares D(39-48)
		String Fileira = "E-";
		for(int i=39; i<=48;i++) {
			String aux = Fileira;
			aux = aux + i;
			lugar[i] = new Assento(id_user,c);
			lugar[i].SetLugar(aux);
		}
	}
	private JPanel Tela() {
		JPanel tela = new JPanel();
		tela.setLayout(new MigLayout());
		JSeparator barraE = new JSeparator();
		JSeparator barraD = new JSeparator();
		
		barraE.setPreferredSize(new Dimension(210,0));
		barraD.setPreferredSize(new Dimension(210,0));
		
		JLabel Tela = new JLabel("TELA");
		Tela.setFont(new Font("Perpetua",0,30));
		
		tela.add(barraD);
		tela.add(Tela);
		tela.add(barraE);
		
		return tela;
	}
	private void ValidarIngressos(Assento[] Lugares) {
		WonderWomanControl novo = new WonderWomanControl ();
		novo.ValidarIngresso(Lugares);
		}
}
