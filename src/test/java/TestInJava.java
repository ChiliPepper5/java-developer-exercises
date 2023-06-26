

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TestInJava {

    /*
     * TODO: Take the array below and:
     *  (1) make it unique,
     *  (2) sorted alphabetically (ascending), and
     *  (3) Print the result 1 entry per line
     */
    @Test
    public void testPrintUniqueSortedList() {
		List<String> colors = Stream.of("Orange","Green","Purple","Orange","Black","Blue","Purple","Orange").collect(Collectors.toList());
        colors.stream()
        	.collect(Collectors.toCollection(TreeSet::new))
        	.forEach(System.out::println);
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
        boxes.stream()
		.map(b -> b.height * b.width * b.depth)
		.filter(b -> b >= 20)
		.forEach(System.out::println);
    }

    /*
     * TODO: Find the day of the week of January 9th, 2015
     *       Print the result
     */
    @Test
    public void testNewYearsDay2015DayOfWeek() {
    	 LocalDate ld = LocalDate.of(2015, 1, 9);
    	 System.out.println(ld.getDayOfWeek());
    }

    /*
     * TODO: Find the largest prime number less than 66550
     *       Print the result
     */
    @Test
    public void findLargetPrimeLessThan() {
    	primeNumbersUnTil(66550).forEach(System.out::println);
	}
    
    public static List < Integer > primeNumbersUnTil(int n) {
        return IntStream
            .rangeClosed(n-1, n)
            .filter(x -> isPrime(x)).boxed()
            .collect(Collectors.toList());
    }
    private static boolean isPrime(int number) {
    	if(number > 1 && number % 2 != 0)
    		return true; 
    	else 
    		return false;
    }
}
