package  freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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


  public FreemarkerTest() {
  }
  public void sablonOlustur() {
  
    // Olu�turmada ve ayarlamada kullan�lacak. Uygulama i�in yaln�z bir kez kullan�lacak.
    Configuration cfg = new Configuration();

    try {
      cfg.setDirectoryForTemplateLoading(new File("resources")); //Template'in bulunmu� oldu�u dosyay� g�stermektedir.
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    cfg.setObjectWrapper(new DefaultObjectWrapper());
    cfg.setDefaultEncoding("UTF-8");    //Kodlama i�in
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER); //Template i�in bir i�keyici HTML yap�s�nda
   
    //Ara Toplama i�in Tan�mlanan degi�kenler
    int sayfadakiKayitAdeti=70,iSayi=0;
    List<String> araToplamlar = new LinkedList<String>();
    double  toplama=0.0;
    
    // Bir model yarat�yoruz.    
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
    	//Sayfa sonunda ara toplama yapt�mak i�in kullan�lmaktad�r.
    	if(i%sayfadakiKayitAdeti==0 && i>sayfadakiKayitAdeti){
    		araToplamlar.add(iSayi,String.valueOf(toplama));
    		iSayi++;
    	}
    }
    
    Fatura fatura2=new Fatura();
	fatura2.setMamulCinsi("0135   BURG");
	fatura2.setYuklemeBirimi("");
	fatura2.setKdv("18");
	fatura2.setBr("KL");
	fatura2.setMiktar("2.00");
	fatura2.setFiyat("2.00");
	fatura2.setBrutTutar("64.00");
	fatura2.setIskontoBir("0.20");
	fatura2.setIskontoIki("0.00");
	fatura2.setIskontoUc("0.00");
	fatura2.setIskontolarTutar("0.35");
	fatura2.setNetTutar("75,11");    	
	kayitlarList.add(fatura2);
	
	
	 
    Fatura fatura3=new Fatura();
	fatura3.setMamulCinsi("159900135   BURGER  225 GR. KJSHAKJ");
	fatura3.setYuklemeBirimi("");
	fatura3.setKdv("18");
	fatura3.setBr("KL");
	fatura3.setMiktar("2.00");
	fatura3.setFiyat("2.00");
	fatura3.setBrutTutar("64.00");
	fatura3.setIskontoBir("0.20");
	fatura3.setIskontoIki("0.00");
	fatura3.setIskontoUc("0.00");
	fatura3.setIskontolarTutar("0.35");
	fatura3.setNetTutar("75,11");    	
	kayitlarList.add(fatura3);
	
    
    root.put("kayitlarList", kayitlarList); // Dizimizi put �zerine ekledik. 
    root.put("araToplamlar", araToplamlar);
    root.put("sayfadakiKayitAdeti", sayfadakiKayitAdeti);
    root.put("ad","Volkan");
    root.put("soyad","ABUR");
    root.put("adres","HASAN  TAHSIN CADDESI 370 SOK. NO:1 D:5 BAYULGENLER");
    root.put("il","IZMIR");
    root.put("ulke","TURKIYE");    
    root.put("musVD","CAKABEY");
    root.put("memurKodu","Asil Atay");
    root.put("musteriKodu","3055455");
    root.put("kayitNo","25645456");
    root.put("no","34545648454");
    root.put("tarih","10-12-2015");
    root.put("enter", "\n"); 
    root.put("bosluk", " ");
    root.put("genelToplam", toplama+"");
      System.out.println("İŞLEM BAŞARILI...");
    try {
      //Dizinden template'i �ekmek i�in kullan�yoruz.Dizinimiz resources
      Template temp = cfg.getTemplate("test.ftl");
   
      // template ile veri modelinin birle�tirilmesinden olu�an ��kt�y� yazd�rd�r��m�z dosyan�n  adresi
      Writer out = new FileWriter("C:\\Users\\mustafazorbaz\\Desktop\\fatura.txt");
      temp.process(root, out);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TemplateException e) {
      e.printStackTrace();
    }        
  }
}


