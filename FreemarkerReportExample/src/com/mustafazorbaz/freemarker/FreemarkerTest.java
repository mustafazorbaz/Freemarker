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
    // Bir model yarat�yoruz.    
    Map<String, Object> root = new HashMap<String, Object>();
    List<Object> productsList = new LinkedList<Object>();
    productsList.add(new Product(1500, "P�nar S�t 1 Litre", 1.100, 8.600));
    productsList.add(new Product(5500, "P�nar S�t 0.5 Litre", 800, 8.900));
    productsList.add(new Product(300, "P�nar Sucuk  ", 700, 6.400));
    productsList.add(new Product(1500, "P�nar su", 800,4.600));
    root.put("productsList", productsList);    
    //Sayfa boyutlama
    root.put("ust", 300);
    root.put("alt", 100);
    root.put("sag", 500);
    root.put("sol", 350);
    root.put("tabloGenislik", 500);
    root.put("tabloYukseklik", "auto");
    
    try {
      //Dizinden template'i �ekmek i�in kullan�yoruz.Dizinimiz resources
      Template temp = cfg.getTemplate("test.ftl");   
      // template ile veri modelinin birle�tirilmesinden olu�an ��kt�y� yazd�rd�r��m�z dosyan�n  adresi
      Writer out = new FileWriter("C:\\Users\\mustafa\\Desktop\\report.html");
      temp.process(root, out);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TemplateException e) {
      e.printStackTrace();
    }        
  }
}