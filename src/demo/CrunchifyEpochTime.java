
package demo;
 
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class CrunchifyEpochTime {
 
	public static void main(String[] args) {
 
		Date today = Calendar.getInstance().getTime();
 
		// Constructs a SimpleDateFormat using the given pattern
		SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
 
		// format() formats a Date into a date/time string.
		String currentTime = crunchifyFormat.format(today);
		LogMessage("Current Time = " + currentTime);
		LogMessage("New String{{"+currentTime+"}}");
 
		try {
 
			// parse() parses text from the beginning of the given string to produce a date.
			Date date = crunchifyFormat.parse(currentTime);
 
			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
			long epochTime = date.getTime();
 
			LogMessage("Current Time in Epoch: " + epochTime);
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
 
		// Local ZoneID
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LogMessage("defaultZoneId: " + defaultZoneId);
 
		Date date = new Date();
 
		// Default Zone: UTC+0
		Instant instant = date.toInstant();
		System.out.println("instant : " + instant);
 
		// Local TimeZone
		LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
		System.out.println("localDateTime : " + localDateTime);
 
	}
 
	// Simple logging
	private static void LogMessage(String string) {
		Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		SimpleFormatter formatter = new SimpleFormatter();
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("LoggerFile.txt");
			
		} catch (SecurityException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fileHandler.setFormatter(formatter);
		LOGGER.setLevel(Level.ALL);
		LOGGER.setLevel(Level.CONFIG);
		LOGGER.setLevel(Level.FINE);
		LOGGER.setLevel(Level.SEVERE);
		LOGGER.setLevel(Level.INFO);
		
		try {
			LOGGER.addHandler(fileHandler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.log(Level.INFO, "New message {0}", "Internal");
 
	}
}
