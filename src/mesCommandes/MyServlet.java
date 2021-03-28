package mesCommandes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out;
		 String title = "MyServlet Output";
		 response.setContentType("text/html");
		 out = response.getWriter();
		 out.println("<HTML><HEAD><TITLE>");
		 out.println(title);
		 out.println("</TITLE></HEAD><BODY>");
		 out.println("<H1>" + title + "</H1>");
		 out.println("<P>This is output from MyServlet.");
		 out.println("</BODY></HTML>");
		 out.close();

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
