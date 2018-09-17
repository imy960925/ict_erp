package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.TicketMovieInfo;

public interface TicketMovieService {
	public List<TicketMovieInfo> selectMiList(TicketMovieInfo tmi) throws SQLException;
	public TicketMovieInfo selectMi(TicketMovieInfo tmi) throws SQLException;
	public Map<String,Object>insertMi(TicketMovieInfo tmi) throws SQLException;
	public Map<String,Object>updateMi(TicketMovieInfo tmi) throws SQLException;
	public Map<String,Object>deleteMi(TicketMovieInfo tmi) throws SQLException;
}
