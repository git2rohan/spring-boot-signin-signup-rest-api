package com.example.demo.common;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {

	public LocalDateTime get_IST_TimeNow()
	{
		LocalDateTime now = LocalDateTime.now();
		now.plusHours(5);
		now.plusMinutes(30);
		return now;
	}
	
}
