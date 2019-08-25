package com.bitcamp.services;

import com.bitcamp.domains.ScheduleBean;

public class ScheduleService {
	private ScheduleBean[] schedules;
	private int count;
	
	public ScheduleService() {
		schedules = new ScheduleBean[10];
		count = 0;
	}
}
