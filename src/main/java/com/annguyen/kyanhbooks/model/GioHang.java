package com.annguyen.kyanhbooks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GioHang {
	
	@Id
	@Column(name = "SessionIdGH")
	//SessionId lưu SDT làm ID Giỏ hàng
	private String sessionIdGH;
	
	@Column(name = "MaKH", unique = true)
	private int maKH;
	
	@Column(name = "TenKH", nullable = false)
	private String tenKH;
	
	@Column(name = "DienThoai", unique = true, nullable = false)
	private String dienThoai;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "MaSach")
	private String maSach;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name = "DonGia")
	private float donGia;
	
	@Column(name = "SoHD")
	private int soHD;
	
	@Column(name = "NgayTao")
	private Date ngayTao;
	
	@Column(name = "NgayCapNhat")
	private Date ngayCapNhat;
	
	@Column(name = "DaXoa")
	private boolean daXoa;
	
	public GioHang() {
	}
	
	public GioHang(String maSach, int soLuong, float donGia) {
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	public GioHang(String sessionIdGH, int maKH, String tenKH, String dienThoai, String maSach,
			int soLuong, float donGia, Date ngayTao) {
		this.sessionIdGH = sessionIdGH;
		this.maKH = maKH;
		this.dienThoai = dienThoai;
		this.tenKH = tenKH;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngayTao = ngayTao;
	}
	
	public String getSessionIdGH() {
		return sessionIdGH;
	}

	public void setSessionIdGH(String sessionIdGH) {
		this.sessionIdGH = sessionIdGH;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
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

	public int getSoHD() {
		return soHD;
	}

	public void setSoHD(int soHD) {
		this.soHD = soHD;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public boolean isDaXoa() {
		return daXoa;
	}

	public void setDaXoa(boolean daXoa) {
		this.daXoa = daXoa;
	}
	
}
