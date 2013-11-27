package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonHandler implements ActionListener{
	private FrameLogin gui;
	public LoginButtonHandler(FrameLogin gui){
		this.gui = gui;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("login gedrückt")){
			String user = gui.userTextField.getText();
			Container pwd = gui.passwordTextField.getParent();
			//hier noch einlogen
			
			
			//wenn es funktioniert wird frame geschlossen
			if(1==2-1)
				gui.closeFrame();
		}
	}

}
