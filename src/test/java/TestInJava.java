

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestInJava {

    /*
     * TODO: Take the array below and:
     *  (1) make it unique,
     *  (2) sorted alphabetically (ascending), and
     *  (3) Print the result 1 entry per line
     */
    @Test
    public void testPrintUniqueSortedList() {
        List<String> colors = Stream.of("Orange","Green","Purple","Orange","Black","Blue","Purple","Orange").distinct().sorted().collect(Collectors.toList());
        System.out.println("Unique and sorted colors:");
        for (String color : colors) {
            System.out.println(color);
        }

    }

    /*
     * TODO: Find the boxes with a minimum volume of 20 cubic units
     *       Print the result sets' volumes
     */
    @Test
    public void testfilterObjects() {
        List<Box> boxes = Stream.of(
                new Box(2, 4, 2),
                new Box(4, 4, 4),
                new Box(7, 1,  1),
                new Box(2, 7,  8)
        ).collect(Collectors.toList());
        List<Box> boxesWithMinVolume = boxes.stream()
                .filter(box -> box.getVolume() >= 20)
                .collect(Collectors.toList());

        System.out.println("Boxes with a minimum volume of 20 cubic units:");
        for (Box box : boxesWithMinVolume) {
            System.out.println("Volume: " + box.getVolume());
        }

    }

    /*
     * TODO: Find the day of the week of January 9th, 2015
     *       Print the result
     */
    @Test
    public void testNewYearsDay2015DayOfWeek() {
    	 int year = 2015;
         int month = 1;
         int day = 9;

         LocalDate date = LocalDate.of(year, month, day);
         DayOfWeek dayOfWeek = date.getDayOfWeek();
         String dayOfWeekName = dayOfWeek.getDisplayName(DayOfWeek.FULL, java.util.Locale.ENGLISH);

         System.out.println("The day of the week for January 9th, 2015 is: " + dayOfWeekName);
    }

    /*
     * TODO: Find the largest prime number less than 66550
     *       Print the result
     */
    @Test
    public void findLargetPrimeLessThan() {
    	int limit = 66550;
        int largestPrime = findLargestPrime(limit);
        System.out.println("The largest prime number less than " + limit + " is: " + largestPrime);
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static int findLargestPrime(int limit) {
        for (int number = limit - 1; number > 1; number--) {
            if (isPrime(number)) {
                return number;
            }
        }
        return -1; // Return -1 if no prime number is found
    }
}
