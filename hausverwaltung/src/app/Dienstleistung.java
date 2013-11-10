package app;

import java.util.Date;

public class Dienstleistung {
	private String NameDerDienstleistung;
	private double preis;
	private Date Datum;
	
	public Dienstleistung(String N, double p, Date D){
		NameDerDienstleistung = N;
		preis = p;
		Datum = D;
	}
}
