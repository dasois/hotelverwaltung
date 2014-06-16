package gui.book;

import java.awt.event.ActionEvent;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

public class CheckOutFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private CheckOutFrameView f;
	public CheckOutFrameController(VerwaltungMainFrameView mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitchImpl fs = new FrameSwitchImpl(f, mf);
		fs.switchFrame();
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (CheckOutFrameView) f;
	}
}