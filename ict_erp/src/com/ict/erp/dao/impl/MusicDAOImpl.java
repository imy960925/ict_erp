package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.vo.MusicInfo;

public class MusicDAOImpl implements MusicDAO {

	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int totalCount(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MusicInfo> selectMiList(MusicInfo mi) throws SQLException {
		Connection con = DBCon.getCon();
		List<MusicInfo> selectMiList = new ArrayList<MusicInfo>();
		String sql = "select mcNum,mcName,mcSinger,mcVendoer,mcLike,mcDisLike,mcCredat,mcDesc";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MusicInfo mii = new MusicInfo();
				mii.setMcNum(rs.getInt("mcNum"));
				mii.setMcName(rs.getString("mcName"));
				mii.setMcSinger(rs.getString("mcSinger"));
				mii.setMcVendoer(rs.getString("mcVendoer"));
				mii.setMcLike(rs.getInt("mcLike"));
				mii.setMcDisLike(rs.getInt("mcDisLike"));
				mii.setMcCredat(rs.getString("mcCredat"));
				mii.setMcDesc(rs.getString("mcDesc"));
				
				
			
				
				
			}
			
		
		}catch(SQLException e){
			throw e;
		}finally {
			DBCon.close();
		}
	
		
		return selectMiList;
	}
	
	public static void main(String[] args) {
		MusicDAO mdao = new MusicDAOImpl();
		mdao.setConnection(DBCon.getCon());
		try {
		if(mdao.selectMiList(null).size()==0) {
			System.out.println("성공");
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		
		}                     
		
	}

	@Override
	public MusicInfo selectMi(MusicInfo mi) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select mcNum,mcName,mcSinger,mcVendoer,mcLike,mcDisLike,mcCredat,mcDesc from music_chart where mcNum=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mi.getMcNum());
			ResultSet rs = ps.executeQuery();
			MusicInfo mii = null;
			while(rs.next()) {
				mii = new MusicInfo();
				mii.setMcNum(rs.getInt("mcNum"));
				mii.setMcName(rs.getString("mcName"));
				mii.setMcSinger(rs.getString("mcSinger"));
				mii.setMcVendoer(rs.getString("mcVendoer"));
				mii.setMcLike(rs.getInt("mcLike"));
				mii.setMcDisLike(rs.getInt("mcDisLike"));
				mii.setMcCredat(rs.getString("mcCredat"));
				mii.setMcDesc(rs.getString("mcDesc"));
				
				
			
				
				
			}
			return mii;
		
		}catch(SQLException e){
			throw e;
		}finally {
			DBCon.close();
		}
	
	}
	

		
	

	@Override
	public int insertMi(MusicInfo mi) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "insert mcNum,mcName,mcSinger,mcVendoer,mcLike,mcDisLike,mcCredat,mcDesc from music_chart where mcNum=?";
		sql += "values(mcNum.nextVal,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mi.getMcNum());
			ps.setString(2, mi.getMcName());
			ps.setString(3, mi.getMcSinger());
			ps.setString(4, mi.getMcVendoer());
			ps.setInt(5, mi.getMcLike());
			ps.setInt(6, mi.getMcDisLike());
			ps.setString(7, mi.getMcCredat());
			ps.setString(8, mi.getMcDesc());
			
			return ps.executeUpdate();
		
		}catch(SQLException e){
			throw e;
		}finally {
			DBCon.close();
		}
	
	}
	
	

	@Override
	public int updateMi(MusicInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMi(MusicInfo mi) throws SQLException{
		Connection con = DBCon.getCon();
		String sql = "delete from music_chart where mcNum=?";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mi.getMcNum());
			
			return ps.executeUpdate();
		
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
			
	
	}
	
	}


