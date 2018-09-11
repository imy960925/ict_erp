package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.service.impl.TicketMovieServiceImpl;

/**
 * Servlet implementation class TicketMovieServlet
 */
@WebServlet("/TicketMovieServlet")
public class TicketMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketMovieService tms = new TicketMovieServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		System.out.println(uri);
		try {
			if (cmd.equals("movieList")) {
				request.setAttribute("tmiList", tms.selectMiList(null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			doService(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = ICTUtils.getCmd(request.getRequestURI());
		try {
			if (cmd.equals("movieInsert")) {
				String tmName = request.getParameter("tmName");
				int tmPrice = Integer.parseInt(request.getParameter("tmPrice"));
				String tmStartdat = request.getParameter("tmStartdat");
				String tmEnddat = request.getParameter("tmEnddat");
				String tmCredat = request.getParameter("tmCredat");
				String tmDesc = request.getParameter("tmDesc");
				int tmCnt = Integer.parseInt(request.getParameter("tmCnt"));

			}
			doGet(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		System.out.println(uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
