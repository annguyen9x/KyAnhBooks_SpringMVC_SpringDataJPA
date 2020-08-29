package com.annguyen.kyanhbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annguyen.kyanhbooks.model.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
	
	KhachHang findKhachHangByEmail(String email);
}
