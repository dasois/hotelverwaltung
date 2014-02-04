package gui;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Base code for every Frame in this app
 * 
 * @author Tobias
 */
@SuppressWarnings("serial")
public abstract class AbstractFrame extends JFrame {
	public AbstractFrame() {
		// wird dynamisch zum Betriebssystem erzeugt
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Hotelverwaltung");// Titel im Kopf
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Beendet das Programm
		setLocationRelativeTo(null);
	}

	protected void closeFrame() {
		setVisible(false);
	}

	protected void openFrame() {
		setVisible(true);
	}

	protected abstract void setupInteractions();

	protected abstract void createWidget();

	protected abstract void addWidget();

	public void init() {
		createWidget();
		addWidget();
		pack();
		setVisible(true);
		setupInteractions();
	}

	public class FrameSwitchImpl implements FrameSwitcher {
		private JFrame a;
		private JFrame b;

		public FrameSwitchImpl(JFrame a, JFrame b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public void switchFrame() {
			b.setEnabled(true);
			b.setVisible(true);
			a.setVisible(false);
		}
	}
}