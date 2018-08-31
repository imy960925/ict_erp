package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.vo.MenuInfo;


@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uri;
	private MenuService ms = new MenuServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		try {
			if(cmd.equals("menuList")) {
			request.setAttribute("meiList", ms.selectMenuList(null));
			pw.print(ms.selectMenuList(null));
		}else if(cmd.equals("menuView")) {
			String meiNumStr = request.getParameter("meiNum");
			if(meiNumStr==null || meiNumStr.equals("")) {
				throw new SQLException("메뉴번호가 없잖아");
			}
			MenuInfo menu = new MenuInfo();
			menu.setMeiNum(Long.parseLong(meiNumStr));
			pw.println(ms.selectMenu(menu));
		}
		}catch(SQLException e) {
			pw.print("에러났어");
			pw.print("에러이유는 : " + e);
		}
		uri="/views"+uri;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	uri = request.getRequestURI();
	String cmd = ICTUtils.getCmd(uri);
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	request.setCharacterEncoding("utf-8");
	try{
		if(cmd.equals("menuInsert")) {
		String meiName = request.getParameter("meiName");
		String meiPrice = request.getParameter("meiPrice");
		String meiDesc = request.getParameter("meiDesc");
		MenuInfo menu = new MenuInfo(null,meiName,Long.parseLong(meiPrice),meiDesc);
		int cnt =  ms.insertMenu(menu);
		Map<String,Object>mi = new HashMap<String,Object>();
		mi.put("cnt", cnt);
		mi.put("msg", "실패");
		if(cnt==1) {
			mi.put("msg", "성공");
		}
			request.setAttribute("mi",mi);
			pw.println(ms.insertMenu(menu));
	}else if(cmd.equals("menuUpdate")) {
		String meiNum = request.getParameter("meiNum");
		String meiName = request.getParameter("meiName");
		String meiPrice = request.getParameter("meiPrice");
		String meiDesc = request.getParameter("meiDesc");
		MenuInfo menu = new MenuInfo(Long.parseLong(meiNum),meiName,Long.parseLong(meiPrice),meiDesc);
		int cnt = ms.updateMenu(menu);
		Map<String,Object> mMap = new HashMap<String,Object>();
		mMap.put("cnt", cnt);
		mMap.put("msg", "실패");
		if(cnt==1) {
			mMap.put("msg","성공");
		}
		request.setAttribute("mMap", mMap);
		pw.println(ms.updateMenu(menu));
		
	}else if(cmd.equals("menuDelete")) {
		String meiNum = request.getParameter("meiNum");
		String meiName = request.getParameter("meiName");
		String meiPrice = request.getParameter("meiPrice");
		String meiDesc = request.getParameter("meiDesc");
		MenuInfo menu = new MenuInfo(Long.parseLong(meiNum),meiName,Long.parseLong(meiPrice),meiDesc);
		int cnt = ms.deleteMenu(menu);
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("cnt", cnt);
		if(cnt==1) {
			rMap.put("msg", "삭제 성공");
		}else {
			rMap.put("msg", "삭제실패");
		}
		request.setAttribute("rMap", rMap);
		pw.println(ms.deleteMenu(menu));
		
	}
		
	}catch(SQLException e) {
		pw.println("에러났어");
		pw.print("에러이유는 : " + e);
	}
		
	
		doGet(request, response);
	}

}
