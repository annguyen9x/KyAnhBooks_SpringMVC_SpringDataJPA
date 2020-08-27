package com.annguyen.kyanhbooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.repository.GioHangRepository;
import com.annguyen.kyanhbooks.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository gioHangRepository;
	
	@Override
	public GioHang xemGioHang(String sessionIdCookie, int maKH) {
		GioHang gioHang = gioHangRepository.findGioHangBySessionIdOrMaKH(sessionIdCookie, maKH);
		
		return gioHang;
	}

	@Override
	public boolean taoGioHang() {

		//Máy khách (client): Set Session Id to Cookie
//		HttpPost httppost = new HttpPost(postData); 
//		CookieStore cookieStore = new BasicCookieStore(); 
//		BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", getSessionId());
//
//		//cookie.setDomain("your domain");
//		cookie.setPath("/");
//
//		cookieStore.addCookie(cookie); 
//		client.setCookieStore(cookieStore); 
//		response = client.execute(httppost);
		
		//Máy chủ(Server); Check sessionId từ request
		//public static final String JSESSIONID = "JSESSIONID";
//		Cookie[] cs = super.getCookies();
//        List<Cookie> cokRet = new ArrayList<Cookie>(cs.length);
//        for (Cookie c : cs)
//        {
//            if (c.getName().equalsIgnoreCase(JSESSIONID)) {
//            	//Có sessionid từ request
//            }
//        }
		return false;
	}
	
	//Set Cookie từ Client-sau phải dùng ở JSP ?
//	@RequestMapping(value = {"/news"}, method = RequestMethod.GET)
//	public ModelAndView news(Locale locale, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
//
//	    ...
//	    response.setHeader("Set-Cookie", "test=value; Path=/");
//	    ...
//
//	    modelAndView.setViewName("path/to/my/view");
//	    return modelAndView;
//	}
	
	//Get COOKIE Ở Server
//	@RequestMapping("/hello")
//	public String hello(@CookieValue("foo") String fooCookie) {
//	    // ...
//	}

}
