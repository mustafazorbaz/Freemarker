package com.mustafazorbaz.freemarker;

public class Product {

    private int adet;
    private String urun;
    private double kdv;
    private double fiyat;
  
   
 
  
    public Product(int adet, String urun, double kdv, double fiyat) {
		super();
		this.adet = adet;
		this.urun = urun;
		this.kdv = kdv;
		this.fiyat = fiyat;
	}

	public void setUrun(String urun) {
      this.urun = urun;
    }
	public String getUrun() {
	      return urun;
	    }
	public double getKdv() {
		return kdv;
	}
	public void setKdv(double kdv) {
		this.kdv = kdv;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	
}