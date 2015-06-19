package tools;

/**
 * @author Christian
 *
 */
public class LetterClearer {

	/**
	 * korrigiert Sonderzeichen in ienem String
	 * 
	 * @param string
	 *            String, der falsche Sonderzeichen enthaelt
	 * @return String, der korrigierte Sonderzeichen enthaelt
	 */
	public static String clearLetters(String string) {
		return string.replaceAll("&", "-").replaceAll("ÃŸ", "ß")
				.replaceAll("Ã¼", "ü").replaceAll("Ã¶", "ö")
				.replaceAll("Ã¤", "ä").replaceAll("Ã„", "Ä")
				.replaceAll(" ", "_").replaceAll("--", "-")
				.replaceAll("--", "-").replaceAll("\"", "");
	}

}
