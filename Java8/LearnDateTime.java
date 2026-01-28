package Java8;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
    }
}
