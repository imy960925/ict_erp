package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl extends CommonDAOImpl implements DepartDAO {

	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select * from (";
		sql += "select di.*, ROWNUM as rNum FROM (";
		sql += "select * from depart_info order by dinum desc) di";
		sql += " where rownum<=?)";
		sql += " where rnum>=?";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, di.getPi().getlNum());
		ps.setInt(2, di.getPi().getsNum());
		ResultSet rs = ps.executeQuery();
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		while (rs.next()) {
			di = new DepartInfo(rs.getInt("diNum"), rs.getString("diCode"), rs.getString("diName"),
					rs.getString("diDesc"));
			diList.add(di);
		}
		return diList;
	}

	@Override
	public DepartInfo selectDepartInfo(int diNum) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select diNum,diName,diDesc,diCode from depart_info where diNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, diNum);
			rs = ps.executeQuery();
			DepartInfo di = null;
			if (rs.next()) {
				di = new DepartInfo();
				di.setDiNum(rs.getInt("diNum"));
				di.setDiName(rs.getString("diName"));
				di.setDiDesc(rs.getString("diDesc"));
				di.setDiCode(rs.getString("diCode"));
			}
			return di;

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int insertDepartInfo(DepartInfo di) throws SQLException {
		String sql = "insert into depart_info(diNum,diName,diDesc,diCode)";
		sql += " values(seq_dinum.nextval,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, di.getDiName());
			ps.setString(2, di.getDiDesc());
			ps.setString(3, di.getDiCode());
			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int updateDepartInfo(DepartInfo di) throws SQLException {
/*		Connection con = DBCon.getCon();
		String sql = "update diNum,diName,diDesc,diCode from depart_info where diNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, diNum);
			rs = ps.executeQuery();
			DepartInfo di = null;
			if (rs.next()) {
				di = new DepartInfo();
				di.setDiNum(rs.getInt("diNum"));
				di.setDiName(rs.getString("diName"));
				di.setDiDesc(rs.getString("diDesc"));
				di.setDiCode(rs.getString("diCode"));
			}
			return di;

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}*/
		return 0;
	}


	@Override
	public int deleteDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
