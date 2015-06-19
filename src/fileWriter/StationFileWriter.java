package fileWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import model.Station;

/**
 * @author Christian
 *
 */
public class StationFileWriter {

	/**
	 * Liste der Haltestellen
	 */
	private List<Station> stations;

	/**
	 * Der Writer
	 */
	private PrintWriter writer;

	/**
	 * Constructor
	 * 
	 * @param stations
	 * @param filename
	 */
	public StationFileWriter(List<Station> stations, String filename) {
		this.stations = stations;
		try {
			this.writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Konvertiert alle Haltestellen in das RDF-Schema
	 */
	public void write() {
		for (Station station : stations) {
			writer.println("<!-- http://www.htwk-leipzig.de/christian/ApartmentSearch#"
					+ Integer.toString(station.getId())
					+ "_"
					+ station.getTitle() + " -->");
			writer.println("");
			writer.println("<owl:NamedIndividual rdf:about=\"&ApartmentSearch;"
					+ Integer.toString(station.getId()) + "_"
					+ station.getTitle() + "\">");
			writer.println("<rdf:type rdf:resource=\"&ApartmentSearch;Station\"/>");
			writer.println("<id rdf:datatype=\"&xsd;int\">" + station.getId()
					+ "</id>");
			writer.println("<title rdf:datatype=\"&xsd;string\">"
					+ station.getTitle() + "</title>");
			writer.println("<longitude rdf:datatype=\"&xsd;double\">"
					+ station.getLongitude() + "</longitude>");
			writer.println("<latitude rdf:datatype=\"&xsd;double\">"
					+ station.getLatitude() + "</latitude>");
			writer.println("</owl:NamedIndividual>");
			writer.println();
			writer.flush();
		}
		writer.close();
	}

}
