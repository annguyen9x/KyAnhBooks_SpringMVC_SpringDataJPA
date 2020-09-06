package com.annguyen.kyanhbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annguyen.kyanhbooks.model.ChiTietGioHang;
import com.annguyen.kyanhbooks.model.ChiTietGioHangPrimaryKey;

public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, ChiTietGioHangPrimaryKey> {
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "chitietgiohang.MaSach, chitietgiohang.DonGia, chitietgiohang.SoLuong, "
			+ "sach.TenSach, sach.UrlHinh "
			+ "FROM chitietgiohang "
			+ "INNER JOIN giohang "
			+ "ON giohang.SessionIdGH = chitietgiohang.SessionIdGH "
			+ "INNER JOIN sach "
			+ "ON sach.masach = chitietgiohang.masach "
			+ "WHERE chitietgiohang.SessionIdGH = ? "
			+ "ORDER BY chitietgiohang.SoLuong ASC")
	List<Object[]> findChiTietGioHangAndSanPhamsBySessionIdGH(String sessionIdGH);

}
