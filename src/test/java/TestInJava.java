

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
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

    }

    /*
     * TODO: Find the day of the week of January 9th, 2015
     *       Print the result
     */
    @Test
    public void testNewYearsDay2015DayOfWeek() {
    }

    /*
     * TODO: Find the largest prime number less than 66550
     *       Print the result
     */
    @Test
    public void findLargetPrimeLessThan() {

    }
}
