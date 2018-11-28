package com.qa.problemstatement2;

import java.util.Date;

public class DateOverlapping {

	public static boolean isOverlapDates(Date aStart, Date aEnd, Date bStart, Date bEnd) {

		if ((aStart >= bEnd && aStart >= bStart) || (aEnd < bEnd && aEnd <= bStart)
	 {
			return false;
		} else {
			return true;
		}
	}

}
