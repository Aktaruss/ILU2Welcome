package ilu2;

public class Welcome {

	private static String majusculePremier(String input) {
		StringBuilder texte = new StringBuilder();
		texte.append("Hello, ");
		texte.append(input.substring(0, 1).toUpperCase());
		texte.append(input.substring(1));
		return texte.toString();
	}

	public static boolean stringEstVide(String input) {
		return input.trim().length() == 0;
	}

	public static String welcome(String input) {
		StringBuilder texte = new StringBuilder();
		if (stringEstVide(input)) {
			texte.append("Hello, my friend");
			return texte.toString();
		} else {
			texte.append(majusculePremier(input));
			return texte.toString();
		}
	}

}
