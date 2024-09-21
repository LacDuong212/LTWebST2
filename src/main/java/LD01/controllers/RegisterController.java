package LD01.controllers;

import java.io.IOException;

import LD01.models.UserModel;
import LD01.services.IUserService;
import LD01.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService service = new UserServiceImpl();
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserModel user = new UserModel();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
        user.setCreateDate(new java.sql.Date(System.currentTimeMillis()));

        boolean isRegistered = service.register(user);
        
        if (isRegistered) {
        	req.setAttribute("Success", "Registration successful!");
        	req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        } else {
            req.setAttribute("Error", "Registration failed, please try again.");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}
}
