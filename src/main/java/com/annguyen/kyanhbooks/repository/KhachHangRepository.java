package com.annguyen.kyanhbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annguyen.kyanhbooks.model.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
	
	KhachHang findKhachHangByEmail(String email);
	
	KhachHang findKhachHangByDienThoai(String dienThoai);
	
	@Query(nativeQuery = true, value = "Select "
			+ "HoaDon.SoHD, TongTien, NgayDat, NgayGiao, TinhTrangDH, MaNVGiao, "
			+ "HoaDon.TenNN, HoaDon.DienThoaiNN, HoaDon.DiaChiNN, HoaDon.MaKH, "
			+ "KhachHang.TenKH, KhachHang.Email, KhachHang.DienThoai, KhachHang.DiaChi "
			+ "From HoaDon Inner Join KhachHang "
			+ "On HoaDon.MaKH = KhachHang.MaKH "
			+ "Where HoaDon.MaKH= ? ")
	List<Object[]> findHoaDonAndKhachHangByMaKH(int maKH);
}
