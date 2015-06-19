package XMLParser;

import java.util.List;

import fileWriter.ApartmentFileWriter;
import fileWriter.ParkFileWriter;
import fileWriter.StationFileWriter;
import model.Apartment;
import model.Park;
import model.Station;

/**
 * @author Christian
 *
 */
public class Main {

	// Dateinamen der Inputs
	private static final String APARTMENTFILENAME1 = "apartments_page_1.xml";
	private static final String APARTMENTFILENAME2 = "apartments_page_2.xml";
	private static final String APARTMENTFILENAME3 = "apartments_page_3.xml";
	private static final String APARTMENTFILENAME4 = "apartments_page_4.xml";
	private static final String STATIONFILENAME = "bus_stops.xml";
	private static final String PARKFILENAME = "parks.xml";

	// Dateinamen der Exports
	private static final String STATIONFILENAMETOWRITE = "station_output.owl";
	private static final String PARKFILENAMETOWRITE = "park_output.owl";
	private static final String APARTMENTFILENAMETOWRITE = "apartment_output.owl";

	// Entscheidungsvariablen, welche Objekte geladen und konvertiert werden
	// sollen
	private static final boolean WITHAPARTMENTS = false;
	private static final boolean WITHSTATIONS = false;
	private static final boolean WITHPARKS = true;

	// Listen der Objekte
	private static List<Apartment> apartments;
	private static List<Station> stations;
	private static List<Park> parks;

	/**
	 * Main-Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Daten parsen

		if (WITHAPARTMENTS) {
			XMLApartmentParser xmlApartmentParser = new XMLApartmentParser(
					APARTMENTFILENAME1);
			apartments = xmlApartmentParser.parse();

			for (Apartment apartment : apartments) {
				System.out.println(apartment);
			}

			xmlApartmentParser = new XMLApartmentParser(APARTMENTFILENAME2);
			apartments.addAll(xmlApartmentParser.parse());

			for (Apartment apartment : apartments) {
				System.out.println(apartment);
			}

			xmlApartmentParser = new XMLApartmentParser(APARTMENTFILENAME3);
			apartments.addAll(xmlApartmentParser.parse());

			for (Apartment apartment : apartments) {
				System.out.println(apartment);
			}

			xmlApartmentParser = new XMLApartmentParser(APARTMENTFILENAME4);
			apartments.addAll(xmlApartmentParser.parse());

			for (Apartment apartment : apartments) {
				System.out.println(apartment);
			}
		}

		if (WITHSTATIONS) {
			XMLStationParser xmlStationParser = new XMLStationParser(
					STATIONFILENAME);
			stations = xmlStationParser.parse();

			for (Station station : stations) {
				System.out.println(station);
			}
		}

		if (WITHPARKS) {
			XMLParkParser xmlParkParser = new XMLParkParser(PARKFILENAME);
			parks = xmlParkParser.parse();

			for (Park park : parks) {
				System.out.println(park);
			}
		}

		// Datein erstellen und fuellen

		if (WITHPARKS) {
			ParkFileWriter parkWriter = new ParkFileWriter(parks,
					PARKFILENAMETOWRITE);
			parkWriter.write();
		}

		if (WITHSTATIONS) {
			StationFileWriter stationWriter = new StationFileWriter(stations,
					STATIONFILENAMETOWRITE);
			stationWriter.write();
		}

		if (WITHAPARTMENTS) {
			ApartmentFileWriter apartmentWriter = new ApartmentFileWriter(
					apartments, APARTMENTFILENAMETOWRITE);
			apartmentWriter.write();
		}
	}
}
