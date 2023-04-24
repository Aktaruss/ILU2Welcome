package ilu2;

public class Welcome {

	private static String majusculePremierTousNoms(String input) {
		StringBuilder texte = new StringBuilder();
		String[] mots = input.split(",");
		for (String mot : mots) {
			texte.append(", ");
			texte.append(mot.substring(0, 1).toUpperCase());
			texte.append(mot.substring(1));
		}
		return texte.toString();
	}

	private static boolean stringEstVide(String input) {
		return input.trim().length() == 0;
	}

	private static boolean stringEstMajuscule(String input) {
		String test = input.toUpperCase();
		return input.equals(test);
	}

	public static String welcome(String input) {
		StringBuilder texte = new StringBuilder();
		if (input == null || stringEstVide(input)) {
			texte.append("Hello, my friend");
			return texte.toString();
		} else if (stringEstMajuscule(input)) {
			texte.append("HELLO, ").append(input).append(" !");
			return texte.toString();
		}

		else {
			texte.append("Hello").append(majusculePremierTousNoms(input));
			return texte.toString();
		}
	}

}
