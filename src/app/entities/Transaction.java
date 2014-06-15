package app.entities;

import gui.IModel;

import java.util.ArrayList;

public class Transaction {
	ArrayList<IModel> modelList;
	Statemachine s;
	public void setActualState(State s){
		this.s.setActualState(s);
	}
	public void rollback(int amount){
		for(int i = amount;i>0; i--){
			s.setpreviousState();
		}
	}
}
