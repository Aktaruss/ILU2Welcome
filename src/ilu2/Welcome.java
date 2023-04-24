package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder texte = new StringBuilder();
		if (input == null || stringEstVide(input)) {
			texte.append("Hello, my friend");
			return texte.toString();
		} else {
			texte.append(changement(input));
			System.out.println(texte.toString());
			return texte.toString();
		}
	}

	private static String changement(String input) {
		StringBuilder texte = new StringBuilder().append("Hello");
		StringBuilder texteMaj = new StringBuilder().append("HELLO");
		boolean maj = false, min = false;
		String[] mots = input.split(",");
		for (String mot : mots) {
			if (stringEstMajuscule(mot)) {
				texteMaj.append(", ").append(mot);
				maj = true;
			} else {
				majusculePremier(texte, mot);
				min = true;
			}
		}
		return rendu(texte, texteMaj, min, maj);
	}

	private static boolean stringEstVide(String input) {
		return input.trim().length() == 0;
	}

	private static boolean stringEstMajuscule(String input) {
		String test = input.toUpperCase();
		return input.equals(test);
	}

	private static void majusculePremier(StringBuilder texte, String mot) {
		texte.append(", ");
		texte.append(mot.substring(0, 1).toUpperCase());
		texte.append(mot.substring(1));
	}

	private static String rendu(StringBuilder texte, StringBuilder texteMaj, boolean min, boolean maj) {
		if (min && maj) {
			return texte.append(". AND ").append(texteMaj.toString()).append(" !").toString();
		} else if (min) {
			return texte.toString();
		} else {
			return texteMaj.append(" !").toString();
		}
	}
}
