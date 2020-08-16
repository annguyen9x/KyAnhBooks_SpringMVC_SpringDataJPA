package com.annguyen.kyanhbooks.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.annguyen.kyanhbooks.model.Sach;
import com.annguyen.kyanhbooks.service.SachService;

public class SachController {
	
	@Autowired
	private SachService sachService;
	
	@RequestMapping("/MenuLoaiSach/sachTheoLoaiSach")
	public String sachTheoLoaiSach(@RequestParam("MaLS") String maLoaiSach, Model model) {
		List<Sach> sachs = sachService.dsSachTheoLoaiSach(maLoaiSach);
		model.addAttribute("SachTheoLoaiSach", sachs);
		model.addAttribute("MaLoaiSach", maLoaiSach);
		
		return "sp_cungloai";
	}
}
