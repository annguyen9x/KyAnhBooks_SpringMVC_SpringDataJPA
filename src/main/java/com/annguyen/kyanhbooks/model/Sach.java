package com.annguyen.kyanhbooks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sach")
public class Sach {
	
	@Id
	@Column(name = "MaSach")
	private String maSach;
	
	@Column(name = "TenSach")
	private String tenSach;
	
	@Column(name = "DonGia")
	private float donGia;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name = "UrlHinh")
	private String urlHinh;
	
	@Column(name = "NoiDung")
	private String noiDung;
	
	@Column(name = "TacGia")
	private String tacGia;
	
	@Column(name = "NamXB")
	private int namXB;
	
	@Column(name = "NXB")
	private String nXB;
	
	@Column(name = "MaLoaiSach")
	private String maLoaiSach;
	
	public Sach() {
		
	}
	
	public Sach(String maSach, String tenSach, float donGia, String urlHinh,
			String noiDung, String tacGia, int namXB, String nXB, String maLoaiSach) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.urlHinh = urlHinh;
		this.noiDung = noiDung;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.nXB = nXB;
		this.maLoaiSach = maLoaiSach;
	}
	
	public Sach(String maSach, String tenSach, float donGia, int soLuong, String urlHinh,
			String noiDung, String tacGia, int namXB, String nXB, String maLoaiSach) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.urlHinh = urlHinh;
		this.noiDung = noiDung;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.nXB = nXB;
		this.maLoaiSach = maLoaiSach;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getUrlHinh() {
		return urlHinh;
	}

	public void setUrlHinh(String urlHinh) {
		this.urlHinh = urlHinh;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public String getnXB() {
		return nXB;
	}

	public void setnXB(String nXB) {
		this.nXB = nXB;
	}

	public String getMaLoaiSach() {
		return maLoaiSach;
	}

	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
}
