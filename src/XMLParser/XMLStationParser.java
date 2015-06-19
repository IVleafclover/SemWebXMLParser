package XMLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Station;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tools.LetterClearer;

public class XMLStationParser {

	private String filename;

	public XMLStationParser(String filename) {
		this.filename = filename;
	}

	List<Station> parse() {
		List<Station> stations = new ArrayList<Station>();
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
					
					Station station = new Station();
					
					for (int i = 0; i < eElement.getElementsByTagName("tag").getLength(); i++) {
						Element node = (Element) eElement.getElementsByTagName("tag").item(i);
						if(node.getAttribute("k").equals("name")) {
							station.setTitle(LetterClearer.clearLetters(node.getAttribute("v")));
						}
					}

					station.setLatitude(Double.parseDouble(eElement
							.getAttribute("lat")));
					station.setLongitude(Double.parseDouble(eElement
							.getAttribute("lon")));

					stations.add(station);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stations;
	}

}
