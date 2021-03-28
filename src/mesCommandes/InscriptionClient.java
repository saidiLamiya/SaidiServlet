package mesCommandes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class InscriptionClient extends HttpServlet { 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession  session = request.getSession();
		
		String nomRecu=null, motPasseRecu=null;
		String nomCookie=null, motPasseCookie=null;
		
		// initialisation cookies et paramètres
		nomRecu = request.getParameter("nom");
		motPasseRecu = request.getParameter("motdepasse");
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for (Cookie acookie : cookies) {
				if (acookie.getName().equals(nomRecu)) {
					nomCookie = nomRecu;
				}
				else if (acookie.getName().equals(motPasseRecu)) {
					motPasseCookie = acookie.getValue();
				}
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		
		if (nomCookie ==null && nomRecu==null){
			// Cas 1 : cas où il n'y a ni de cookies ni de parametres
			out.println("<html>");
			out.println("<body>");
			out.println("<head>"); 
			out.println("<title> inscription d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >"); 
			out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
			out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
            out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
            out.print(" <form action='InscriptionClient' method='GET' > ");
            out.println("nom");
            out.println("<input type='text' size='20' name='nom' >");
            out.println("<br>");
            out.println("mot de passe");
            out.println("<input type='password' size='20' name='motdepasse'> <br>");
            out.println("<input type='submit' value='inscription'>");
			out.println("</form>"); 
			out.println("</body>");
			out.println("</html>");
			
		} else if (nomCookie==null && nomRecu!=null){
			// Cas 2 : cas où il n'y a pas de cookies mais les paramètres nom et mot de passes sont présents :
			Cookie nameCookie = new Cookie("nom", nomRecu);
			Cookie cookie = new Cookie(nomRecu, motPasseRecu);
			response.addCookie(nameCookie);
			response.addCookie(cookie);
			response.sendRedirect("sinscrire?nom="+nomRecu);
			System.out.println("TRUE");
		}
		else if (identique(nomRecu,nomCookie) && identique(motPasseRecu,motPasseCookie)) 
        {
			// Cas 4 : cas où le nom et le mot passe sont correctes, appel à la servlet achat
			((HttpServletResponse) response).sendRedirect("achat");        
		}
		
		else {
			// Cas 3 : les cookies sont présents demande de s'identifier
			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title>Identification</title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >");
			out.print(" <form action='sinscrire' method='GET' > ");
			out.println("nom");
			out.println("<input type='text' size='20' name='nom' >");
			out.println("<tr>");
			out.println("mot de passe");
			out.println("<input type='password' size='20' name='motdepasse'> <br>");
			out.println("<input type='submit' value='se connecter'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			System.out.println(3);
			System.out.println("cookie: nom = "+nomCookie+" | pass = "+motPasseCookie+
					"\nclient: nom = "+nomRecu+" | pass = "+motPasseRecu);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	boolean identique (String recu, String cookie) {
		 return ((recu != null) && (recu.length() >3) && (cookie != null) && (recu.equals(cookie) ));
		 }
}

