package ru.mytoffnax.services.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public String formatUnixTime(long unixTime) {
		long timestamp = unixTime * 1000l; 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return dateFormat.format(new Date(timestamp));
	}
	
}
