package com.annguyen.kyanhbooks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class GioHang {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	
	@Column(name = "SessionId", unique = true)
	private String sessionId;
	
	@Column(name = "MaKH", unique = true)
	private String maKH;
	
	@Column(name = "DienThoai", unique = true)
	private String dienThoai;
	
	@Column(name = "HoTen")
	private String hoTen;
	
	@Column(name = "MaSach")
	private String maSach;
	
	@Column(name = "SoLuong")
	private String soLuong;
	
	@Column(name = "DonGia")
	private String donGia;
	
	public GioHang() {
	}

	public GioHang( String sessionId, String maKH, String dienThoai, String hoTen, String maSach, String soLuong,
			String donGia) {
		this.sessionId = sessionId;
		this.maKH = maKH;
		this.dienThoai = dienThoai;
		this.hoTen = hoTen;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	
}
