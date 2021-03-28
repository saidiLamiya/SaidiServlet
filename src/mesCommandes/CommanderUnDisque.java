package mesCommandes;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommanderUnDisque extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = null;
		int nbreProduit = 0;
		Cookie[] cookies = request.getCookies();
		nom = Identification.chercheNom(cookies);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title> votre commande </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<h3>" + "Bonjour "+ nom + " voici votre commande" + "</h3>");
		
		// affichage de tous les disques présents dans le panier (éléments de la session)
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();
		
		String value = null;
		String name = null;
		out.println( "<h4>Commande : </h4> ");
		while (names.hasMoreElements()) {
			nbreProduit++;
			name = (String) names.nextElement();
			value = (String) session.getAttribute(name);
			out.println(name + " = " + value + " <br>");	
		}
		if(request.getParameter("ordre").equals("ajouter")) {
			// si parametre ordre == ajouter affichage du disque à ajouter au panier
			out.println(request.getParameter("name") + " = " + request.getParameter("prix") + " </td>");
			// ajout du nouveau disque dans le panier
			session.setAttribute(request.getParameter("name"),request.getParameter("prix"));

		}
		out.println("<A HREF=achat> Vous pouvez commandez un autre disque </A><br> ");
		out.println("<A HREF=enregistre> Vous pouvez enregistrer votre commande </A><br> ");
		out.println("</body>");
		out.println("</html>");
	}
	public void doPost(HttpServletRequest request,
	 HttpServletResponse response)
	throws IOException, ServletException
	 {
	 doGet(request, response);
	 }
}