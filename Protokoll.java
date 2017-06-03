package kaffeeautomat;

import java.util.ArrayList;
import java.util.List;

public class Protokoll {

	private int umsatz;
	private List<String> array;
	private VerkaufsEreignis ereignis;
	
	public Protokoll(){
		array=new ArrayList<>();
		ereignis=new VerkaufsEreignis();
	}
	
	public int getUmsatz() {
		return this.umsatz;
	}
	
	public void setUmsatz(int geld){
		umsatz+=geld;
	}
	
	public List getList(){
		return array;
	}
	
}
