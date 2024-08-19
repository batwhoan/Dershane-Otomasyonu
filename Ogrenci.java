//BATUHAN AYDOGDU 21100011024
package sdacf;

import java.util.ArrayList;

public class Ogrenci {
	private int ogrId;
	private String ogrAdSoyad;
	private int ogrYas;
	public ArrayList<Ders> alinanDersler;


	public Ogrenci(int ogrenciid, String ogrenciad, int ogrenciyas, ArrayList<Ders> ogrdersler) {
		
		this.ogrId = ogrenciid;
		this.ogrAdSoyad = ogrenciad;
		this.ogrYas = ogrenciyas;
		this.alinanDersler = ogrdersler;
	}

	public int getOgrId() {
		return ogrId;
	}

	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}

	public String getOgrAdSoyad() {
		return ogrAdSoyad;
	}

	public void setOgrAdSoyad(String ogrAdSoyad) {
		this.ogrAdSoyad = ogrAdSoyad;
	}

	public int getOgrYas() {
		return ogrYas;
	}

	public void setOgrYas(int ogrYas) {
		this.ogrYas = ogrYas;
	}

	
	
	
	

	
	

	
}
