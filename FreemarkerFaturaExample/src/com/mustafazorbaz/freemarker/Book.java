package com.mustafazorbaz.freemarker;

public class Book {

    private String adet;
    private String urun;
    private String fiyat;
    private String kdv;
    
    public Book()
    {
    	
    }
	public Book(String adet, String urun, String fiyat, String kdv) {
		super();
		this.adet = adet;
		this.urun = urun;
		this.fiyat = fiyat;
		this.kdv = kdv;
	}

	public String getAdet() {
		return adet;
	}

	public void setAdet(String adet) {
		this.adet = adet;
	}

	public String getUrun() {
		return urun;
	}

	public void setUrun(String urun) {
		this.urun = urun;
	}

	public String getFiyat() {
		return fiyat;
	}

	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}

	public String getKdv() {
		return kdv;
	}

	public void setKdv(String kdv) {
		this.kdv = kdv;
	}

	
	
	
  
}