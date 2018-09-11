package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MenuInfo;
import com.ict.erp.vo.TicketMovieInfo;

public class TicketMovieDAOImpl extends CommonDAOImpl implements TicketMovieDAO {

	@Override
	public List<TicketMovieInfo> selectMiList(TicketMovieInfo tmi) throws SQLException {
		List<TicketMovieInfo> movie = new ArrayList<TicketMovieInfo>();
		String sql = "select * from TicketMovie_info where meiNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tmi.getTmNum());
			rs = ps.executeQuery();
			while (rs.next()) {
				TicketMovieInfo mi = new TicketMovieInfo();
				mi.setTmNum(rs.getInt("tmNum"));
				mi.setTmName(rs.getString("tmName"));
				mi.setTmPrice(rs.getInt("tmPrice"));
				mi.setTmStartdat(rs.getString("tmStartdat"));
				mi.setTmEnddat(rs.getString("tmEnddat"));
				mi.setTmCredat(rs.getString("tmCredat"));
				mi.setTmDesc(rs.getString("tmDesc"));
				mi.setTmCnt(rs.getInt("tmCnt"));
				mi.setTmImg(rs.getString("tmImg"));
			
				}
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

		return movie;
	}
		
	

	@Override
	public TicketMovieInfo selectMi(TicketMovieInfo tmi) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select tmNum,tmName,tmPrice,tmStartdat,tmEnddat,tmCredat,tmDesc,tmCnt,tmImg from TicketMovie_info where tmNum=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,tmi.getTmNum());
			ResultSet rs = ps.executeQuery();
			TicketMovieInfo tmii = null;
			if(rs.next()) {
				tmii = new TicketMovieInfo();
				tmii.setTmNum(rs.getInt("tmNum"));
				tmii.setTmName(rs.getString("tmName"));
				tmii.setTmPrice(rs.getInt("tmPrice"));
				tmii.setTmStartdat(rs.getString("tmStartdat"));
				tmii.setTmEnddat(rs.getString("tmEnddat"));
				tmii.setTmCredat(rs.getString("tmCredat"));
				tmii.setTmDesc(rs.getString("tmDesc"));
				tmii.setTmCnt(rs.getInt("tmCnt"));
				tmii.setTmImg(rs.getString("tmImg"));
				
			}
			return tmii;
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}
	
	@Override
	public int insertMi(TicketMovieInfo tmi) throws SQLException {
		String sql = "insert into TicketMovie_info (tmNum,tmName,tmPrice,tmStartdat,tmEnddat,tmCredat,tmDesc,tmCnt,tmImg)";
		sql += " values(seq_tmNum.nextval,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tmi.getTmName());
			ps.setInt(2, tmi.getTmPrice());
			ps.setString(3, tmi.getTmStartdat());
			ps.setString(4, tmi.getTmEnddat());
			ps.setString(5, tmi.getTmCredat());
			ps.setString(6, tmi.getTmDesc());
			ps.setInt(7, tmi.getTmCnt());
			ps.setString(8, tmi.getTmImg());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}
		
	

	@Override
	public int updateMi(TicketMovieInfo tmi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMi(TicketMovieInfo tmi) throws SQLException {
		String sql = "delete from TicketMovie_info where tmNum=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tmi.getTmNum());
			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;

		} finally {
			close();
		}

		
	}


	}


