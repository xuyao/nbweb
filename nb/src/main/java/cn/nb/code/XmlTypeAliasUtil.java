package cn.nb.code;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XmlTypeAliasUtil {

	public static List<String> getTypeAlias(File file){
		List<String> list = new ArrayList<String>();
		try{
			SAXReader reader = new SAXReader();  
			Document document = reader.read(file);  
			Element root = document.getRootElement();
			Element eta = root.element("typeAliases");
			Iterator it= eta.elements("typeAlias").iterator();  
	        while(it.hasNext()){
	        	Element elm=(Element)it.next();
	        	list.add(elm.attributeValue("type"));
	        }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
