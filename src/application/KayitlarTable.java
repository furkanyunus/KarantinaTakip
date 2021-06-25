package application;

//Kayitlar icin class olusturup setter getter ayarlama
public  class KayitlarTable {
	
	private String hasta_Adi;
	private String sehir_Adi;
	private String meslek_Adi;
	private String cinsiyet_Adi;
	private String ates_Olc;
	private String teshis_Oluru;
	KayitlarTable(){
		
		
	}
	KayitlarTable( String hasta_Ad, String sehir_Ad, String meslek_Ad,  String cinsiyet_Ad, String ates_Ol, String teshis_Olur){
		
		this.hasta_Adi=hasta_Ad;
		this.sehir_Adi=sehir_Ad;
		this.meslek_Adi=meslek_Ad;    
		this.cinsiyet_Adi=cinsiyet_Ad;
		this.ates_Olc=ates_Ol;
		this.teshis_Oluru=teshis_Olur;

	}
	
	
	public String getHasta_Adi() {
		return hasta_Adi;
	}
	
	public void setHasta_Adi(String hasta_Adi) {
		this.hasta_Adi = hasta_Adi;
	}
	
	
	public String getSehir_Adi() {
		return sehir_Adi;
	}
	
	public void setSehir_Adi(String sehir_Adi) {
		this.sehir_Adi = sehir_Adi;
	}
	public String getMeslek_Adi() {
		return meslek_Adi;
	}
	public void setMeslek_Adi(String meslek_Adi) {
		this.meslek_Adi = meslek_Adi;
	}
	public String getCinsiyet_Adi() {
		return cinsiyet_Adi;
	}
	public void setCinsiyet_Adi(String cinsiyet_Adi) {
		this.cinsiyet_Adi = cinsiyet_Adi;
	}
	public String getAtes_Olc() {
		return ates_Olc;
	}
	public void setAtes_Olc(String ates_Olc) {
		this.ates_Olc = ates_Olc;
	}
	public String getTeshis_Oluru() {
		return teshis_Oluru;
	}
	public void setTeshis_Oluru(String teshis_Oluru) {
		this.teshis_Oluru = teshis_Oluru;
	}
	
	

	
	
}
