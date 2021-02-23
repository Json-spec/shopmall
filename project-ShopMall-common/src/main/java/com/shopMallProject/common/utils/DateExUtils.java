/*
 * 项目名：	dataExchange
 * 文件名：	DateExUtils.java 
 * 创建时间：12/19/16 09:23
 * 创建者：  Ye.Lu
 *
 * 版权所有(C)，上海华腾软件系统有限公司，2016，所有权利保留。
 */
package com.shopMallProject.common.utils;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期工具类.
 *
 * @version：12/19/16 09:23
 * 
 * @author：Ye.Lu
 */
public class DateExUtils extends DateUtils {

	private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

	/** 格式：yyyy-MM-dd */
	public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
	/** 格式：yyyy-MM-dd HH:mm */
	public static final String DATE_FORMAT_MEDIUM = "yyyy-MM-dd HH:mm";
	/** 格式：yyyyMM */
	public static final String DATE_FORMAT_YEAR_MONTH = "yyyyMM";
	/** 格式：yyyyMMdd */
	public static final String DATE_FORMAT_YEAR_MONTH_DAY = "yyyyMMdd";
	/** 格式：yyyy/MM/dd */
	public static final String DATE_FORMAT_SLASH = "yyyy/MM/dd";
	/** 格式：yyyy-MM-dd HH:mm:ss */
	public static final String DATE_FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
	/** 格式：yyyy-MM-dd HH:mm:ss.SSS */
	public static final String DATE_FORMAT_LONG_MILLISECOND = "yyyy-MM-dd HH:mm:ss.SSS";
	/** 格式：yyyyMMddHHmmss */
	public static final String DATE_FORMAT_LONG_COMPACT = "yyyyMMddHHmmss";
	/** 格式：EEE, d MMM yyyy HH:mm:ss Z */
	public static final String DATE_FORMAT_LONG_RFC_822 = "EEE, d MMM yyyy HH:mm:ss Z";
	/** 格式：yyyyMMdd HH:mm:ss */
	public static final String DATE_FORMAT_LONG_CUPS_DATE = "yyyyMMdd HH:mm:ss";
	/** 格式：EEE, dd-MMM-yyyy HH:mm:ss 'GMT' */
	public static final String DATE_FORMAT_LONG_COOKIE = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
	/** 格式：yyyy/MM/dd HH:mm:ss */
	public static final String DATE_FORMAT_LONG_SLASH = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 格式："yyyy-MM", "yyyyMM", "yyyy/MM", "yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd",
	 * "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss"
	 */
	public static final String[] DATE_FORMAT_ARRAY = { "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyyMMdd", "yyyy-MM-dd",
			"yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss" };

	public static String now() {
		return now(DATE_FORMAT_LONG);
	}

	public static String now(String dateFormat) {
		DateFormat DF = new SimpleDateFormat(dateFormat);
		Calendar cal = Calendar.getInstance();
		return DF.format(cal.getTime());
	}

