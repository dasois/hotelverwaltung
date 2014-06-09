package gui.Login;

import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.LoginControlImp;
import app.LoginControlInterface;

public class FrameLoginController implements ActionListener{
	private FrameLoginView gui;
	
	public FrameLoginController(FrameLoginView gui){
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent arg0) {
		String user = gui.userTextField.getText();
		String passText = new String(gui.passwordTextField.getPassword());
		LoginControlInterface tmp = new LoginControlImp();
		try {
			if(tmp.loginDB(user, passText)){
				new VerwaltungMainFrameView().init();
				gui.closeFrame();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Falsche Benutzer/Passwort kombination.\n Bei wiederholtem Fehlschlag überprüfen sie ob die DatenBank läuft.");
		}
	}
}