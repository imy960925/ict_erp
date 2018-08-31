package com.ict.erp.vo;

public class MusicInfo {
	private Integer mcNum;
	private String mcName;
	private String mcSinger;
	private String mcVendoer;
	private Integer mcLike;
	private Integer mcDisLike;
	private String mcCredat;
	private String mcDesc;
	public MusicInfo() {}
	public MusicInfo(Integer mcNum, String mcName, String mcSinger, String mcVendoer, Integer mcLike, Integer mcDisLike,
			String mcCredat, String mcDesc) {
		super();
		this.mcNum = mcNum;
		this.mcName = mcName;
		this.mcSinger = mcSinger;
		this.mcVendoer = mcVendoer;
		this.mcLike = mcLike;
		this.mcDisLike = mcDisLike;
		this.mcCredat = mcCredat;
		this.mcDesc = mcDesc;
	}
	public Integer getMcNum() {
		return mcNum;
	}
	public void setMcNum(Integer mcNum) {
		this.mcNum = mcNum;
	}
	public String getMcName() {
		return mcName;
	}
	public void setMcName(String mcName) {
		this.mcName = mcName;
	}
	public String getMcSinger() {
		return mcSinger;
	}
	public void setMcSinger(String mcSinger) {
		this.mcSinger = mcSinger;
	}
	public String getMcVendoer() {
		return mcVendoer;
	}
	public void setMcVendoer(String mcVendoer) {
		this.mcVendoer = mcVendoer;
	}
	public Integer getMcLike() {
		return mcLike;
	}
	public void setMcLike(Integer mcLike) {
		this.mcLike = mcLike;
	}
	public Integer getMcDisLike() {
		return mcDisLike;
	}
	public void setMcDisLike(Integer mcDisLike) {
		this.mcDisLike = mcDisLike;
	}
	public String getMcCredat() {
		return mcCredat;
	}
	public void setMcCredat(String mcCredat) {
		this.mcCredat = mcCredat;
	}
	public String getMcDesc() {
		return mcDesc;
	}
	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}
	@Override
	public String toString() {
		return "MusicInfo [mcNum=" + mcNum + ", mcName=" + mcName + ", mcSinger=" + mcSinger + ", mcVendoer="
				+ mcVendoer + ", mcLike=" + mcLike + ", mcDisLike=" + mcDisLike + ", meCredat=" + mcCredat + ", meDesc="
				+ mcDesc + "]";
	}
}
