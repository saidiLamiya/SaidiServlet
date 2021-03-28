package mesCommandes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FiltreAutorisation implements Filter {
		private FilterConfig filterConfig = null;
		public void init(FilterConfig filterConfig) throws ServletException {
			this.filterConfig = filterConfig;
 }
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
		ServletException {
			String nom = null;
			HttpServletRequest hrequest = (HttpServletRequest) request;
			HttpServletResponse hresponse = (HttpServletResponse) response;
			Cookie[] cookies = hrequest.getCookies();
			// test s'il existe un cookie dont l'attribut est "nom"
			if (condition) {
				// cas ou il n'existe pas appel de la servlet inscrire
			}
			else {
				chain.doFilter(request, response); }
			}
			public void destroy() {
				this.filterConfig = null;
				}
				}
