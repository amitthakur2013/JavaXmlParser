import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaXmlParser {
	
	public static void main(String args[]) {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("laptops.xml"));
			
			document.getDocumentElement().normalize();
			
			NodeList laptopList = document.getElementsByTagName("laptop");
			
			for(int i =0;i < laptopList.getLength();i++) {
				Node laptop = laptopList.item(i);
				
				if(laptop.getNodeType() == Node.ELEMENT_NODE) {
					NodeList laptopDetails = laptop.getChildNodes();
					System.out.println(((Element)laptop).getAttribute("name").toUpperCase());
					for(int j = 0;j < laptopDetails.getLength();j++) {
						Node laptopDetail = laptopDetails.item(j);
						
						if(laptopDetail.getNodeType() == Node.ELEMENT_NODE) {
							Element detailElement = (Element) laptopDetail;
							System.out.println(detailElement.getTagName()+" => "+detailElement.getAttribute("value"));
						}
						
					}
					
				}
				
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
