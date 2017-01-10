package net.vsona.common.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

public class DateUtils {

	private static final FastDateFormat YYYY_MM_DD_HH_MM_SS = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	private static final FastDateFormat YYYY_MM_DD_HH_MM = FastDateFormat.getInstance("yyyy-MM-dd HH:mm");
	private static final FastDateFormat MM_DD_HH_MM = FastDateFormat.getInstance("MM-dd HH:mm");
	private static final FastDateFormat HH_MM = FastDateFormat.getInstance("HH:mm");
	private static final FastDateFormat HH_MM_SS = FastDateFormat.getInstance("HH:mm:ss");
	private static final FastDateFormat YYYY_MM_DD = FastDateFormat.getInstance("yyyy-MM-dd");
	private static final FastDateFormat MM_DD = FastDateFormat.getInstance("MM-dd");
	private static final FastDateFormat yyyy年MM月dd日 = FastDateFormat.getInstance("yyyy年MM月dd日");

	private static final long MILLIS_IN_ONE_MINUTE = 1000 * 60;
	private static final long MILLIS_IN_ONE_HOUR = MILLIS_IN_ONE_MINUTE * 60;
	private static final long MILLIS_IN_ONE_DAY = MILLIS_IN_ONE_HOUR * 24;
	private static final long MILLIS_IN_THIRTY_DAY = MILLIS_IN_ONE_DAY * 30;

	public static String convert2yyyy_MM_dd_HH_mm_ss(long dateMillionSeconds) {
		Date dateTime = new Date(dateMillionSeconds);
		FastDateFormat formatter = YYYY_MM_DD_HH_MM_SS;
		return formatter.format(dateTime);
	}

	public static String convert2yyyy_MM_dd_HH_mm(long dateMillionSeconds) {
		Date dateTime = new Date(dateMillionSeconds);
		FastDateFormat formatter = YYYY_MM_DD_HH_MM;
		return formatter.format(dateTime);
	}

	public static String convert2yyyy_MM_dd(long dateMillionSeconds) {
		Date dateTime = new Date(dateMillionSeconds);
		FastDateFormat formatter = YYYY_MM_DD;
		return formatter.format(dateTime);
	}

	public static String convert2yyyy_MM_dd_china(long dateMillionSeconds) {
		Date dateTime = new Date(dateMillionSeconds);
		FastDateFormat formatter = yyyy年MM月dd日;
		return formatter.format(dateTime);
	}

}
