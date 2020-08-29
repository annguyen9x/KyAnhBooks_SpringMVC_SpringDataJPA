package com.annguyen.kyanhbooks.util.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Không tìm thấy")
public class NotFoundException extends Exception {
	
	public NotFoundException(String msg) {
		super(msg);
	}
}
