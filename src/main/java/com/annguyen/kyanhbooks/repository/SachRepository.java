package com.annguyen.kyanhbooks.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annguyen.kyanhbooks.model.Sach;

public interface SachRepository extends JpaRepository<Sach, String> {
	
	@Query(nativeQuery = true, value = "SELECT maSach, tenSach, donGia, soLuong, urlHinh, noiDung, tacGia, namXB, nXB, maLoaiSach "
			+ "FROM sach "
			+ "ORDER BY namXB DESC "
			+ "LIMIT 0, ?")
	List<Sach> dsSachMoiTrangChu(int soLuong);
	
	@Query(nativeQuery = true, value = "SELECT maSach, tenSach, donGia, soLuong, urlHinh, noiDung, tacGia, namXB, nXB, maLoaiSach "
			+ "FROM sach "
			+ "ORDER BY donGia DESC "
			+ "LIMIT 0, ?")
	List<Sach> dsSachNoiBatTrangChu(int soLuong);
	
	@Query(nativeQuery = true, value = "SELECT maSach, tenSach, donGia, soLuong, urlHinh, noiDung, tacGia, namXB, nXB, maLoaiSach "
			+ "FROM sach "
			+ "WHERE maLoaiSach = ? "
			+ "ORDER BY donGia DESC "
			+ "LIMIT 0, ?")
	List<Sach> dsSachTheoMaLoaiSach(String maSach, int soLuong);
	
	Long countSachByMaLoaiSach(String maLoaiSach);
	
	List<Sach> findSachByMaLoaiSach(String maLoaiSach, Pageable pageable);
	
	Sach findSachByMaSach(String maSach);
}
