package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MusicInfo;

public interface MusicDAO extends Common {
	public List<MusicInfo> selectMiList(MusicInfo mi) throws SQLException;
	public MusicInfo selectMi(MusicInfo mi) throws SQLException;
	public int insertMi(MusicInfo mi) throws SQLException;
	public int updateMi(MusicInfo mi);
	public int deleteMi(MusicInfo mi) throws SQLException;
}
