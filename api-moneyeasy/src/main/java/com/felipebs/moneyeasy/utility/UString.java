package com.felipebs.moneyeasy.utility;

import org.springframework.stereotype.Service;

@Service
public class UString {
	
	public String formatStringRepository(String text) {
		if(text == null) return "%%"; 
		return "%" + text + "%";
	}
}
