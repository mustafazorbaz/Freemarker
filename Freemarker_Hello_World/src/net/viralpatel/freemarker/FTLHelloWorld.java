package net.viralpatel.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FTLHelloWorld {
	public static void main(String[] args) {
		Configuration cfg =new Configuration();
		try {
			
			Template template=cfg.getTemplate("src/helloworld.ftl");
			Map<String, Object> data=new HashMap<String,Object>();
			data.put("message","Hello World");
			
			List<String> countries = new ArrayList<String>();
			countries.add("TTTT");
			countries.add("India");
			countries.add("Azerbaycan");
			countries.add("Kýrgýzistan");
			
			data.put("countries", countries);
			
			Writer file=new FileWriter (new File("C:\\Users\\mustafazorbaz\\Desktop\\FTL_helloworld.txt"));
			template.process(data, file);
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
