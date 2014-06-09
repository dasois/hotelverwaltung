package gui.delete;

import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import app.DeleteControlImp;
import app.DeleteControlInterface;

public class DeleteFrameController<T> implements ActionListener{
	private VerwaltungMainFrameView mf;
	private DeleteFrameView df;
	
	public DeleteFrameController(DeleteFrameView df,VerwaltungMainFrameView mf){
		this.mf = mf;
		this.df = df;
	}

	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new gui.FrameSwitchImpl(df,mf);
		
		if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}
		else if(e.getActionCommand()=="Create"){
			df.createWidgetSecondView();
		}else if(e.getActionCommand()=="Revise"){
			df.createWidgetFirstView();
		}else if(e.getActionCommand()=="accept"){
			
			DeleteControlInterface<T> controller = new DeleteControlImp<>();
			//TODO sinnvolle exception
			try {
				controller.deleteEntity((T)df.list.getSelectedValue());
				
				mf.addProtocolLine("--Löschen--\n"+df.list.getSelectedValue().toString()+"\nwurde in der Datenbank gelöscht\n");
			
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte nicht gelöscht werden, rufen sie ihren Administrator");
			}
			catch (NullPointerException e1) {
				mf.addProtocolLine("Es konnte nicht gelöscht werden, da keine Auswahl getroffen wurde.");
			}
			fs.switchFrame();
		}

	}
}
