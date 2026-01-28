package Java8;


import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.ZoneId;


public class LearnDateTime {
    public static void main(String args[]){
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2003, 11, 26));

        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(20, 12));
        System.out.println(LocalTime.of(12, 23, 10));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(2026,06,07, 13,46));

        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York")));

        System.out.println(Period.between(LocalDate.of(2003, 11, 26),LocalDate.now()));

        System.out.println(Duration.between(LocalTime.of(5, 15, 30), LocalTime.now()));

        // Creating a date 
        LocalDate today = LocalDate.now(); 
        System.out.println("Today's date: " + today); 
        // Manipulating dates (immutability means it returns a new object) 
        LocalDate nextWeek = today.plusWeeks(1); 
        System.out.println("Date next week: " + nextWeek); 
        // Parsing and Formatting 
        String releaseDateStr = "2024-10-30"; 
        LocalDate releaseDate = LocalDate.parse(releaseDateStr); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy"); 
        System.out.println("Formatted release date: " + 
        releaseDate.format(formatter)); // Oct 30, 2024

        LocalDateTimeApi();
        ZonedTimeAndDate();
        checkingDuration();
        checkingPeriod();
        checkingChronoEnum();
        checkingAdjusters();

        
    }

    public static void LocalDateTimeApi()
{
    // the current date
    LocalDate date = LocalDate.now();
    System.out.println("the current date is "+ date);
 
    // the current time
    LocalTime time = LocalTime.now();
    System.out.println("the current time is "+ time);
                        
    // will give us the current time and date
    LocalDateTime current = LocalDateTime.now();
    System.out.println("current date and time : "+ current);
 
    // to print in a particular format
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
  
    String formatedDateTime = current.format(format);  
   
    System.out.println("in formatted manner "+ formatedDateTime);
 
    // printing months days and seconds
    Month month = current.getMonth();
    int day = current.getDayOfMonth();
    int seconds = current.getSecond();
    System.out.println("Month : "+month+" day : "+day+" seconds : "+seconds);
 
    // printing some specified date
    LocalDate date2 = LocalDate.of(1950,1,26);
    System.out.println("the republic day :"+date2);
 
    // printing date with current time.
    LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2016);

    System.out.println("specific date with "+ "current time : "+specificDate);
}

//ZONE
// Function to get Zoned Date and Time
public static void ZonedTimeAndDate()
{
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
    
    String formattedCurrentDate = date.format(format1);
    
    System.out.println("formatted current Date and"+" Time : "+ formattedCurrentDate); 

    // to get the current zone
    ZonedDateTime currentZone = ZonedDateTime.now(); 
    System.out.println("the current zone is "+ ZoneId.of("Asia/Tokyo"));
    
    ZoneId tokyo = ZoneId.of("Asia/Tokyo");

    ZonedDateTime tokyoZone = currentZone.withZoneSameInstant(tokyo);
                  
    System.out.println("tokyo time zone is " + tokyoZone);

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
    
    String formatedDateTime = tokyoZone.format(format); 

    System.out.println("formatted tokyo time zone "+ formatedDateTime);
    
}
public static void checkingPeriod()
    {
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 12);

        Period gap = Period.between(date2, date1);
        System.out.println("gap between dates " + "is a period of " + gap);
    }

    // Function to check duration
    public static void checkingDuration()
    {

        LocalTime time1 = LocalTime.now();
        System.out.println("the current time is " + time1);

        Duration fiveHours = Duration.ofHours(5);

        // adding five hours to the current time and storing it in time2
        LocalTime time2 = time1.plus(fiveHours);

        System.out.println("after adding five hours " + "of duration " + time2);

        Duration gap = Duration.between(time2, time1);
        System.out.println("duration gap between time1" + " & time2 is " + gap);
    }

    public static void checkingChronoEnum()
    {
        LocalDate date = LocalDate.now();
        System.out.println("current date is :" + date);

        // adding 2 years to the current date
        LocalDate year = date.plus(2, ChronoUnit.YEARS);

        System.out.println("next to next year is " + year);

        // adding 1 month to the current date
        LocalDate nextMonth = date.plus(1, ChronoUnit.MONTHS);

        System.out.println("the next month is "
                           + nextMonth);

        // adding 1 week to the current date
        LocalDate nextWeek = date.plus(1, ChronoUnit.WEEKS);

        System.out.println("next week is " + nextWeek);

        // adding 2 decades to the current date
        LocalDate Decade = date.plus(2, ChronoUnit.DECADES);

        System.out.println("20 years after today " + Decade);
    }

    // Function to check date and time according to our requirement
    public static void checkingAdjusters()
    {

        LocalDate date = LocalDate.now();
        System.out.println("the current date is " + date);

        // to get the first day of next month
        LocalDate dayOfNextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());

        System.out.println("firstDayOfNextMonth : "+ dayOfNextMonth);

        // get the next saturday
        LocalDate nextSaturday = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

        System.out.println("next saturday from now is "+ nextSaturday);

        // first day of current month
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());

        System.out.println("firstDayOfMonth : " + firstDay);

        // last day of current month
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("lastDayOfMonth : " + lastDay);
    }

}
