package com.prezrohit.sectionedrecyclerview.util;

import java.util.Date;
import java.util.HashMap;

public class DateTimeUtil {
	public static final HashMap<Integer, String> MONTH_NAME_MAP = new HashMap<>();

	private static void populateMap() {
		MONTH_NAME_MAP.put(0, "Jan");
		MONTH_NAME_MAP.put(1, "Feb");
		MONTH_NAME_MAP.put(2, "Mar");
		MONTH_NAME_MAP.put(3, "Apr");
		MONTH_NAME_MAP.put(4, "May");
		MONTH_NAME_MAP.put(5, "Jun");
		MONTH_NAME_MAP.put(6, "Jul");
		MONTH_NAME_MAP.put(7, "Aug");
		MONTH_NAME_MAP.put(8, "Sept");
		MONTH_NAME_MAP.put(9, "Oct");
		MONTH_NAME_MAP.put(10, "Nov");
		MONTH_NAME_MAP.put(11, "Dec");
	}

	private static String getMonthName(int month) {
		if (MONTH_NAME_MAP.size() == 0)
			populateMap();
		return MONTH_NAME_MAP.get(month);
	}

	private static String getDate(int day) {
		if (day < 10) return "0" + day;
		else return String.valueOf(day);
	}

	public static String getDate(Date date) {
		return getDate(date.getDate()) + "-" + getMonthName(date.getMonth()) + "-" + (date.getYear() + 1900);
	}
}
