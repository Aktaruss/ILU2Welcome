package ilu2;

import java.util.ArrayList;
import java.util.Arrays;

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

	private static boolean dansTab(String[] motTab, String mot) {
		for (String element : motTab) {
			if (element != null && element.equals(mot))
				return true;
		}
		return false;
	}

	private static String[] miseEnTableauString(ArrayList<String> mot) {
		String[] motTab = new String[mot.size()];
		int i = 0;
		for (String element : mot) {
			if (!dansTab(motTab, element)) {
				motTab[i] = element;
				i++;
			}
		}
		return motTab;
	}

	private static int correspondanceStringInt(String[] motTab, String mot) {
		int i = 0;
		int result = 0;
		for (String element : motTab) {
			if (element != null && element.equals(mot))
				result = i;
			i++;
		}
		return result;
	}

	private static int[] miseEnTableauInt(String[] motTab, ArrayList<String> mot) {
		int[] intTab = new int[motTab.length];
		Arrays.fill(intTab, 0);
		for (String element : mot) {
			intTab[correspondanceStringInt(motTab, element)]++;
		}
		return intTab;
	}

	private static String dernierTab(String[] motTab) {
		String dernier = null;
		for (String element : motTab) {
			if (element != null)
				dernier = element;
		}
		return dernier;
	}

	private static StringBuilder miseEnPhraseMin(ArrayList<String> min) {
		StringBuilder texte = new StringBuilder();
		StringBuilder rendu = new StringBuilder();
		String[] motTab = miseEnTableauString(min);
		int[] intTab = miseEnTableauInt(motTab, min);
		int nbOcc;
		int i = 0;
		boolean yoda = false;
		for (String element : motTab) {
			if (element != null) {
				if (element.equals("yoda") || element.equals("Yoda"))
					yoda = true;
				nbOcc = intTab[correspondanceStringInt(motTab, element)];
				if (i > 0 && element.equals(dernierTab(motTab))) {
					texte.append(" and ");
					majusculePremier(texte, element);
					if (nbOcc > 1)
						texte.append(" (x").append(nbOcc).append(")");
				} else {
					texte.append(", ");
					majusculePremier(texte, element);
					if (nbOcc > 1)
						texte.append(" (x").append(nbOcc).append(")");
				}
			}
			i++;
		}
		if (yoda) {
			return rendu.append(texte.toString().substring(2)).append(", Hello");
		} else {
			return rendu.append("Hello").append(texte.toString());
		}
	}

	private static StringBuilder miseEnPhraseMaj(ArrayList<String> maj) {
		StringBuilder texteMaj = new StringBuilder();
		StringBuilder rendu = new StringBuilder();
		String[] motTab = miseEnTableauString(maj);
		int[] intTab = miseEnTableauInt(motTab, maj);
		int nbOcc;
		int i = 0;
		boolean yoda = false;
		for (String elementMaj : motTab) {
			if (elementMaj != null) {
				if (elementMaj.equals("YODA"))
					yoda = true;
				nbOcc = intTab[correspondanceStringInt(motTab, elementMaj)];
				if (i > 0 && elementMaj.equals(dernierTab(motTab))) {
					texteMaj.append(" AND ");
					texteMaj.append(elementMaj);
					if (nbOcc > 1)
						texteMaj.append(" (x").append(nbOcc).append(")");
				} else {
					texteMaj.append(", ");
					texteMaj.append(elementMaj);
					if (nbOcc > 1)
						texteMaj.append(" (x").append(nbOcc).append(")");
				}
			}
			i++;
		}
		if (yoda) {
			return rendu.append(texteMaj.toString().substring(2)).append(", HELLO");
		} else {
			return rendu.append("HELLO").append(texteMaj.toString());
		}
	}

	private static String miseEnPhrase(ArrayList<String> min, ArrayList<String> maj) {
		StringBuilder texte = miseEnPhraseMin(min);
		StringBuilder texteMaj = miseEnPhraseMaj(maj);
		if (min.isEmpty()) {
			return texteMaj.append(" !").toString();
		} else if (maj.isEmpty()) {
			return texte.toString();
		} else {
			return texte.append(". AND ").append(texteMaj.toString()).append(" !").toString();
		}
	}

}
