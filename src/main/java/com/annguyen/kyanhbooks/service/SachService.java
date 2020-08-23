package com.annguyen.kyanhbooks.service;

import java.util.List;
import java.util.Map;

import com.annguyen.kyanhbooks.model.Sach;

public interface SachService {
	
	boolean insert(Sach sach);
	
	boolean update(Sach sach);
	
	boolean updateSoLuong(int soLuong, String maSach);
	
	boolean delete(String maSach);
	
	Sach getSachTheoMaSach(String maSach);
	
	List<Sach> dsSach();
	
	List<Sach> dsSachTheoLoaiDs(int soLuong, String loaiDsSach);
	
	List<Sach> dsSachTheoLoaiSach(String maLoaiSach);
	
	List<Sach> dsSachTheoTenSach(String tenSach);
	
	List<Sach> timKiemSach(String tenSach);
}
