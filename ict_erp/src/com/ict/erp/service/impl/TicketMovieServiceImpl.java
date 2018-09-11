package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.dao.impl.TicketMovieDAOImpl;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.vo.MenuInfo;
import com.ict.erp.vo.TicketMovieInfo;

public class TicketMovieServiceImpl implements TicketMovieService {
	private TicketMovieDAO tmda = new TicketMovieDAOImpl();

	@Override
	public List<TicketMovieInfo> selectMiList(TicketMovieInfo tmi) throws SQLException {
		tmda.setConnection(DBCon.getCon());
		try {
			return tmda.selectMiList(tmi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	
	}

	@Override
	public TicketMovieInfo selectMi(TicketMovieInfo tmi) throws SQLException {
		tmda.setConnection(DBCon.getCon());
		try {
			return tmda.selectMi(tmi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	
	}
	

	@Override
	public Map<String, Object> insertMi(TicketMovieInfo tmi) throws SQLException {
		tmda.setConnection(DBCon.getCon());
		Map<String,Object> insertMi = new HashMap<String,Object>();
		try {
			int cnt = tmda.insertMi(tmi);
			insertMi.put("cnt", cnt);
			if(cnt==1) {
				insertMi.put("msg", "성공하였습니다");
				
			}else {
				insertMi.put("msg", "실패하였습니다");
			}
			return insertMi;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}
	
	
	@Override
	public Map<String, Object> updateMi(TicketMovieInfo tmi) throws SQLException {
		tmda.setConnection(DBCon.getCon());
		try {
			return tmda.updateMi(0);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	
		
	}
	public static void main(String[] args) {
		TicketMovieService tms = new TicketMovieServiceImpl();
		try {
			System.out.println(tms.updateMi(null));
			TicketMovieInfo tmi = new TicketMovieInfo();
			tmi.setTmNum(1);
			tmi.setTmName("독전");
			tmi.setTmPrice(10000);
			tmi.setTmStartdat("12시");
			tmi.setTmEnddat("2시");
			tmi.setTmStartdat("12시");
			tmi.setTmCredat("12시");
			tmi.setTmDesc("12시");
			tmi.setTmCnt(15000);
			tmi.setTmImg("12시");
			//System.out.println(ms.updateMenu(menu));
			//System.out.println(ms.deleteMenu(menu));
			//System.out.println(ms.selectMenu(menu));
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		
	}
		

	@Override
	public Map<String, Object> deleteMi(TicketMovieInfo tmi) {
		// TODO Auto-generated method stub
		return null;
	}

}
