package app.entities;

import java.util.ArrayList;

public class Statemachine {
	private ArrayList<State> statelist;
	public Statemachine(){
		statelist = new ArrayList<State>();
		statelist.add(State.Init);
	}
	public void setActualState(State state){
		statelist.add(state);
	}
	public State getActualState(){
		return statelist.get(statelist.size());
	}
	public void setpreviousState(){
		statelist.remove(statelist.size());
	}
	public boolean isInitial(){
		return(statelist.get(statelist.size())==State.Init);
	}
}
