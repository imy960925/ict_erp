package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MusicInfo;

public interface MusicService {
	public List<MusicInfo> selectMiList(MusicInfo mi) throws SQLException;
	public MusicInfo selectMi(MusicInfo mi) throws SQLException;
	public Map<String,Object>insertMi(MusicInfo mi) throws SQLException;
	public Map<String,Object>updateMi(MusicInfo mi);
	public Map<String,Object>deleteMi(MusicInfo mi);
}
