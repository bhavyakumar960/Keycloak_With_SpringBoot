package com.learn.keycloak.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

	public static String getFormattedDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date);
	    String formattedDate = localDate.format(formatter);
	    return formattedDate;
	}
	
}