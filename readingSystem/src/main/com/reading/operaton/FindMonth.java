package com.reading.operaton;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class FindMonth {
	LocalDate joinDate;

	public int getMonth(String date) {
		int dd = Integer.parseInt(date.substring(0, 2));
		int mm = Integer.parseInt(date.substring(3, 5));
		int yy = Integer.parseInt(date.substring(6, 10));

		switch (mm) {
		case 1:
			joinDate = LocalDate.of(yy, Month.JANUARY, dd);
			break;
		case 2:
			joinDate = LocalDate.of(yy, Month.FEBRUARY, dd);
			break;
		case 3:
			joinDate = LocalDate.of(yy, Month.MARCH, dd);
			break;
		case 4:
			joinDate = LocalDate.of(yy, Month.APRIL, dd);
			break;
		case 5:
			joinDate = LocalDate.of(yy, Month.MAY, dd);
			break;
		case 6:
			joinDate = LocalDate.of(yy, Month.JUNE, dd);
			break;
		case 7:
			joinDate = LocalDate.of(yy, Month.JULY, dd);
			break;
		case 8:
			joinDate = LocalDate.of(yy, Month.AUGUST, dd);
			break;
		case 9:
			joinDate = LocalDate.of(yy, Month.SEPTEMBER, dd);
			break;
		case 10:
			joinDate = LocalDate.of(yy, Month.OCTOBER, dd);
			break;
		case 11:
			joinDate = LocalDate.of(yy, Month.NOVEMBER, dd);
			break;
		case 12:
			joinDate = LocalDate.of(yy, Month.DECEMBER, dd);
			break;
		default:
		}
		LocalDate today = LocalDate.now();

		Period age = Period.between(joinDate, today);
		int years = age.getYears();
		int months = age.getMonths();
		int yearToMonth = (years * 12) + months;

		return yearToMonth;
	}

//	public static void main(String args[]) {
//		FindMonth f= new FindMonth();
//		System.out.println(f.from("26-11-2018"));
//	}
}
