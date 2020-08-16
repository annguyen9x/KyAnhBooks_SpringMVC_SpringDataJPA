package com.annguyen.kyanhbooks.service;

import java.util.List;

import com.annguyen.kyanhbooks.model.LoaiSach;


public interface LoaiSachService {
	
	boolean insert(LoaiSach ls);
	
	boolean update(LoaiSach ls);
	
	boolean delete(String maLoaiSach);
	
	LoaiSach getLoaiSach(String maLS);
	
	List<LoaiSach> getDSLoaiSach();
}
