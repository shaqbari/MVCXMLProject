package com.sist.controller;

import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




/**
 * @author user
 *	<bean id="list" class="ListModel">
 *
 *	<?xml version="1.0" encoding="UTF-8">
 *	startDocument()
 *	<a>startElement()
 *		<b>aaa</b> startElement() characters() endElement()
 *	</a>endElement()
 *	endDocument()
 */
public class XMLParser extends DefaultHandler{
	public Map map=new HashMap();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("bean")){
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance();
				map.put(id, obj);
			}
			
		} catch (Exception e) {
			System.out.println("startElement¿¡¼­ "+e.getMessage());
		}
	
	}
	
	
	

	
	
	
}
