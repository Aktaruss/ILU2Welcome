package ilu2;

public class Welcome {

	private static String majusculePremier(String input) {
		StringBuilder texte = new StringBuilder();
		texte.append("Hello, ");
		texte.append(input.substring(0, 1).toUpperCase());
		texte.append(input.substring(1));
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
		if (stringEstVide(input)) {
			texte.append("Hello, my friend");
			return texte.toString();
		} else if (stringEstMajuscule(input)) {
			texte.append("HELLO, ").append(input).append(" !");
			return texte.toString();
		}

		else {
			texte.append(majusculePremier(input));
			return texte.toString();
		}
	}

}
