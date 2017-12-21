package Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import GUI.Assento;
import sistema.controle.AtomicControl;
import sistema.controle.BabyDriverControl;
import sistema.controle.BladeRunnerControl;
import sistema.controle.Control;
import sistema.controle.GuardiansGalaxyControl;
import sistema.controle.KingsmanControl;
import sistema.controle.MurderControl;
import sistema.controle.WonderWomanControl;

public class Registro {
	
	public Registro (int id_user,String lugar, float p, Control c) {
		Registrar(id_user,lugar,p,c);
	}
	public void CriarDiretorio (String url) {
		File file = new File(url);
		file.mkdirs();
	}
	public void Registrar(int id_user,String lugar, float p, Control c) {
		File file = new File("Registro.txt");
		String nomefilme = NomeFilme(c);
		String newLine = System.getProperty("line.separator");
		
		String relatorio = +id_user + ";" + nomefilme + ";" + lugar + ";" + p + ";" + newLine;
		try {
			FileWriter filewriter = new FileWriter(file.getPath(),true);
			BufferedWriter escrever = new BufferedWriter(filewriter);
			
			
			escrever.write(relatorio);
			escrever.close();
			filewriter.close();
		}
		catch (Exception exc) {
			exc.getMessage();
		}
	}
	private String NomeFilme (Control c) {
		String nome = null;
		if (c instanceof AtomicControl) {
			nome = "Atomica";
		}
		else if (c instanceof BabyDriverControl) {
			nome = "Baby Driver";
		}
		else if (c instanceof BladeRunnerControl) {
			nome = "Blade Runner";
		}
		else if (c instanceof GuardiansGalaxyControl) {
			nome = "Guardiões da Galaxia";
		}
		else if (c instanceof KingsmanControl) {
			nome = "Kimgsman 2";
		}
		else if (c instanceof MurderControl) {
			nome = "Assassinato no Expresso do Oriente";
		}
		else if (c instanceof WonderWomanControl) {
			nome = "Mulher Maravilha";
		}
		return nome;
	}

}
