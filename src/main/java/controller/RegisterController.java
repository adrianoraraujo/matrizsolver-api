package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import dao.UserDAO;

@WebServlet("/register")
public class RegisterController extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UserDAO dao = new UserDAO();
		JsonObject json = new JsonObject();
		int userid = dao.registerUser();
		json.addProperty("userid", userid);
		response.getWriter().write(json.toString());
		if (userid == -1)
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
	}

}
