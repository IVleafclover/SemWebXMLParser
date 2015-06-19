package fileWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import model.Park;

/**
 * @author Christian
 *
 */
public class ParkFileWriter {

	/**
	 * Liste der Parks
	 */
	private List<Park> parks;

	/**
	 * Der Writer
	 */
	private PrintWriter writer;

	/**
	 * Standardparkname
	 */
	private final String PARKNAME = "park";

	/**
	 * Zaehler fuer die iD
	 */
	private static int counter = 0;

	/**
	 * Constructor
	 * 
	 * @param parks
	 * @param filename
	 */
	public ParkFileWriter(List<Park> parks, String filename) {
		this.parks = parks;
		try {
			this.writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Konvertiert alle Parks in das RDF-Schema
	 */
	public void write() {
		for (Park park : parks) {
			if (counter == 0) {
				writer.println("<!-- http://www.htwk-leipzig.de/christian/ApartmentSearch#"
						+ Integer.toString(park.getId())
						+ "_"
						+ PARKNAME
						+ " -->");
				writer.println("");
				writer.println("<owl:NamedIndividual rdf:about=\"&ApartmentSearch;"
						+ Integer.toString(park.getId())
						+ "_"
						+ PARKNAME
						+ "\">");
				writer.println("<rdf:type rdf:resource=\"&ApartmentSearch;Park\"/>");
				writer.println("<id rdf:datatype=\"&xsd;int\">" + park.getId()
						+ "</id>");
				writer.println("<longitude rdf:datatype=\"&xsd;double\">"
						+ park.getLongitude() + "</longitude>");
				writer.println("<latitude rdf:datatype=\"&xsd;double\">"
						+ park.getLatitude() + "</latitude>");
				writer.println("</owl:NamedIndividual>");
				writer.println();
				writer.flush();
			}
			counter++;
			if (counter == 10) {
				counter = 0;
			}
		}
		writer.close();
	}

}
