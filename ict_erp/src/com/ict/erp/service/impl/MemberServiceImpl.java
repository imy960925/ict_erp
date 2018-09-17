package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.dao.impl.MemberDAOImpl;
import com.ict.erp.service.MemberService;
import com.ict.erp.vo.MemberInfo;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao = new MemberDAOImpl();
	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMiList(mi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}
	public static void main(String[] args) {
		MemberService ms = new MemberServiceImpl();
		try {
			if(ms.selectMiList(null).size()==0) {
				System.out.println("성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public MemberInfo selectMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMi(mi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}

	}
	
	

	@Override
	public Map<String, Object> insertMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String,Object> insertMi = new HashMap<String,Object>();
		try {
			int cnt =mdao.insertMi(mi);
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
	public Map<String, Object> updateMi(MemberInfo mi) throws SQLException{
		mdao.setConnection(DBCon.getCon());
		Map<String,Object> updateMap = new HashMap<String,Object>();
		try {
			int cnt = mdao.updateMi(mi);
			updateMap.put("cnt", cnt);
			if(cnt==1) {
				updateMap.put("msg", "성공하였습니다");
			}else {
				updateMap.put("msg", "실패하였습니다");
			}
			return updateMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			
		}
		
	}

	@Override
	public Map<String, Object> deleteMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String,Object> dMap = new HashMap<String,Object>();
		try {
			int cnt = mdao.deleteMi(mi);
			dMap.put("cnt", cnt);
			if(cnt==1) {
				dMap.put("msg", "성공하였습니다");
				
			}else {
				dMap.put("msg", "실패하였습니다");
			}
			return dMap;
		}catch(SQLException e) {
			throw e;
		}
		
	}

}
