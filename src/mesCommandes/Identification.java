package mesCommandes;

import javax.servlet.http.Cookie;

public class Identification {
	
	static String chercheNom (Cookie  [] cookies) {
		// cherche dans les cookies la valeur de celui qui se nomme "nom"
		// retourne la valeur de ce nom au lieu de inconnu
		
		for (Cookie acookie : cookies) {
		 
		    if (acookie.getName().equals("nom")) {
		        return acookie.getValue();
		    }
		}
		return "inconnu";
		}

	public static String verifier(Cookie[] cookies) {
		return null;
	}
	}

