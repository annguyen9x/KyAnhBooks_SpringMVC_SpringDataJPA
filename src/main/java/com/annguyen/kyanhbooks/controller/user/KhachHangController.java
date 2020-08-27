package com.annguyen.kyanhbooks.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annguyen.kyanhbooks.service.KhachHangService;
import com.annguyen.kyanhbooks.util.Constant;

@Controller
public class KhachHangController {
	
	@Autowired
	private KhachHangService khachHangService;
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGNHAP )
	public String hienThiTrangDangNhap() {
		
		return "";
	}
}
