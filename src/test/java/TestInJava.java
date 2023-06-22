

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
        colors.stream()
                .distinct()
                .sorted((a,b) -> a.compareTo(b))
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
                .map(b -> b.width * b.depth * b.height)
                .filter(v -> v >= 20 )
                .forEach(System.out::println);
    }

    /*
     * TODO: Find the day of the week of January 9th, 2015
     *       Print the result
     */
    @Test
    public void testNewYearsDay2015DayOfWeek() {
     Map<Integer, String> days = new HashMap<>();
     days.put(1,"Monday");
     days.put(2,"Tuesday");
        days.put(3,"Wednesday");
        days.put(4,"Thursday");
        days.put(5,"Friday");
        days.put(6,"Saturday");
        days.put(7,"Sunday");
        int day = dayOfWeek(9, 1, 2015);
        System.out.println(days.get(day));
    }

    private int dayOfWeek(int d, int m, int y){
        int t[] ={0,3,2,5,0,3,5,1,4,6,2,4};

        if(m < 3) y -=1;

        return (y + y / 4 - y /100 + y / 400 + t[m - 1] + d ) % 7 ;
    }

    /*
     * TODO: Find the largest prime number less than 66550
     *       Print the result
     */
    @Test
    public void findLargetPrimeLessThan() {
        int n = 66550;
        System.out.println(getPrime(n));
    }
    private int getPrime(int n){
        if(n % 2 !=0) n-=2;
        else n--;

        int i,j;
        for(i =n ; i >=2 ; i -=2){
            if(i % 2 ==0){
                continue;
            }
            for(j = 3 ; j <= Math.sqrt(i) ; j +=2) {
                if (i % j == 0) break;

            }
            if(j > Math.sqrt(i)) return i;


        }
        return 2;
    }
}
