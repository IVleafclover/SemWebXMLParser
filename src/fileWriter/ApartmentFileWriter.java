package fileWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import model.Apartment;

/**
 * @author Christian
 *
 */
public class ApartmentFileWriter {

	/**
	 * Liste der Wohnungen
	 */
	private List<Apartment> apartments;

	/**
	 * Der Writer
	 */
	private PrintWriter writer;

	/**
	 * Constructor
	 * 
	 * @param apartments
	 * @param filename
	 */
	public ApartmentFileWriter(List<Apartment> apartments, String filename) {
		this.apartments = apartments;
		try {
			this.writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Konvertiert jede Wohnung der Liste in das RDF-Schema
	 */
	public void write() {
		for (Apartment apartment : apartments) {
			writer.println("<!-- http://www.htwk-leipzig.de/christian/ApartmentSearch#"
					+ Integer.toString(apartment.getId())
					+ "_"
					+ apartment.getTitle() + " -->");
			writer.println("");
			writer.println("<owl:NamedIndividual rdf:about=\"&ApartmentSearch;"
					+ Integer.toString(apartment.getId()) + "_"
					+ apartment.getTitle() + "\">");
			writer.println("<rdf:type rdf:resource=\"&ApartmentSearch;Apartment\"/>");
			writer.println("<id rdf:datatype=\"&xsd;int\">" + apartment.getId()
					+ "</id>");
			writer.println("<title rdf:datatype=\"&xsd;string\">"
					+ apartment.getTitle() + "</title>");
			writer.println("<longitude rdf:datatype=\"&xsd;double\">"
					+ apartment.getLongitude() + "</longitude>");
			writer.println("<latitude rdf:datatype=\"&xsd;double\">"
					+ apartment.getLatitude() + "</latitude>");
			writer.println("<houseNumber rdf:datatype=\"&xsd;string\">"
					+ apartment.getHouseNumber() + "</houseNumber>");
			writer.println("<numberOfRooms rdf:datatype=\"&xsd;int\">"
					+ apartment.getNumberOfRooms() + "</numberOfRooms>");
			writer.println("<rentWithHeating rdf:datatype=\"&xsd;float\">"
					+ apartment.getRentWithHeating() + "</rentWithHeating>");
			writer.println("<rentWithoutHeating rdf:datatype=\"&xsd;float\">"
					+ apartment.getRentWithoutHeating()
					+ "</rentWithoutHeating>");
			writer.println("<size rdf:datatype=\"&xsd;float\">"
					+ apartment.getSize() + "</size>");
			writer.println("<street rdf:datatype=\"&xsd;string\">"
					+ apartment.getStreet() + "</street>");
			writer.println("</owl:NamedIndividual>");
			writer.println();
			writer.flush();
		}
		writer.close();
	}

}
