package com.annguyen.kyanhbooks.iterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.annguyen.kyanhbooks.service.LoaiSachService;

public class MenuHandle implements HandlerInterceptor {
	
	@Autowired
	private LoaiSachService loaiSachService;
	
	//Trước khi request gửi đến các controller "../MenuLoaiSach/" (cấu hình ở dispatcher-servlet.xml) sẽ vào đây
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//Load menu LoaiSach để hiển thị trước khi đi đến các controller có URL "/KyAnhBooks/MeNuDoc/"
		request.setAttribute("menuLoaiSach", loaiSachService.getDSLoaiSach());
		System.out.println("MenuHandle-preHandle-Load Menu LoaiSach");
		
		return true;
	}

	//Trước khi response được Controller "../MenuLoaiSach/" (cấu hình ở dispatcher-servlet.xml) trả về cho view sẽ vào đây
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	//Sau khi response được Controller "../MenuLoaiSach/" (cấu hình ở dispatcher-servlet.xml) trả về cho view sẽ vào đây
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