	public static Date parseDateDefault(String dateString) {
		try {
			return (new SimpleDateFormat(DATE_FORMAT_DEFAULT)).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateMedium(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_MEDIUM).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateLong(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_LONG).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateLongCompact(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_LONG_COMPACT).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateYearMonth(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateYearMonthDay(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateRFC_822(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_LONG_RFC_822).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	public static Date parseDateCupsDate(String dateString) {
		try {
			return new SimpleDateFormat(DATE_FORMAT_LONG_CUPS_DATE).parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	/**
	 * Parse date string and return date object, default format is: yyyy-mm-dd
	 *
	 * @param dateString
	 * @return
	 */
	public static Date parseDateAuto(String dateString) {
		if (null == dateString || "".equals(dateString.trim())) {
			return null;
		} else {
			try {
				return new SimpleDateFormat(DATE_FORMAT_SLASH).parse(dateString);
			} catch (ParseException e_slash) {
				try {
					return new SimpleDateFormat(DATE_FORMAT_LONG_SLASH).parse(dateString);
				} catch (ParseException e_long_slash) {
					try {
						return new SimpleDateFormat(DATE_FORMAT_LONG_CUPS_DATE).parse(dateString);
					} catch (ParseException e0) {
						try {
							return new SimpleDateFormat(DATE_FORMAT_LONG).parse(dateString);
						} catch (ParseException e1) {
							try {
								return new SimpleDateFormat(DATE_FORMAT_LONG_COMPACT).parse(dateString);
							} catch (ParseException e2) {
								try {
									return new SimpleDateFormat(DATE_FORMAT_MEDIUM).parse(dateString);
								} catch (ParseException e3) {
									try {
										return new SimpleDateFormat(DATE_FORMAT_DEFAULT).parse(dateString);
									} catch (ParseException e4) {
										try {
											return new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH).parse(dateString);
										} catch (ParseException e5) {
											try {
												return new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY)
														.parse(dateString);
											} catch (ParseException e6) {
												try {
													return new SimpleDateFormat(DATE_FORMAT_LONG_RFC_822)
															.parse(dateString);
												} catch (ParseException e7) {
													if (log.isWarnEnabled()) {
														log.warn(MessageFormat.format(
																"Auto parse date String \"{0}\" failed.", dateString),
																e7);
													}
													return null;
												}

											}

										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 日期格式化为 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateDefault(Date date) {
		return formatDate(date, DATE_FORMAT_DEFAULT);
	}

	/**
	 * 日期格式化为 yyyy-MM-dd HH:mm
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateMedium(Date date) {
		return formatDate(date, DATE_FORMAT_MEDIUM);
	}

	/**
	 * 日期格式化为 yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateLong(Date date) {
		return formatDate(date, DATE_FORMAT_LONG);
	}

	/**
	 * 日期格式化为 yyyyMMddHHmmss
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateLongCompact(Date date) {
		return formatDate(date, DATE_FORMAT_LONG_COMPACT);
	}

	/**
	 * 日期格式化为 yyyyMMdd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateCupsDate(Date date) {
		return formatDate(date, DATE_FORMAT_LONG_CUPS_DATE);
	}

	/**
	 * 日期格式化为 EEE, d MMM yyyy HH:mm:ss Z
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateRFC822(Date date) {
		return formatDate(date, DATE_FORMAT_LONG_RFC_822);
	}

	/**
	 * 日期格式化为 yyyyMM
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateMonthYear(Date date) {
		return formatDate(date, DATE_FORMAT_YEAR_MONTH);
	}

	/**
	 * 日期格式化为 yyyyMMdd
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateMonthYearDAY(Date date) {
		return formatDate(date, DATE_FORMAT_YEAR_MONTH_DAY);
	}

	public static String formatDate4Cookie(int seconds) {
		Calendar calendar = Calendar.getInstance(new SimpleTimeZone(0, "GMT"));
		calendar.add(Calendar.SECOND, seconds);

		DateFormat df = new SimpleDateFormat(DATE_FORMAT_LONG_COOKIE);
		df.setCalendar(calendar);
		return df.format(calendar.getTime());
	}

	/**
	 * 日期字符串转日期
	 *
	 * @param dateFormat
	 * @param dateString
	 * @return
	 */
	public static Date parseDate(DateFormat dateFormat, String dateString) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" failed.", dateString), e);
			}
			return null;
		}
	}

	/**
	 * 日期字符串转日期
	 *
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Date parseDate(String dateString, String format) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse date String \"{0}\" to \"{1}\" failed.", dateString, format), e);
			}
			return null;
		}
	}

	/**
	 * 日期转日期字符串
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return null;
		}
		if (null == format || "".equals(format)) {
			return (new SimpleDateFormat(DATE_FORMAT_DEFAULT)).format(date);
		}
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * return the time difference in milliseconds, which is: d1-d2
	 *
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long subtract(Date d1, Date d2) {
		return d1.getTime() - d2.getTime();
	}

	/**
	 * String 转Timestamp
	 *
	 * <pre>
	 * String的类型必须形如： yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错.
	 * </pre>
	 *
	 * @param dateStr
	 * @return
	 */
	public static Timestamp convertStringToTimestamp(String dateStr) {

		try {
			return Timestamp.valueOf(dateStr);
		} catch (Exception e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse String \"{0}\" to Timestamp failed.", dateStr), e);
			}
		}
		return null;
	}

	/**
	 * Timestamp 按格式显示
	 *
	 * @param ts
	 * @param patten
	 * @return
	 */
	public static String conventTimestampToString(Timestamp ts, String patten) {
		String tsStr = "";
		if (ts != null) {
			DateFormat sdf = new SimpleDateFormat(patten);
			try {
				tsStr = sdf.format(ts);
			} catch (Exception e) {
				if (log.isWarnEnabled()) {
					log.warn(MessageFormat.format("Parse Timestamp \"{0}\" to format String \"{1}\" failed.", ts,
							patten), e);
				}
			}
		}
		return tsStr;
	}

	/**
	 * 转化string为Time 使用valueof（str）方法str的格式一定要是hh:mm:ss的格式
	 *
	 * @param time
	 * @return
	 */
	public static Time convertStringToTime(String time) {
		try {
			return Time.valueOf(time);
		} catch (Exception e) {
			if (log.isWarnEnabled()) {
				log.warn(MessageFormat.format("Parse String \"{0}\" to Time failed.", time), e);
			}
		}
		return null;
	}

	/**
	 * date 转 timestamp
	 *
	 * @param date
	 * @return
	 */
	public static Timestamp convertDateToTimestamp(Date date) {
		String dateStr = formatDate(date, DATE_FORMAT_LONG);
		return convertStringToTimestamp(dateStr);
	}

	/**
	 * 将日期字符串转换为另一格式日期字符串
	 *
	 * @param src
	 * @param srcPattern
	 * @param targetPattern
	 * @return
	 * @throws Exception
	 */
	public static String converse(String src, String srcPattern, String targetPattern) {
		try {
			// 取得时间对象
			Date date = parseDate(src, srcPattern);

			// 转换时间到约定格式
			String target = formatDate(date, targetPattern);

			return target;
		} catch (Exception e) {
			log.error(MessageFormat.format("converse date String \"{0}\" from  \"{1}\" to \"{2}\" failed.", src,
					srcPattern, targetPattern), e);
			return src;
		}
	}

	public static long getMinusBetweenTime(String bgnDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date dateEndDate = sdf.parse(endDate);
			Date dateBgnDate = sdf.parse(bgnDate);
			long minusTime = dateEndDate.getTime() - dateBgnDate.getTime();
			return minusTime / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public static String getRunTimeStr(long runTime) {
		String str = "";
		if (runTime < 60) {
			String value = runTime + "";
			for (int i = value.length(); i < 6; i++) {
				str += "0";
			}
			value = str + value;
			value = getFormatTime(value);
			return value;
		} else {
			int m = (int) runTime / 60;
			int s = (int) runTime % 60;
			String ss = "";
			if (s < 10) {
				ss = "0" + s;
			} else {
				ss = s + "";
			}
			if (m < 60) {
				String value = m + ss;
				for (int i = value.length(); i < 6; i++) {
					str += "0";
				}
				value = str + value;
				value = getFormatTime(value);
				return value;
			} else {
				int h = m / 60;
				m = m % 60;
				String value = "";
				if (m < 10) {
					value = h + "0" + m + ss;
				} else {
					value = h + m + ss;
				}
				value = str + value;
				value = getFormatTime(value);
				return value;
			}
		}
	}

	/**
	 * 取得格式化后的时间
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String getFormatTime(String timeStr) {
		String str = timeStr.substring(0, 2);
		str += ":";
		str += timeStr.substring(2, 4);
		str += ":";
		str += timeStr.substring(4, 6);
		return str;
	}

	/**
	 * 取得格式化后的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getFormatDate(String dateStr, String split) {
		String str = dateStr.substring(0, 4);
		str += split;
		str += dateStr.substring(4, 6);
		str += split;
		str += dateStr.substring(6, 8);
		return str;

	}

	/**
	 * 获取季度首天
	 *
	 * @return
	 */
	public static String getFirstDayofQuarter(String date) {
		String strSeason = "";
		int year, month, day;
		int season = 1;
		int array[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY);
		try {
			calendar.setTime(sdf.parse(date));// all done
		} catch (ParseException e) {
			return null;
		}
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONDAY) + 1;
		// day = calendar.get(Calendar.DAY_OF_MONTH);
		switch (month) {
		case 1:
		case 2:
		case 3:
			season = 1;
			break;
		case 4:
		case 5:
		case 6:
			season = 2;
			break;
		case 7:
		case 8:
		case 9:
			season = 3;
			break;
		case 10:
		case 11:
		case 12:
			season = 4;
			break;
		default:
			season = 1;
			break;
		}

		int start_month = array[season - 1][0];
		// int end_month = array[season-1][2];
		strSeason = year + StringUtils.leftPad(String.valueOf(start_month), 2, "0") + "01";

		return strSeason;
	}

	/**
	 * 获取月度第一天
	 *
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(String date) {
		String strFirstDay = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(date));// all done
		} catch (ParseException e) {
			return null;
		}
		calendar.set(Calendar.DATE, 1); // 设置当前月的1号

		strFirstDay = sdf.format(calendar.getTime());
		return strFirstDay;
	}

	/**
	 * 获取本周周一
	 *
	 * @param date
	 * @return
	 */
	public static String getDateOfMondayInWeek(String date) {
		int day = getBetweenDayAndSundayInWeek(date) + 1; // 加1，即周一离本周日的间隔天数
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, day); // 计算与本周一相差的时间间隔
		Date curDay = calendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY);
		String dateOfMonday = sdf.format(calendar.getTime());
		return dateOfMonday;
	}

	/**
	 * 离周日的天数
	 *
	 * @param date
	 * @return
	 */
	public static int getBetweenDayAndSundayInWeek(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(date));// all done
		} catch (ParseException e) {
			return -1;
		}

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 减一天，周一为1，符合中国人习惯。Sunday - 1; Monday - 2; Saturday - 7
		if (dayOfWeek == 0) { // 周日
			return 0;
		} else {
			return 0 - dayOfWeek;
		}
	}

	public static String remainDateToString(String startDateStr, String endDateStr) {
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		try {
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		Calendar calS = Calendar.getInstance();
		calS.setTime(startDate);
		int startY = calS.get(Calendar.YEAR);
		int startM = calS.get(Calendar.MONTH);
		int startD = calS.get(Calendar.DATE);
		int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

		calS.setTime(endDate);
		int endY = calS.get(Calendar.YEAR);
		int endM = calS.get(Calendar.MONTH);
		// 处理2011-01-10到2011-01-10，认为服务为一天
		int endD = calS.get(Calendar.DATE) + 1;
		int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

		StringBuilder sBuilder = new StringBuilder();
		if (endDate.compareTo(startDate) < 0) {
			return sBuilder.append("过期").toString();
		}
		int lday = endD - startD;
		if (lday < 0) {
			endM = endM - 1;
			lday = startDayOfMonth + lday;
		}
		// 处理天数问题，如：2011-01-01 到 2013-12-31 2年11个月31天 实际上就是3年
		if (lday == endDayOfMonth) {
			endM = endM + 1;
			lday = 0;
		}
		int mos = (endY - startY) * 12 + (endM - startM);
		int lyear = mos / 12;
		int lmonth = mos % 12;
		if (lyear > 0) {
			sBuilder.append(lyear + "年");
		}
		if (lmonth > 0) {
			sBuilder.append(lmonth + "个月");
		}
		if (lday > 0) {
			sBuilder.append(lday + "天");
		}
		return sBuilder.toString();
	}

	/**
	 * zhusihan  2018年9月27日15:59:34   获取前一天日期MMdd模式
	 */
	public static String getLastDay(){
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,-1 );
		Date time = calendar.getTime();
		String mmdd = DateExUtils.formatDate(time, "MMdd");
		return mmdd;
	}

	/**
	 * zhusihan  2018年9月27日15:59:34   获取前一天日期yyyyMMdd模式
	 */
	public static String getLastDayYMD(){
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,-1 );
		Date time = calendar.getTime();
		String mmdd = DateExUtils.formatDate(time, "yyyyMMdd");
		return mmdd;
	}

	/**
	 * zhusihan  2018年9月27日15:59:34   获取前一天日期yyyy-MM-dd模式
	 */
	public static String getLastDayymd(){
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,-1 );
		Date time = calendar.getTime();
		String mmdd = DateExUtils.formatDate(time, "yyyy-MM-dd");
		return mmdd;
	}
}
