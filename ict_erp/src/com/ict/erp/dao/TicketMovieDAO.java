package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicInfo;
import com.ict.erp.vo.TicketMovieInfo;

public interface TicketMovieDAO extends Common {
	public List<TicketMovieInfo> selectMiList(TicketMovieInfo tmi) throws SQLException;
	public TicketMovieInfo selectMi(TicketMovieInfo tmi) throws SQLException;
	public int insertMi(TicketMovieInfo tmi) throws SQLException;
	public int updateMi(int i);
	public int deleteMi(TicketMovieInfo tmi) throws SQLException;
}
