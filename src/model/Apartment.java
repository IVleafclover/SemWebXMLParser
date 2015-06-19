package model;

/**
 * @author Christian
 *
 */
public class Apartment {

	/**
	 * ID
	 */
	private int id;

	/**
	 * Titel der Wohnung
	 */
	private String title;

	/**
	 * Stasse
	 */
	private String street;

	/**
	 * Hausnummer
	 */
	private String houseNumber;

	/**
	 * Latitude
	 */
	private double latitude;

	/**
	 * Longitude
	 */
	private double longitude;

	/**
	 * Kaltmiete
	 */
	private float rentWithoutHeating;

	/**
	 * Warmmiete
	 */
	private float rentWithHeating;

	/**
	 * Flaeche
	 */
	private float size;

	/**
	 * Anzahl der Raeume
	 */
	private int numberOfRooms;

	/**
	 * Zaehlvariable fuer die iD
	 */
	private static int index = 0;

	/**
	 * Construvtor
	 */
	public Apartment() {
		this.id = ++index;
	}

	/**
	 * COnstructor
	 * 
	 * @param title
	 * @param street
	 * @param houseNumber
	 * @param latitude
	 * @param longitude
	 * @param rentWithoutHeating
	 * @param rentWithHeating
	 * @param size
	 * @param numberOfRooms
	 */
	public Apartment(String title, String street, String houseNumber,
			double latitude, double longitude, float rentWithoutHeating,
			float rentWithHeating, float size, int numberOfRooms) {
		this.id = ++index;
		this.title = title;
		this.street = street;
		this.houseNumber = houseNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rentWithoutHeating = rentWithoutHeating;
		this.rentWithHeating = rentWithHeating;
		this.size = size;
		this.numberOfRooms = numberOfRooms;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public float getRentWithoutHeating() {
		return rentWithoutHeating;
	}

	public void setRentWithoutHeating(float rentWithoutHeating) {
		this.rentWithoutHeating = rentWithoutHeating;
	}

	public float getRentWithHeating() {
		return rentWithHeating;
	}

	public void setRentWithHeating(float rentWithHeating) {
		this.rentWithHeating = rentWithHeating;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Apartment [title=" + title + ", street=" + street
				+ ", houseNumber=" + houseNumber + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", rentWithoutHeating="
				+ rentWithoutHeating + ", rentWithHeating=" + rentWithHeating
				+ ", size=" + size + ", numberOfRooms=" + numberOfRooms + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((houseNumber == null) ? 0 : houseNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfRooms;
		result = prime * result + Float.floatToIntBits(rentWithHeating);
		result = prime * result + Float.floatToIntBits(rentWithoutHeating);
		result = prime * result + Float.floatToIntBits(size);
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apartment other = (Apartment) obj;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		if (numberOfRooms != other.numberOfRooms)
			return false;
		if (Float.floatToIntBits(rentWithHeating) != Float
				.floatToIntBits(other.rentWithHeating))
			return false;
		if (Float.floatToIntBits(rentWithoutHeating) != Float
				.floatToIntBits(other.rentWithoutHeating))
			return false;
		if (Float.floatToIntBits(size) != Float.floatToIntBits(other.size))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
