package gui.delete;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import app.DeleteControlImp;
import app.DeleteControlInterface;

public class DeleteFrameController<T> implements IController{
	private VerwaltungMainFrameView mf;
	private DeleteFrameView<T> df;
	private DeleteControlInterface<T> controller = new DeleteControlImp<>();
	public DeleteFrameController(DeleteFrameView<T> df,VerwaltungMainFrameView mf){
		this.mf = mf;
		this.df = df;
	}
	public DeleteFrameController(VerwaltungMainFrameView mf){
		this.mf = mf;
	}
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new gui.FrameSwitchImpl(df,mf);

		if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}
		else if(e.getActionCommand()=="Delete"){
			try {
				controller.deleteEntity((T)df.list.getSelectedValue());

				mf.addProtocolLine("--Löschen--\n"+df.list.getSelectedValue().toString()+"\nwurde in der Datenbank gelöscht\n");

			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte nicht gelöscht werden, rufen sie ihren Administrator");
			}
			catch (NullPointerException e1) {
				mf.addProtocolLine("1 Es konnte nicht gelöscht werden, da keine Auswahl getroffen wurde.");
			}
			df.createWidgetSecondView();
		}else if(e.getActionCommand()=="Revise"){
			try {
				controller.discardChanges();
			} catch (SQLException e1) {
				mf.addProtocolLine("2 Es konnte nicht gelöscht werden, rufen sie ihren Administrator");
			}
			df.createWidgetFirstView();
		}else if(e.getActionCommand()=="accept"){
			try {
				controller.saveChanges();
			} catch (SQLException e1) {
				mf.addProtocolLine("3 Es konnte nicht gelöscht werden, rufen sie ihren Administrator");
			}
			fs.switchFrame();
		}
	}
	@SuppressWarnings("unchecked")
	public void setConnectedView(AbstractFrame f) {
		this.df = (DeleteFrameView<T>) f;
	}
}