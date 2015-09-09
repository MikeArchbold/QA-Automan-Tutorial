package com.facebook.qa.tools;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
//might change this but seems to be exactly what I need
public class ReadXMLFile {

  public static void main(String[] args){
	String test[][] = ReadXMLFile.getUsersXML();
	System.out.println(test[1][0] + "\n" + test[1][1]);
  }
  
  public static String[][] getUsersXML() {
	  final int totalUsers = 2;
	  final int numCredentials = 3;
	  String[][] users = null;
	  
	  try {
    	File fXmlFile = new File("C:\\users.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(fXmlFile);
	
    	//optional, but recommended
    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    	doc.getDocumentElement().normalize();
			
    	NodeList nList = doc.getElementsByTagName("email");

		users = new String[totalUsers][numCredentials];
    	for (int temp = 0; temp < nList.getLength(); temp++) {

    		Node nNode = nList.item(temp);
			
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    			
    			Element eElement = (Element) nNode;
    			users[temp][0] = eElement.getElementsByTagName("username").item(0).getTextContent();
    			users[temp][1] = eElement.getElementsByTagName("password").item(0).getTextContent();
    			users[temp][2] = eElement.getElementsByTagName("errorType").item(0).getTextContent();
    		}
    	}
      } catch (Exception ex) {
    	ex.printStackTrace();
      }
	return users;
  }
}