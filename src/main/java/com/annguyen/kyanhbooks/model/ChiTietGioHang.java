package com.annguyen.kyanhbooks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ChiTietGioHangPrimaryKey.class)
public class ChiTietGioHang {
	
	@Id
	private String maSach;
	
	@Id
	private String sessionIdGH;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name = "DonGia")
	private float donGia;

	public ChiTietGioHang() {
	}

	public ChiTietGioHang(String maSach, String sessionIdGH, int soLuong, float donGia) {
		this.maSach = maSach;
		this.sessionIdGH = sessionIdGH;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getSessionIdGH() {
		return sessionIdGH;
	}

	public void setSessionIdGH(String sessionIdGH) {
		this.sessionIdGH = sessionIdGH;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
}
