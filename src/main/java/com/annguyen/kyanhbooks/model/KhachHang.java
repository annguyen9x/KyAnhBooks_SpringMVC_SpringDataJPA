package com.annguyen.kyanhbooks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaKH")
	private int maKH;
	
	@Column(name = "TenKH")
	private String tenKH;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	@Column(name = "Email", unique = true)
	private String email;
	
	@Column(name = "DienThoai", unique = true)
	private String dienThoai;
	
	@Column(name = "GioiTinh")
	private String gioiTinh;
	
	@Column(name = "NgaySinh")
	private Date ngaySinh;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	public KhachHang() {
		
	}
	
	public KhachHang(String tenKH, String matKhau, String email, String dienThoai, String gioiTinh,
			Date ngaySinh, String diaChi) {
		super();
		this.tenKH = tenKH;
		this.matKhau = matKhau;
		this.email = email;
		this.dienThoai = dienThoai;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	
	public KhachHang(int maKH, String tenKH, String matKhau, String email, String dienThoai, String gioiTinh,
			Date ngaySinh, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.matKhau = matKhau;
		this.email = email;
		this.dienThoai = dienThoai;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
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
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}
