package kaffeeautomat;

import java.util.Arrays;

public class Tee extends Produkt {

	/*
	 * the fixed price of the tea
	 */
	final static int TeePrice = 100;
	
	final static String[] optionen={"milch","Zucker"};
	public Tee(){
		super("Tee",TeePrice);
	
				
	}
	
	/*
	 * getter for the tea price.
	 */
	public int getTeePrice(){
		   return TeePrice;
		}

	@Override
	public void wähleOptionen(String option) {
		if(Arrays.asList(optionen).contains(option)){
			System.out.println(option);
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
