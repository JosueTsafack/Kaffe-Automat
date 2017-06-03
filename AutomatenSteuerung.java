package kaffeeautomat;

import java.util.ArrayList;
import java.util.List;

public class AutomatenSteuerung implements KaffeeAutomat {

	private Produkt produkt;
	private Zustand zustand;
	private int geld = 0;
	private int mengeKaffee = 2;
	private int mengeKakao = 2;
	private int mengeTee = 3;

	private Protokoll protokoll;

	public AutomatenSteuerung() {
		zustand = Zustand.KEINE_MÜNZE;
		produkt = null;
		protokoll = new Protokoll();
	}

	@Override
	public void bezahleBetrag(int betrag) {

		geld += betrag;

		if (zustand == Zustand.HAT_MÜNZE) {
			System.out.println("Sie k�nnen jetzt ein Produkt w�hlen");

		} else if (zustand == Zustand.IS_GEW�HLT) {

			if (geld < produkt.getPreis()) {
				System.out.println("Es fehlt noch :" + (produkt.getPreis() - geld));

			} else if (geld > produkt.getPreis()) {
				zustand = Zustand.HAT_MÜNZE;
				System.out.println("WechselGeld : " + fordereWechselgeld());
				zustand = Zustand.ZAPFEN;

			} else {
				zustand = Zustand.HAT_MÜNZE;
			}

		} else if (zustand == Zustand.ZAPFEN) {
			System.out.println("Beim Zapfen können Sie kein Geld eniwerfen");
		} else if (zustand == Zustand.AUSVERKAUFT) {
			System.out.println("Sie können keine Geld einwerfen");
		} else {
			System.out.println("Sie haben ein Produkt gewählt");
		}

	}

//	@Override
//	public void waehleProdukt(String produkt) {
//		
//		if(zustand==Zustand.KEINE_MÜNZE){
//			
//			if (produkt.equalsIgnoreCase("Kaffee")) {
//				
//				if (this.getMengeKaffee() > 0) {
//					this.produkt = new Kaffee();
//					mengeKaffee--;
//					this.zapfeProdukt();
//					zustand=Zustand.IS_GEWÄHLT;
//					protokoll.setUmsatz(this.produkt.getPreis());	
//					
//				} else {
//					zustand = Zustand.AUSVERKAUFT;
//				}
//			} else if (produkt.equalsIgnoreCase("Tee")) {
//
//				if (this.getMengeTee() > 0) {
//					this.produkt = new Tee();
//					mengeTee--;
//					this.zapfeProdukt();
//					zustand=Zustand.IS_GEW�HLT;
//					protokoll.setUmsatz(this.produkt.getPreis());
//					
//				} else {
//					zustand = Zustand.AUSVERKAUFT;
//				}
//			} else if (produkt.equalsIgnoreCase("Kakao")) {
//
//				if (this.getMengeKakao() > 0) {
//					this.produkt = new Kakao();
//					mengeKakao--;
//					this.zapfeProdukt();
//					zustand=Zustand.ZAPFEN;
//					protokoll.setUmsatz(this.produkt.getPreis());
//					
//				} else {
//					zustand = Zustand.AUSVERKAUFT;
//				}
//			} else {
//				System.out.println("Das Produkt wird nicht angeboten");
//			}
//		}else if(zustand==Zustand.KEINE_MÜNZE){
//			
//			System.out.println("Sie müssen zuerst Geld einzahlen");
//			
//		}else if(zustand==Zustand.ZAPFEN){
//			System.out.println("Zapfvorgang");
//		}
//	}
	
	
	
	
	
	
	@Override
	public void waehleProdukt(String produkt) {
	
	    try{
		    this.produkt = getProdukt(produkt);
		    decreaseMengeProdukt(produkt);
		    this.zapfeProdukt();
		    zustand=Zustand.ZAPFEN;
		    protokoll.setUmsatz(this.produkt.getPreis());
		
	    }catch(Exception e){
		    zustand = Zustand.AUSVERKAUFT;
		    
		    System.out.println("Sie müssen zuerst Geld einzahlen");
	    }
	
	}
	
	
	/*
	 * to determine the real kind of the product
	 * return a Produkt to emphasize the abstraction
	 */
	public Produkt getProdukt (String produkt ){
		
		if (produkt.equals("kaffee") ){
			return new Kaffee(); 
			
		}else if(produkt.equals("Kakao")){
			return new Kakao();
			
		}else if(produkt.equals("Tee")){
			return new Tee();
			
		}else {
			System.out.println("Das Produkt wird nicht angeboten");
		}
       
	}
	
	public void decreaseMengeProdukt(String produkt){
		if (produkt.equals("kaffee") ){
			mengeKaffee--; 
		}
		if(produkt.equals("Kakao")){
			 mengeKakao--;
		}
		if(produkt.equals("Tee")){
			mengeTee--;
		}
		
	}
	
	
	
	
	
	

	@Override
	public void waehleOption(String option) {

		if(zustand==Zustand.IS_GEWÄHLT){
			produkt.wähleOptionen(option);
		}else {
			System.out.println("Anfrage nicht möglich1");
		}

	}

	@Override
	public int fordereWechselgeld() {

		if (zustand == Zustand.HAT_MÜNZE) {
			zustand = Zustand.KEINE_MÜNZE;
			return geld - produkt.getPreis();
		} else {
			System.out.println("Anfrage nicht möglich2");
		}

		return 0;
	}

	@Override
	public int zapfeProdukt() {

		zustand = Zustand.KEINE_MÜNZE;

		int para = this.geld - produkt.getPreis();

		geld = 0;

		return para;
	}

	@Override
	public int abbruch() {
		if (zustand == Zustand.ZAPFEN || zustand == Zustand.AUSVERKAUFT) {
			System.out.println("Anfrage nicht möglich3");
			return 0;
		}
		zustand = Zustand.KEINE_MÜNZE;
		return geld - produkt.getPreis();
	}

	public String[] listeVerkäufe() {
		String[] s = new String[protokoll.getList().size()];
		return (String[]) protokoll.getList().toArray(s);
	}

	public int getMengeKaffee() {
		return mengeKaffee;
	}

	public void setMengeKaffee(int menge) {
		this.mengeKaffee = this.getMengeKaffee() + menge;
	}

	public int getMengeTee() {
		return mengeTee;
	}

	public void setMengeTee(int menge) {
		this.mengeTee = this.getMengeTee() + menge;
	}

	public int getMengeKakao() {
		return mengeKakao;
	}

	public void setMengeKakao(int menge) {
		this.mengeKakao = this.getMengeKakao() + menge;
	}

	public Zustand getZustand() {
		return zustand;
	}

	public int getGeld() {
		return this.geld;
	}

	enum Zustand {
		HAT_MÜNZE, KEINE_MÜNZE, ZAPFEN, AUSVERKAUFT, IS_GEWÄHLT;
	}

}
