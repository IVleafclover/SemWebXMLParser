package XMLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Park;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParkParser {

	private String filename;

	public XMLParkParser(String filename) {
		this.filename = filename;
	}

	List<Park> parse() {
		List<Park> parks = new ArrayList<Park>();
		try {
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("node");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					Park Park = new Park();
					
					Park.setLatitude(Double.parseDouble(eElement
							.getAttribute("lat")));
					Park.setLongitude(Double.parseDouble(eElement
							.getAttribute("lon")));

					parks.add(Park);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parks;
	}
	
}
