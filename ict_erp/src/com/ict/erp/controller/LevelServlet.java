package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.LevelService;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.vo.LevelInfo;


public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LevelService ls = new LevelServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		uri = "/views" + uri;
		try {
			if(cmd==null|| cmd.equals("")) {
				uri = "/views/notFound";
			}else if(cmd.equals("levelList")) {
				String str = request.getParameter("search");
				String strs = request.getParameter("searchText");
				LevelInfo li=null;
				if(str!=null) {
					if(!strs.equals("")  && strs!=null) {
						if(str.equals("liDesc")) {
							li=new LevelInfo(0,0,null,strs);
						}else if(str.equals("liName")) {
							li=new LevelInfo(0,0,strs,null);
						}
					}
				}
				
				request.setAttribute("liList", ls.getLiList(li));
			}else if(cmd.equals("deleteLevelList")) {
				String[] liNumStrs = request.getParameterValues("liNum");
				int[] liNums = new int[liNumStrs.length];
				for(int i=0;i<liNumStrs.length;i++) {
					liNums[i] = Integer.parseInt(liNumStrs[i]);
				}
				request.setAttribute("rMap", ls.deleteLiList(liNums));
				uri = "/views/level/levelList";
			}else if(cmd.equals("saveLevelList")) {
				List<LevelInfo>iList = new ArrayList<LevelInfo>();
				String[] liNames = request.getParameterValues("liName");
				String[] liLevels = request.getParameterValues("liLevel");
				String[] liDesces = request.getParameterValues("liDesc");
				for(int i=0;i<liNames.length;i++) {
					int level = Integer.parseInt(liLevels[i]);
					LevelInfo li = new LevelInfo(0,level,liNames[i],liDesces[i]);
					iList.add(li);
				}
				Map<String,List<LevelInfo>> map = new HashMap<String,List<LevelInfo>>();
				map.put("iList", iList);
				map.put("uList", new ArrayList<LevelInfo>());
				Map<String,Object> rMap = ls.insertNUpdateLiList(map);
				request.setAttribute("rMap", rMap);
				uri = "/views/level/levelList";
			}else {
				uri = "/views/notFound";
			}
		}catch(SQLException e) {
			System.out.println(e);
			request.setAttribute("error", e.getMessage());
			uri = "/views/error";
		} 
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
//erd
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
