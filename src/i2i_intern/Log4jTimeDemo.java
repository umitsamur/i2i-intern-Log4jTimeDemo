package i2i_intern;

import java.time.LocalDate;
import java.util.Calendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTimeDemo {

	private static Logger timeLogger = LogManager.getLogger(Log4jTimeDemo.class);

	public static void main(String[] args) {
		jobStart();
	}

	public static void jobStart() {
		LocalDate date;
		Calendar rightNow;
		date = LocalDate.now();
		rightNow = Calendar.getInstance();
		writeToLogFile(date, rightNow);
	}

	public static void writeToLogFile(LocalDate date, Calendar rightNow) {

		int tempHour, tempMinute, tempSecond;
		try {
			while (true) {
				tempHour = rightNow.get(Calendar.HOUR_OF_DAY);
				tempMinute = rightNow.get(Calendar.MINUTE);
				tempSecond = rightNow.get(Calendar.SECOND);
				Thread.sleep(1000);
				date = LocalDate.now();
				rightNow = Calendar.getInstance();
				if (tempHour != rightNow.get(Calendar.HOUR_OF_DAY)) {
					timeLogger.warn(getFullTime(rightNow));
				} else if (tempMinute != rightNow.get(Calendar.MINUTE)) {
					timeLogger.error(getFullTime(rightNow));
				} else if (tempSecond != rightNow.get(Calendar.SECOND)) {
					timeLogger.trace(getFullTime(rightNow));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getFullTime(Calendar rightNow) {
		rightNow = Calendar.getInstance();
		return rightNow.get(Calendar.HOUR_OF_DAY) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND);
	}
}
