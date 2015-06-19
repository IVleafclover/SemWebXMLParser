package tools;

public class LetterClearer {

	public static String clearLetters(String string) {
		return string.replaceAll("&", "-").replaceAll("ÃŸ", "ß").replaceAll("Ã¼", "ü")
				.replaceAll("Ã¶", "ö").replaceAll("Ã¤", "ä")
				.replaceAll("Ã„", "Ä").replaceAll(" ", "_")
				.replaceAll("--", "-").replaceAll("--", "-")
				.replaceAll("\"", "");
	}

}
