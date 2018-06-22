package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDAO;

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
		HistoryDAO dao = new HistoryDAO();
		int userid = Integer.parseInt(request.getParameter("userid"));
		String history = dao.getHistory(userid);
		if (history != null)
			response.getWriter().write(dao.getHistory(userid));
		else
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

	}

}
