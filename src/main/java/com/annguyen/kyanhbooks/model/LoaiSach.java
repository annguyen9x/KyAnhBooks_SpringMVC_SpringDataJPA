package com.annguyen.kyanhbooks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaisach")
public class LoaiSach {
	
	@Id
	@Column(name = "MaLoaiSach")
	private String maLoaiSach;
	
	@Column(name = "TenLoaiSach")
	private String tenLoaiSach;
	
	public LoaiSach() {
		
	}
	
	public LoaiSach(String maLoaiSach, String tenLoaiSach) {
		super();
		this.maLoaiSach = maLoaiSach;
		this.tenLoaiSach = tenLoaiSach;
	}
	
	public String getMaLoaiSach() {
		return maLoaiSach;
	}
	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
	public String getTenLoaiSach() {
		return tenLoaiSach;
	}
	public void setTenLoaiSach(String tenLoaiSach) {
		this.tenLoaiSach = tenLoaiSach;
	}
}
