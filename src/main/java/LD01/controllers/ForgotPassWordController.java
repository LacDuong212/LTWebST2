package LD01.controllers;

import java.io.IOException;

import LD01.services.IUserService;
import LD01.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPassWordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService service = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");

		boolean checkEmail = service.checkEmailByUserName(username, email);

		if (checkEmail) {
			req.setAttribute("Message", "Correct Email.");
		} else {
			req.setAttribute("Message", "Incorrect Email.");
		}

		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
}
