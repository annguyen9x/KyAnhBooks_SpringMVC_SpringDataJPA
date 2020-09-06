package com.annguyen.kyanhbooks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.domain.Persistable;

@Entity
public class GioHang{
	
	@Id
	@Column(name = "SessionIdGH")
	//SessionId lưu SDT làm ID Giỏ hàng
	private String sessionIdGH;
	
	@Column(name = "MaKH")
	private int maKH;
	
	@Column(name = "TenKH", nullable = false)
	private String tenKH;
	
	@Column(name = "DienThoai", unique = true, nullable = false)
	private String dienThoai;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
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
	
	public GioHang(String sessionIdGH, int maKH, String tenKH, String dienThoai, Date ngayTao) {
		this.sessionIdGH = sessionIdGH;
		this.maKH = maKH;
		this.dienThoai = dienThoai;
		this.tenKH = tenKH;
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
