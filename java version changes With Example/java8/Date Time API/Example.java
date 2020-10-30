import java.time.*;
import java.time.Month;
import java.time.ZoneId;

/**
 * LocalDate Examples
 * @author pankaj
 *
 */
public class Example {

	public static void main(String[] args) {
		
		//Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date="+today);
		
		//Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date="+firstDay_2014);
		
		
		//Try creating date by providing invalid inputs
		//LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid date 'February 29' as '2014' is not a leap year
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST="+todayKolkata);

		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
		
		//Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date= "+dateFromBase);
		
		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014="+hundredDay2014);
    //Current Time
		LocalTime time = LocalTime.now();
		System.out.println("Current Time="+time);
		
		//Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(12,20,25,40);
		System.out.println("Specific Time of Day="+specificTime);
		
		
		//Try creating time by providing invalid inputs
		//LocalTime invalidTime = LocalTime.of(25,20);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid value for HourOfDay (valid values 0 - 23): 25
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST="+timeKolkata);

		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));
		
		//Getting date from the base date i.e 01/01/1970
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time= "+specificSecondTime);
    }

}
