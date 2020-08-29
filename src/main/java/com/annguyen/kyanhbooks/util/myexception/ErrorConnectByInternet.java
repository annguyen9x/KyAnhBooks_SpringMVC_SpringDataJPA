package com.annguyen.kyanhbooks.util.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE , reason = "Lỗi kết nối internet")
public class ErrorConnectByInternet extends Exception {
	
	public ErrorConnectByInternet(String msg) {
		super(msg);
	}
}
