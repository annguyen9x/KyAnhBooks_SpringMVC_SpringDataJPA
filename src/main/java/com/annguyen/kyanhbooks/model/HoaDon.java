package com.annguyen.kyanhbooks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hoadon")
public class HoaDon {
	
//	@ManyToOne//Nhiều ChiTietHD có thể thuộc một HD
//	@JoinColumn(name = "SoHD")
//	private HoaDon hoaDon;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SoHD")
	private int soHD;
	
	@Column(name = "TongTien")
	private float tongTien;
	
	@Column(name = "NgayDat")
	private Date ngayDat;
	
	@Column(name = "NgayGiao")
	private Date ngayGiao;
	
	@Column(name = "TinhTrangDH")
	private String tinhTrangDH;
	
	@Column(name = "MaNVGiao")
	private int maNVGiao;
	
	@Column(name = "TenNN")
	private String tenNN;
	
	@Column(name = "DienThoaiNN")
	private String dienThoaiNN;
	
	@Column(name = "DiaChiNN")
	private String diaChiNN;
	
	@Column(name = "MaKH")
	private int maKH;

	public HoaDon() {
	}
	
	public HoaDon( Date ngayDat, String tinhTrangDH, int maKH) {
		super();
		this.ngayDat = ngayDat;
		this.tinhTrangDH = tinhTrangDH;
		this.maKH = maKH;
	}
	
	public HoaDon( float tongTien, Date ngayDat, String tinhTrangDH, int maKH, String tenNN, String dienThoaiNN, String diaChiNN) {
		super();
		this.tongTien = tongTien;
		this.ngayDat = ngayDat;
		this.tinhTrangDH = tinhTrangDH;
		this.tenNN = tenNN;
		this.dienThoaiNN = dienThoaiNN;
		this.diaChiNN = diaChiNN;
		this.maKH = maKH;
	}
	
	public HoaDon(int soHD, float tongTien, Date ngayDat, Date ngayGiao, String tinhTrangDH, int maNVGiao, int maKH, String tenNN, 
			String dienThoaiNN, String diaChiNN) {
		super();
		this.soHD = soHD;
		this.tongTien = tongTien;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.tinhTrangDH = tinhTrangDH;
		this.maNVGiao = maNVGiao;
		this.tenNN = tenNN;
		this.dienThoaiNN = dienThoaiNN;
		this.diaChiNN = diaChiNN;
		this.maKH = maKH;
	}

	public int getSoHD() {
		return soHD;
	}

	public void setSoHD(int soHD) {
		this.soHD = soHD;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public String getTinhTrangDH() {
		return tinhTrangDH;
	}

	public void setTinhTrangDH(String tinhTrangDH) {
		this.tinhTrangDH = tinhTrangDH;
	}

	public int getMaNVGiao() {
		return maNVGiao;
	}

	public void setMaNVGiao(int maNVGiao) {
		this.maNVGiao = maNVGiao;
	}
	
	public String getTenNN() {
		return tenNN;
	}

	public void setTenNN(String tenNN) {
		this.tenNN = tenNN;
	}

	public String getDienThoaiNN() {
		return dienThoaiNN;
	}

	public void setDienThoaiNN(String dienThoaiNN) {
		this.dienThoaiNN = dienThoaiNN;
	}

	public String getDiaChiNN() {
		return diaChiNN;
	}

	public void setDiaChiNN(String diaChiNN) {
		this.diaChiNN = diaChiNN;
	}
	
	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

}
