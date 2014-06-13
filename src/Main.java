import gui.Login.FrameLoginController;
import gui.Login.FrameLoginView;


public class Main {
	public static void main(String[] args) {
		FrameLoginController c = new FrameLoginController();
		FrameLoginView li = new FrameLoginView(c);
		c.setConnectedView(li);
		li.init();
	}
}
