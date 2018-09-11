package com.ict.erp.vo;

public class TicketMovieInfo {
private int tmNum;
private String tmName;
private int tmPrice;
private String tmStartdat;
private String tmEnddat;
private String tmCredat;
private String tmDesc;
private int tmCnt;
private String tmImg;

public TicketMovieInfo(){}
public TicketMovieInfo(int tmNum, String tmName, int tmPrice, String tmStartdat, String tmEnddat, String tmCredat,
		String tmDesc, int tmCnt, String tmImg) {
	super();
	this.tmNum = tmNum;
	this.tmName = tmName;
	this.tmPrice = tmPrice;
	this.tmStartdat = tmStartdat;
	this.tmEnddat = tmEnddat;
	this.tmCredat = tmCredat;
	this.tmDesc = tmDesc;
	this.tmCnt = tmCnt;
	this.tmImg = tmImg;
}

public int getTmNum() {
	return tmNum;
}
public void setTmNum(int tmNum) {
	this.tmNum = tmNum;
}
public String getTmName() {
	return tmName;
}
public void setTmName(String tmName) {
	this.tmName = tmName;
}
public int getTmPrice() {
	return tmPrice;
}
public void setTmPrice(int tmPrice) {
	this.tmPrice = tmPrice;
}
public String getTmStartdat() {
	return tmStartdat;
}
public void setTmStartdat(String tmStartdat) {
	this.tmStartdat = tmStartdat;
}
public String getTmEnddat() {
	return tmEnddat;
}
public void setTmEnddat(String tmEnddat) {
	this.tmEnddat = tmEnddat;
}
public String getTmCredat() {
	return tmCredat;
}
public void setTmCredat(String tmCredat) {
	this.tmCredat = tmCredat;
}
public String getTmDesc() {
	return tmDesc;
}
public void setTmDesc(String tmDesc) {
	this.tmDesc = tmDesc;
}
public int getTmCnt() {
	return tmCnt;
}
public void setTmCnt(int tmCnt) {
	this.tmCnt = tmCnt;
}
public String getTmImg() {
	return tmImg;
}
public void setTmImg(String tmImg) {
	this.tmImg = tmImg;
}
@Override
public String toString() {
	return "TicketMovieInfo [tmNum=" + tmNum + ", tmName=" + tmName + ", tmPrice=" + tmPrice + ", tmStartdat="
			+ tmStartdat + ", tmEnddat=" + tmEnddat + ", tmCredat=" + tmCredat + ", tmDesc=" + tmDesc + ", tmCnt="
			+ tmCnt + ", tmImg=" + tmImg + "]";
}
}
