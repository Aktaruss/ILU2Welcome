package ilu2;

public class Welcome {
	
	private static StringBuilder majusculePremier(String input) {
		StringBuilder texte = new StringBuilder();
		texte.append("Hello, ");
		texte.append(input.substring(0,1).toUpperCase());
		texte.append(input.substring(1));
		return texte;
	}

	public static String welcome(String input) {
		StringBuilder texte = majusculePremier(input);
		return texte.toString();
	}

}
