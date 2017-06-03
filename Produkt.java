package kaffeeautomat;

public abstract class Produkt {

	protected String bezeichnung; //Warum private, wenn wir Unterklassen davon haben?
	protected int preis; // Warum int? // Warum private, wenn wir Unterklassen davon haben?
	protected String [] optionen; //Warum private, wenn wir Unterklassen davon haben?
	
		
	Produkt(String bezeichnung, int preis){
		this.bezeichnung=bezeichnung;
		this.preis=preis;
	}
	
	
	
	
	public void setOption(String option) {
}
	
	public String toString() {
		return null;
	}
	
	
	
	public  int getPreis(){
		return preis;
	}
	
	public void setPreis(int preis){
		this.preis=this.getPreis()+preis;
	}
	
	
	
	public String[] getOptionen(){
		return optionen;
	}
	
	
	public void wähleOptionen (String option) {
	}
	
	public String getBezeichnung(){
		return bezeichnung;
	}
	
	
	
}
