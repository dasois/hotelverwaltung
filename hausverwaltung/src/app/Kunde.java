package app;

import java.util.Date;

public class Kunde {
	private String Anrede;
	private String Name;
	private String Adresse;
	private final Date Geburstag;
	private Date Datum;
	
	public Kunde(String An, String N, String Ad, Date G,Date D){
		Anrede = An;
		Name = N;
		Adresse = Ad;
		Geburstag = G;
		Datum = D;
	}
}
