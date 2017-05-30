package com.sist.controller;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.sist.model.Model;

import java.io.*;

public class HandlerMapping {
	private Map clsMap=new HashMap();
	
	public HandlerMapping(String path){
		try {
			SAXParserFactory spf=SAXParserFactory.newInstance();
			//html과 xml, hdml, wml모두 parsing가능하기 때문에 factory패턴을 사용한다.
			SAXParser sp=spf.newSAXParser();
			XMLParser xp=new XMLParser();
			sp.parse(new File(path), xp);
			clsMap=xp.map;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Model getBean(String id){
		return (Model) clsMap.get(id);
		
	}
}
