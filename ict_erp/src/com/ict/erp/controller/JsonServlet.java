package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.MusicService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.service.impl.MusicServiceImpl;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.MenuInfo;

@WebServlet(urlPatterns = "/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		System.out.println(pMap);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			DepartInfo depart = ds.getDepartInfo(1042);
			String resStr = gs.toJson(depart);
			pw.println(resStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String,String> rMap = gs.fromJson(request.getParameter("param"), Map.class);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MenuService ms = new MenuServiceImpl();
		try {
			//MenuInfo menu = ms.getClass();//
			String resStr = gs.toJson(menu);
			pw.println(resStr);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void main(String[] args) {
		String jsonStr = "{\"a\":\"1\"}";
		Gson gs = new Gson();
		List<Map<String, String>> list = gs.fromJson(jsonStr, List.class);
		System.out.println(list);
	}
}