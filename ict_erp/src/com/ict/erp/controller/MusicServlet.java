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
import com.ict.erp.service.MusicService;
import com.ict.erp.service.impl.MusicServiceImpl;
import com.ict.erp.vo.MusicInfo;


public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicService ms = new MusicServiceImpl();
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		System.out.println(uri);
		try {
			if(cmd.equals("musicList")) {
				request.setAttribute("miList", ms.selectMiList(null));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			doService(request,response);
			}
		
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = ICTUtils.getCmd(request.getRequestURI());
		try {
			if(cmd.equals("musicInsert")) {
				String mcName = request.getParameter("mcName");
				String mcSinger = request.getParameter("mcSinger");
				String ncVendoer = request.getParameter("ncVendoer");
				int mcLike = Integer.parseInt(request.getParameter("mcLike"));
				int mcDisLike = Integer.parseInt(request.getParameter("mcDisLike"));
				String mcCredat = request.getParameter("mcCredat");
				String mcDesc = request.getParameter("mcDesc");
				
				MusicInfo mi = new MusicInfo(0,mcName,mcSinger,ncVendoer,mcLike,mcDisLike,mcCredat,mcDesc);
				request.setAttribute("musicInsert", ms.selectMiList(mi));
				
			}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			doService(request,response);
	}
		
	




public void doService(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
	String uri = "/views" + req.getRequestURI();
	System.out.println(uri);
	RequestDispatcher rd = req.getRequestDispatcher(uri);
	rd.forward(req, res);
}
}
