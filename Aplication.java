import javax.swing.JFrame;

import GUI.Login;

public class Aplication {
	public static void main (String []args) {
		Login Frame_Login = new Login("Cinema");
		Frame_Login.pack();
		Frame_Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame_Login.setResizable(false);
		Frame_Login.setLocationRelativeTo(null);
		Frame_Login.setVisible(true);
	}
}
