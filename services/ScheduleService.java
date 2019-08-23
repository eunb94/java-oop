package com.bitcamp.services;
import javax.swing.JOptionPane;
import com.bitcamp.domains.ScheduleBean;

public class ScheduleService {
	private ScheduleBean[] schedules;
	private int month, year;
	
	public ScheduleService() {
		schedules = new ScheduleBean[10];
		month = 0;
		year = 0;
	}
}