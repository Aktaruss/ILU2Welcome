package ilu2;

import java.util.ArrayList;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder texte = new StringBuilder();
		if (input == null || stringEstVide(input)) {
			texte.append("Hello, my friend");
			return texte.toString();
		} else {
			texte.append(changement(input));
			return texte.toString();
		}
	}

	private static String changement(String input) {
		ArrayList<String> min = new ArrayList<>();
		ArrayList<String> maj = new ArrayList<>();
		String[] mots = input.split(", ");
		for (String mot : mots) {
			if (stringEstMajuscule(mot)) {
				maj.add(mot.trim());
			} else {
				min.add(mot.trim());
			}
		}
		return miseEnPhrase(min, maj);
	}

	private static boolean stringEstVide(String input) {
		return input.trim().length() == 0;
	}

	private static boolean stringEstMajuscule(String input) {
		String test = input.toUpperCase();
		return input.equals(test);
	}

	private static void majusculePremier(StringBuilder texte, String mot) {
		texte.append(mot.substring(0, 1).toUpperCase());
		texte.append(mot.substring(1));
	}

	private static String miseEnPhrase(ArrayList<String> min, ArrayList<String> maj) {
		StringBuilder texte = new StringBuilder().append("Hello");
		StringBuilder texteMaj = new StringBuilder().append("HELLO");
		int i = 1;
		for (String element : min) {
			if (min.size() >= 2 && min.size() == i) {
				texte.append(" and ");
				majusculePremier(texte, element);
			} else {
				texte.append(", ");
				majusculePremier(texte, element);
			}
			i++;
		}
		i = 1;
		for (String elementMaj : maj) {
			if (min.size() >= 2 && min.size() == i) {
				texteMaj.append(" AND ").append(elementMaj);
			} else {
				texteMaj.append(", ").append(elementMaj);
			}
			i++;
		}
		if (min.isEmpty()) {
			return texteMaj.append(" !").toString();
		} else if (maj.isEmpty()) {
			return texte.toString();
		} else {
			return texte.append(". AND ").append(texteMaj.toString()).append(" !").toString();
		}
	}
}
