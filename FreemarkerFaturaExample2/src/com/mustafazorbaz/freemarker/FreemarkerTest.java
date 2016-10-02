package com.mustafazorbaz.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTest {


  public static void main (String[] args) {
  
    // Oluþturmada ve ayarlamada kullanýlacak. Uygulama için yalnýz bir kez kullanýlacak.
    Configuration cfg = new Configuration();

    try {
      cfg.setDirectoryForTemplateLoading(new File("resources")); //Template'in bulunmuþ olduðu dosyayý göstermektedir.
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    cfg.setObjectWrapper(new DefaultObjectWrapper());
    cfg.setDefaultEncoding("UTF-8");    //Kodlama için
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER); //Template için bir iþkeyici HTML yapýsýnda
   
    //Ara Toplama için Tanýmlanan degiþkenler
    int sayfadakiKayitAdeti=70,iSayi=0;
    List<String> araToplamlar = new LinkedList<String>();
    double  toplama=0.0;
    
    // Bir model yaratýyoruz.    
    Map<String, Object> root = new HashMap<String, Object>();
    List<Object> kayitlarList = new LinkedList<Object>();
    for (int i = 1; i <=15; i++) {
    	Fatura fatura1=new Fatura();
    	fatura1.setMamulCinsi("159900135   BURGER  225 GR.");
    	fatura1.setYuklemeBirimi("");
    	fatura1.setKdv("18");
    	fatura1.setBr("KL");
    	fatura1.setMiktar("2.00");
    	fatura1.setFiyat("32.00");
    	fatura1.setBrutTutar("64.00");
    	fatura1.setIskontoBir("0.20");
    	fatura1.setIskontoIki("0.00");
    	fatura1.setIskontoUc("0.00");
    	fatura1.setIskontolarTutar("0.35");
    	fatura1.setNetTutar("75,11");    	
    	kayitlarList.add(fatura1);
    	Fatura kayit=new Fatura();
    	kayit=(Fatura) kayitlarList.get(i-1);
    	toplama+= Double.parseDouble(kayit.getFiyat()); 
    	//System.out.println(toplama);
    	//Sayfa sonunda ara toplama yaptýmak için kullanýlmaktadýr.
    	if(i%sayfadakiKayitAdeti==0 && i>sayfadakiKayitAdeti){
    		araToplamlar.add(iSayi,String.valueOf(toplama));
    		iSayi++;
    	}
    }
    root.put("kayitlarList", kayitlarList); // Dizimizi put üzerine ekledik. 
    root.put("araToplamlar", araToplamlar);
    root.put("sayfadakiKayitAdeti", sayfadakiKayitAdeti);
    root.put("ad","Mustafa");
    root.put("soyad","ZORBAZ");
    root.put("adres","Merkez Mahallesi 370 SOK. NO:1 D:5 Merkeziye");
    root.put("il","ANTALYA");
    root.put("ulke","TURKIYE");    
    root.put("musVD","CAKABEY");
    root.put("memurKodu","Yusuf Atay");
    root.put("musteriKodu","3242432");
    root.put("kayitNo","35324233");
    root.put("no","232253223");
    root.put("tarih","10-12-2015");
    root.put("enter", "\n"); 
    root.put("bosluk", " ");
    root.put("genelToplam", toplama+"");
    try {
      //Dizinden template'i çekmek için kullanýyoruz.Dizinimiz resources
      Template temp = cfg.getTemplate("test.ftl");
   
      // template ile veri modelinin birleþtirilmesinden oluþan çýktýyý yazdýrdýrðýmýz dosyanýn  adresi
      Writer out = new FileWriter("C:\\Users\\mustafa\\Desktop\\fatura.txt");
      temp.process(root, out);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TemplateException e) {
      e.printStackTrace();
    }        
  }
}


