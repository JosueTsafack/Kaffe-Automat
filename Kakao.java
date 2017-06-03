package kaffeeautomat;

import java.util.Arrays;

public class Kakao extends Produkt {
	
	/*
	 * the fixed price of the cocoa.
	 */
	final static int KakaoPrice = 100;

	final static String[] optionen={"kalt","heiß"};
	
	public Kakao() {
		super("Kakao",KakaoPrice);
			
			
	}
	
	/*
	 * getter for the cocoa price.
	 */
	public int getKakaoPrice(){
	   return KakaoPrice;
	}

	@Override
	public void wähleOptionen(String option) {
		if(Arrays.asList(optionen).contains(option)){
				this.setOption(option);
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
