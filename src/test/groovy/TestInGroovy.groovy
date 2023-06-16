import org.junit.Test

class TestInGroovy {

    /*
     * TODO: Take the array below and make it unique and sorted alphabetically ascending
     *       Print the result to confirm success
     */
    @Test
    void testPrintUniqueSortedList() {
        List<String> colors = ['Orange','Green','Purple','Orange','Black','Blue','Purple','Orange']


    }

    /*
     * TODO: Sort the array of names below by lastName ascending, then firstName ascending
     *       Print the result 1 entry per line in the format "firstName lastName"
     */
    @Test
    void testSortObjects() {
        List<Map<String,String>> people = [
                ['firstName':'John' ,'lastName':'Doe'],
                ['firstName':'John' ,'lastName':'Public'],
                ['firstName':'Jane' ,'lastName':'Doe'],
                ['firstName':'Anne' ,'lastName':'Zurich'],
                ['firstName':'Ben'  ,'lastName':'Hill'],
                ['firstName':'Aaron','lastName':'Aaronson']
        ]

    }

    /*
     * TODO: Find the boxes with a minimum volume of 20 cubic units
     *       Print the result sets' volumes
     */
    @Test
    void testfilterObjects() {
        List<Box> boxes = [
                new Box(height : 2, width  : 4, depth  : 2),
                new Box(height : 4, width  : 4, depth  : 4),
                new Box(height : 7, width  : 1, depth  : 1),
                new Box(height : 2, width  : 7, depth  : 8)
        ]

    }


    /*
     * TODO: Find the day of the week of January 9th, 2015
     *       Print the result
     */
    @Test
    void testNewYearsDay2015DayOfWeek() {

    }

    /*
     * TODO: Find the largest prime number less than 66550
     *       Print the result
     */
    @Test
    void findLargetPrimeLessThan() {

    }
}
