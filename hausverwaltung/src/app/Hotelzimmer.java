package app;

import java.util.Date;

public class Hotelzimmer {
	private final boolean doppelzimmer;
	private final int zimmernummer;
	private Date Datum;
	private double preis;
	
	public Hotelzimmer(boolean d,int z,Date D,double p){
		doppelzimmer = d;
		zimmernummer = z;
		Datum = D;
		preis = p;
	}
}
