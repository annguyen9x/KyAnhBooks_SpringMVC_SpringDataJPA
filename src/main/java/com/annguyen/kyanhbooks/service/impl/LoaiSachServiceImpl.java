package com.annguyen.kyanhbooks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.LoaiSach;
import com.annguyen.kyanhbooks.repository.LoaiSachRepository;
import com.annguyen.kyanhbooks.service.LoaiSachService;

@Service
public class LoaiSachServiceImpl  implements LoaiSachService{
	
	@Autowired
	private LoaiSachRepository loaiSachRepository;
	
	@Override
	public boolean insert(LoaiSach ls) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LoaiSach ls) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String maLoaiSach) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoaiSach getLoaiSach(String maLoaiSach) {
		LoaiSach loaiSach = null;
		loaiSach = loaiSachRepository.findLoaiSachByMaLoaiSach(maLoaiSach);
		return loaiSach;
	}

	@Override
	public List<LoaiSach> getDSLoaiSach() {
		List<LoaiSach> loaiSachs = null;
		loaiSachs = loaiSachRepository.findAll();
		return loaiSachs;
	}

}
