package com.annguyen.kyanhbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annguyen.kyanhbooks.model.LoaiSach;

public interface LoaiSachRepository extends JpaRepository<LoaiSach, String> {
	
	LoaiSach findLoaiSachByMaLoaiSach(String maLoaiSach);
	
}
