package gui.combinedbooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.book.service.SelectServiceFrameView;
import gui.book.service.SelectTimeFrameView;
import gui.book.service.ServiceModel;

import java.awt.event.ActionEvent;

public class SelectServiceFrameController implements IController{
	private WishOfServiceFrame wf;
	private SelectServiceFrameView sf;
	private SelectTimeFrameView ssf;
	private ServiceModel m;
	public SelectServiceFrameController(SelectServiceFrameView sf,WishOfServiceFrame wf,SelectTimeFrameView ssf,ServiceModel m){
		this.wf = wf;
		this.sf = sf;
		this.ssf = ssf;
		this.m = m;
	}
	public SelectServiceFrameController(WishOfServiceFrame wf,SelectTimeFrameView ssf,ServiceModel m){
		this.wf = wf;
		this.ssf = ssf;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(sf,ssf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(sf,wf);
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			//TODO buchung ins model übernehmen
			fs2.switchFrame();
		}
	}

	public void setConnectedView(AbstractFrame f) {
		this.sf = (SelectServiceFrameView) f;
	}
}