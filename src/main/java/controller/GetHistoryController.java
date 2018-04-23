package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatrizDAO;

@WebServlet("/getHistory")
public class GetHistoryController extends HttpServlet
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
		MatrizDAO dao = new MatrizDAO();
		int userid = Integer.parseInt(request.getParameter("userid"));
		String history = dao.getMatriz(userid);
		if (history != null)
			response.getWriter().write(dao.getMatriz(userid));
		else
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

	}

}
