package gui;

import javax.swing.JFrame;

public class FrameSwitchImpl implements FrameSwitcher{
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