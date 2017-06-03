package kaffeeautomat;

import java.util.Arrays;

public class Kaffee extends Produkt {
	
	/*
	 * the fixed price of the coffee.
	 */
	final static int kaffeePrice = 120;
	
	final static String[] optionen={"Milch","Zucker","Schokostreusel"};
	public Kaffee(){
		super("Kaffee" ,kaffeePrice);
	
		
	}
    
	/*
	 * getter for the cocoa price
	 */
	public int getkaffeePrice(){
		   return kaffeePrice;
		}
	@Override
	public void wähleOptionen(String option) {
		if(Arrays.asList(optionen).contains(option)){
			super.setPreis(10);
		}else{
			System.out.println("Diese Option wird nicht angeboten");
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getBezeichnung()+": "+super.getPreis()+" , "+ super.getOptionen();
	}

	@Override
	public void setOption(String option) {
		
		
		
	}
	
	
	
	
	
	
}
