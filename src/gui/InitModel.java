package gui;

import app.entities.State;

public class InitModel implements IModel {

	@Override
	public boolean checkCorrespondingState(State s) {
		return State.Init==s;
	}
}