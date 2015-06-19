package fileWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import model.Park;

public class ParkFileWriter {

	private List<Park> parks;
	private PrintWriter writer;
	private final String PARKNAME = "park";
	private static int counter = 0;

	public ParkFileWriter(List<Park> parks, String filename) {
		this.parks = parks;
		try {
			this.writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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
