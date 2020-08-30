package com.annguyen.kyanhbooks.util.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Thông tin đăng ký không đúng")
public class ErrorInformationInCorrect extends Exception {
	
	public ErrorInformationInCorrect(String msg) {
		super(msg);
	}
}
