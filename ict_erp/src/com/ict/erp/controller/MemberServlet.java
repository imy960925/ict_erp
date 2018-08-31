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
import com.ict.erp.service.LevelService;
import com.ict.erp.service.MemberService;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.service.impl.MemberServiceImpl;
import com.ict.erp.vo.MemberInfo;


@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService ms = new MemberServiceImpl();
	private LevelService ls = new LevelServiceImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String uri = request.getRequestURI();
	String cmd = ICTUtils.getCmd(uri);
	try{
		if(cmd.equals("memberList")) {
			request.setAttribute("miList", ms.selectMiList(null));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	doService(request,response);
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = ICTUtils.getCmd(request.getRequestURI());
		try {
			if(cmd.equals("memberInsert")) {
				String miId = request.getParameter("miId");
				String miName = request.getParameter("miName");
				String miPwd = request.getParameter("miPwd");
				String diCode = request.getParameter("diCode");
				Long liLevel = Long.parseLong(request.getParameter("liLevel"));
				String miEmail = request.getParameter("miEmail");
				String miDesc = request.getParameter("miDesc");
				String miPhone = request.getParameter("miPhone");
				String miZipCode = request.getParameter("miZipCode");
				String miAddress1 = request.getParameter("miAddress1");
				String miAddress2 = request.getParameter("miAddress2");
				
				MemberInfo mi = new MemberInfo(0l, miId, miName, miPwd, diCode, liLevel,miEmail,
						miDesc, miPhone, miZipCode, miAddress1, miAddress2,null,
						null);
				request.setAttribute("memberInsert", ms.insertMi(mi));
				
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		doService(request, response);
	}
	
		
	
	public void doService(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		System.out.println(uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
