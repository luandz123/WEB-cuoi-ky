package LPH.StoreManagement.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
	private Util() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus) {
		return new ResponseEntity<String> ("{\"message\":\""+responseMessage+"\"}",httpStatus);
	}
}

