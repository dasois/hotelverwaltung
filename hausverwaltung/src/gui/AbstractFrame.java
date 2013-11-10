package gui;

import javax.swing.JFrame;
import javax.swing.UIManager;

public abstract class AbstractFrame extends JFrame{
	public AbstractFrame() {
		// wird dynamisch zum Betriebssystem erzeugt
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		setTitle("Hotelverwaltung");//Titel im Kopf
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Beendet das Programm
		setLocationRelativeTo(null);
		
		createWidget();
		setupInteractions();
		addWidget();
		pack();
		setVisible(true);
		
		
	}
	protected abstract void setupInteractions();
	protected abstract void createWidget();
	protected abstract void addWidget();
}
