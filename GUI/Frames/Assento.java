package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import Functions.Registro;
import net.miginfocom.swing.MigLayout;
import sistema.controle.AtomicControl;
import sistema.controle.*;

public class Assento extends JButton implements ActionListener {
	private boolean aux = false;
	private float valor = 18.0f;
	private String Lugar;
	private String url = "C:\\Users\\Eloi Câmara\\eclipse-workspace\\Trabalho_3Nota\\Cinema\\src\\IMG\\seat.png";
	
	public Assento(int id_user,Control c) {
		this.setIcon(Avatar(url,45,45));
		this.setMaximumSize(new Dimension(45,45));
		this.setMinimumSize(new Dimension(45,45));
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Assento escolhido com sucesso!\n" + Lugar);
				aux = true;
				if (Comprar(id_user,c) == 1) {
					ClickBttm();
					Recibo novo = new Recibo("Recibo",id_user,valor);
					Registro novoRegistro = new Registro(id_user,Lugar,valor,c);
				}
				else {
					JOptionPane.showMessageDialog(null,"O ingreso não pode ser comprado!");
				}
			}
		});
	}
	
	public void SetLugar(String lugar) {
		this.Lugar = lugar;
	}
	private ImageIcon Avatar(String url, int x, int y) {
		ImageIcon imageicon = new ImageIcon(url);
		Image icon = imageicon.getImage();
		Image newIcon = icon.getScaledInstance(x,y, java.awt.Image.SCALE_SMOOTH);
		imageicon = new ImageIcon(newIcon);
		return imageicon;		
	}
	public void ClickBttm() {
		if (this.aux = true) {
			this.setEnabled(false);
		}
	}
	public boolean Comprado() {
		if (this.aux = true) {
			return true;
		}
		else {
			return false;
		}
	}
	public int Comprar(int id_user,Control c) {
		UserControl novo = new UserControl();
		if (novo.HasCard(id_user) == -1) {
			if (c instanceof AtomicControl) {
				AtomicControl novoFilme = new AtomicControl();
				novoFilme.InsereDados(this);
				return 1;
			}
			else if (c instanceof BabyDriverControl) {
				BabyDriverControl novoFilme = new BabyDriverControl();
				novoFilme.InsereDados(this);
				return 1;
			}
			else if (c instanceof BladeRunnerControl) {
				BladeRunnerControl novoFilme = new BladeRunnerControl();
				novoFilme.InsereDados(this);
				return 1;
			}
			else if (c instanceof GuardiansGalaxyControl) {
				GuardiansGalaxyControl novoFilme = new GuardiansGalaxyControl();
				novoFilme.InsereDados(this);
				return 1;
			}
			else if (c instanceof KingsmanControl) {
				KingsmanControl novoFilme = new KingsmanControl();
				novoFilme.InsereDados(this);
				return 1;
			}
			else if (c instanceof MurderControl) {
				MurderControl novoFilme = new MurderControl();
				novoFilme.InsereDados(this);
				return 1;
			}
			else if (c instanceof WonderWomanControl) {
				WonderWomanControl novoFilme = new WonderWomanControl();
				novoFilme.InsereDados(this);
				return 1;
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Usuário não possui cartao cadastrado!");
			return -1;
		}
		return -1;
	}
	public String GetAssento() {
		return this.Lugar;
	}
	public void Desabilitar() {
		this.setEnabled(false);
	}
	public float GetPreco() {
		return this.valor;
	}
}
