package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.vo.MemberInfo;

public class MemberDAOImpl extends CommonDAOImpl implements MemberDAO {

	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		List<MemberInfo> selectMiList = new ArrayList<MemberInfo>();
		String sql = "select MI.*,DI.DINAME, LI.LINAME FROM\r\n" + 
				"MEMBER_INFO MI, DEPART_INFO DI, LEVEL_INFO LI\r\n" + 
				"WHERE MI.DICODE = DI.DICODE\r\n" + 
				"AND MI.LILEVEL = LI.LILEVEL";
		try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			MemberInfo mmi = new MemberInfo();
			mmi.setDiCode(rs.getString("diCode"));
			mmi.setLiLevel(rs.getLong("liLevel"));
			mmi.setMiAddress1(rs.getString("miAddress1"));
			mmi.setMiAddress2(rs.getString("miAddress2"));
			mmi.setMiDesc(rs.getString("miDesc"));
			mmi.setMiId(rs.getString("miId"));
			mmi.setMiName(rs.getString("miName"));
			mmi.setMiEmail(rs.getString("miEmail"));
			mmi.setMiPhone(rs.getString("miPhone"));
			mmi.setLiName(rs.getString("liName"));
			mmi.setDiName(rs.getString("diName"));
			selectMiList.add(mmi);
		}
		return selectMiList;
		
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		
	}
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAOImpl();
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
	public MemberInfo selectMi(MemberInfo mi) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select miNum,miId,miName,miPwd,diCode,liLevel,miEmail,miDesc,miPhone,miZipCode,miAddress1,miAddress2 from member_info where miNum=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1,mi.getMiNum());
			ResultSet rs = ps.executeQuery();
			MemberInfo mii = null;
			if(rs.next()) {
				mii = new MemberInfo();
				mii.setMiNum(rs.getLong("miNum"));
				mii.setMiId(rs.getString("miId"));
				mii.setMiName(rs.getString("miName"));
				mii.setMiPwd(rs.getString("miPwd"));
				mii.setDiCode(rs.getString("diCode"));
				mii.setLiLevel(rs.getLong("liLevel"));
				mii.setMiEmail(rs.getString("miEmail"));
				mii.setMiDesc(rs.getString("miDesc"));
				mii.setMiPhone(rs.getString("miPhone"));
				mii.setMiZipCode(rs.getString("miZipCode"));
				mii.setMiAddress1(rs.getString("miAddress1"));
				mii.setMiAddress2(rs.getString("miAddress2"));
				
			}
			return mii;
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}

	@Override
	public int insertMi(MemberInfo mi) throws SQLException{
		String sql = "insert into member_info(miNum,miId,miName,miPwd,diCode,liLevel,miEmail,miDesc,miPhone,miZipCode,miAddress1,miAddress2)";
		sql += "values(seq_miNum.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiName());
			ps.setString(3, mi.getMiPwd());
			ps.setString(4, mi.getDiCode());
			ps.setLong(5, mi.getLiLevel());
			ps.setString(6,mi.getMiEmail());
			ps.setString(7, mi.getMiDesc());
			ps.setString(8, mi.getMiPhone());
			ps.setString(9, mi.getMiZipCode());
			ps.setString(10, mi.getMiAddress1());
			ps.setString(11, mi.getMiAddress2());
			
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
		}finally {
			
		}
		
		
	}

	@Override
	public int updateMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

}
