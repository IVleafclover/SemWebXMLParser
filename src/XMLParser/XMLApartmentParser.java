package XMLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Apartment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tools.LetterClearer;

/**
 * @author Christian
 *
 */
public class XMLApartmentParser {

	/**
	 * Der Dateiname der Wohnungsimportdatei
	 */
	private String filename;

	/**
	 * Constructor
	 * 
	 * @param filename
	 *            Dateiname Import
	 */
	public XMLApartmentParser(String filename) {
		this.filename = filename;
	}

	/**
	 * Liest XML-Datei der Wohnungen ein
	 * 
	 * @return Liste der Wohnungen
	 */
	List<Apartment> parse() {
		List<Apartment> apartments = new ArrayList<Apartment>();
		try {
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("resultlist:realEstate");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Element address = (Element) eElement.getElementsByTagName(
							"address").item(0);
					Element coordinates = (Element) address
							.getElementsByTagName("wgs84Coordinate").item(0);
					Element priceWithoutWarming = (Element) eElement
							.getElementsByTagName("price").item(0);
					Element priceWithWarming = (Element) eElement
							.getElementsByTagName("calculatedPrice").item(0);

					Apartment apartment = new Apartment();

					// System.out.println("Staff id : "
					// + eElement.getAttribute("id"));
					apartment.setTitle(LetterClearer.clearLetters(eElement
							.getElementsByTagName("title").item(0)
							.getTextContent()));
					apartment.setStreet(LetterClearer.clearLetters(address
							.getElementsByTagName("street").item(0)
							.getTextContent()));
					apartment.setHouseNumber(LetterClearer.clearLetters(address
							.getElementsByTagName("houseNumber").item(0)
							.getTextContent()));
					apartment.setLatitude(Double.parseDouble(coordinates
							.getElementsByTagName("latitude").item(0)
							.getTextContent()));
					apartment.setLongitude(Double.parseDouble(coordinates
							.getElementsByTagName("longitude").item(0)
							.getTextContent()));
					apartment.setRentWithoutHeating(Float
							.parseFloat(priceWithoutWarming
									.getElementsByTagName("value").item(0)
									.getTextContent()));
					apartment.setRentWithHeating(Float
							.parseFloat(priceWithWarming
									.getElementsByTagName("value").item(0)
									.getTextContent()));
					apartment.setSize(Float.parseFloat(eElement
							.getElementsByTagName("livingSpace").item(0)
							.getTextContent()));
					apartment.setNumberOfRooms((int) Float.parseFloat(eElement
							.getElementsByTagName("numberOfRooms").item(0)
							.getTextContent()));

					apartments.add(apartment);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apartments;
	}

}
