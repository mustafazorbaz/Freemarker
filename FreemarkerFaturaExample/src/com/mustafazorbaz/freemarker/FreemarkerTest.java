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
    int sayfadakiKayitAdeti=10,iSayi=0;
    List<String> araToplamlar = new LinkedList<String>();
    double  toplama=0.0;
    
    // Bir model yarat�yoruz.    
    Map<String, Object> root = new HashMap<String, Object>();
    List<Object> bookList = new LinkedList<Object>();
    for (int i = 1; i <=2200; i++) {
    	bookList.add(new Book("15","Herkes ��in JAVA","44.5","13.25")); 
    	Book book=new Book();
    	book=(Book) bookList.get(i-1);
    	toplama+= Double.parseDouble(book.getFiyat()); 
    	System.out.println(toplama);
    	//Sayfa sonunda ara toplama yapt�mak i�in kullan�lmaktad�r.
    	if(i%sayfadakiKayitAdeti==0){
    		araToplamlar.add(iSayi,String.valueOf(toplama));
    		iSayi++;
    	}
    }
    root.put("bookList", bookList); // Dizimizi put �zerine ekledik.
    
    //Sutunlar�m�z�n S�ras�n� Ayarlad�k.
    List<String> sutunlar = new LinkedList<String>();
    sutunlar.add(0, "adet");
    sutunlar.add(1, "urun");
    sutunlar.add(2, "kdv");
    sutunlar.add(3, "fiyat");
    root.put("sutunlar", sutunlar);
    root.put("araToplamlar", araToplamlar);
    root.put("sayfadakiKayitAdeti", sayfadakiKayitAdeti);
    
    
    try {
      //Dizinden template'i �ekmek i�in kullan�yoruz.Dizinimiz resources
      Template temp = cfg.getTemplate("test.ftl");
   
      // template ile veri modelinin birle�tirilmesinden olu�an ��kt�y� yazd�rd�r��m�z dosyan�n  adresi
      Writer out = new FileWriter("C:\\Users\\mustafa\\Desktop\\fatura.txt");
      temp.process(root, out);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TemplateException e) {
      e.printStackTrace();
    }        
  }
}


