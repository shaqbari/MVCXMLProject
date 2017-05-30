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
			//html�� xml, hdml, wml��� parsing�����ϱ� ������ factory������ ����Ѵ�.
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
