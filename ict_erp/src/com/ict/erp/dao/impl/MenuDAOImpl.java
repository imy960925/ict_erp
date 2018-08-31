package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MenuDAO;
import com.ict.erp.vo.MenuInfo;

public class MenuDAOImpl extends CommonDAOImpl implements MenuDAO {

	@Override
	public List<MenuInfo> selectMenuList(MenuInfo menu) throws SQLException {
		String sql = "select * from menu_info";
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuInfo mi = new MenuInfo(rs.getLong("meiNum"), rs.getString("meiName"), rs.getLong("meiPrice"),
						rs.getString("meiDesc"));
				menuList.add(mi);
			}
			return menuList;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	public static void main(String[] args) {
		MenuDAO mdao = new MenuDAOImpl();

		try {
			mdao.setConnection(DBCon.getCon());
			MenuInfo menu = new MenuInfo();
			menu.setMeiNum(10l);

			//System.out.println(mdao.insertMenu(menu));
			DBCon.commit();

			System.out.println(mdao.selectMenuList(null));
			
//			menu.setMeiNum(9l);
//			menu.setMeiName("파스타");
//			menu.setMeiPrice(15000l);
//			menu.setMeiDesc("맛있음");
//			System.out.println(mdao.deleteMenu(menu));
//			System.out.println(mdao.selectMenu(menu));
			
/*			menu.setMeiNum(8l);
			menu.setMeiName("피자");
			menu.setMeiPrice(16000l);
			menu.setMeiDesc("맛있음");
			
			System.out.println(mdao.updateMenu(menu));
*/
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCon.commit();
			DBCon.close();
		}

	}

	@Override
	public MenuInfo selectMenu(MenuInfo menu) throws SQLException {
		String sql = "select * from menu_info where meiNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, menu.getMeiNum());
			rs = ps.executeQuery();
			while (rs.next()) {
				return new MenuInfo(rs.getLong("meiNum"), rs.getString("meiName"), rs.getLong("meiPrice"),
						rs.getString("meiDesc"));

			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

		return null;
	}

	@Override
	public int insertMenu(MenuInfo menu) throws SQLException {
		String sql = "insert into menu_info (meiNum,meiName,meiPrice,meiDesc)";
		sql += " values(seq_meiNum.nextval,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu.getMeiName());
			ps.setLong(2, menu.getMeiPrice());
			ps.setString(3, menu.getMeiDesc());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int updateMenu(MenuInfo menu) throws SQLException {
		String sql = "update menu_info";
		sql += " set meiName=?,";
		sql += "  meiPrice=?,";
		sql += "  meiDesc=?";
		sql += " where meiNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu.getMeiName());
			ps.setLong(2, menu.getMeiPrice());
			ps.setString(3, menu.getMeiDesc());
			ps.setLong(4, menu.getMeiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int deleteMenu(MenuInfo menu) throws SQLException {
		String sql = "delete from menu_info where MeiNum=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, menu.getMeiNum());
			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;

		} finally {
			close();
		}

		
	}

}
