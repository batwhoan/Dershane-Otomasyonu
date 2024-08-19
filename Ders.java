//BATUHAN AYDOGDU 21100011024
package sdacf;

public class Ders {
	private int dersId;
	private String dersAd;
	public static int dersno=1100;
	
	
	
	public Ders(int dersId, String dersAd) {
		
		this.dersId = dersId;
		this.dersAd = dersAd;
	}
	public Ders(String dersad)
	{
		this.dersAd=dersad;
		this.dersId=dersno+=10;
	}



	public int getDersId() {
		return dersId;
	}



	public void setDersId(int dersId) {
		this.dersId = dersId;
	}



	public String getDersAd() {
		return dersAd;
	}



	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
