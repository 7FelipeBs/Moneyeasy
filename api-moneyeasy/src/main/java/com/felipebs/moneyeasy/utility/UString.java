package com.felipebs.moneyeasy.utility;

public class UString {
	
	public String formatStringRepository(String text) {
		if(text == null) return "%%"; 
		return "%" + text + "%";
	}
}
