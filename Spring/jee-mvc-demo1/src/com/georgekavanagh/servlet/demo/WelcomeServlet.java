package com.georgekavanagh.servlet.demo;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.georgekavanagh.service.demo.WelcomeService;

/**
 * Servlet implementation class WelcomeServlet
 * JEE handles requests from the client using servlets which are the same as springs controllers.
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WelcomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Create the data(model) and add it to the request object
		WelcomeService welcomeService = new WelcomeService();
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("George");
		
		request.setAttribute("myWelcomeMessage", welcomeMessage); //saving the data which gets retrieved by the jsp page
		
		//2. Retrieve the Request Dispatcher
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
		
		//3. Forward request to the view
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
