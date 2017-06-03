package kaffeeautomat;

public class AutomatMain {

	public static void main(String[] args) {
		AutomatenSteuerung a = new AutomatenSteuerung();
		
		
		a.waehleProdukt("Kaffee");
		System.out.println(a.getZustand());
		a.waehleOption("Milch");
		a.waehleOption("Zucker");
		System.out.println(a.getZustand());
		a.bezahleBetrag(150);
		System.out.println(a.getGeld());
		System.out.println(a.getZustand());
		System.out.println(a.zapfeProdukt());
		System.out.println(a.getZustand());
		System.out.println(a.getGeld());
		
//		a.bezahleBetrag(70);
//		System.out.println(a.getGeld());
//		System.out.println(a.getZustand());

		
		
		
		
		

	}

}
