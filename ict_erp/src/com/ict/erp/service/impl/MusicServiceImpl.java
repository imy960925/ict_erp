package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.dao.impl.MusicDAOImpl;
import com.ict.erp.service.MusicService;
import com.ict.erp.vo.MusicInfo;

public class MusicServiceImpl implements MusicService{
	private MusicDAO mdao = new MusicDAOImpl();

	@Override
	public List<MusicInfo> selectMiList(MusicInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMiList(mi);
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	
	
	}
	public static void main(String[] args) {
		MusicService ms = new MusicServiceImpl();
		try {
			if(ms.selectMiList(null).size()==0) {
				System.out.println("성공");
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
				
			}
		
	
	

	@Override
	public MusicInfo selectMi(MusicInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMi(mi);
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	
	
	
	}

	@Override
	public Map<String,Object> insertMi(MusicInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String,Object> insertMi = new HashMap<String,Object>();
		try {
			int cnt = mdao.insertMi(mi);
			insertMi.put("cnt", cnt);
			if(cnt==1) {
				insertMi.put("msg", "성공");
			}else {
				insertMi.put("msg", "실패");
			}
			return insertMi;
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
		
	}
	
	
	
	@Override
	public Map<String, Object> updateMi(MusicInfo mi)  {
		return null;
	}
	

	@Override
	public Map<String, Object> deleteMi(MusicInfo mi) {
		// TODO Auto-generated method stub
		return null;
	}

}
