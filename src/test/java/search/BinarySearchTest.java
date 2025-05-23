package test.java.search;

import main.java.search.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    private int[] haystack = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void search_mid() {

        //test mid
        int index = binarySearch.search(haystack, 60);
        assertEquals (5, index);

    }

    @Test
    public void search_low() {

        //test low
        int index = binarySearch.search(haystack, 10);
        assertEquals (0, index);

    }

    @Test
    public void search_high() {

        //test high
        int index = binarySearch.search(haystack, 100);
        assertEquals (9, index);

    }

    @Test
    public void search_notFound() {

        //test not in array
        int index = binarySearch.search(haystack, 150);
        assertEquals (-1, index);

    }

}
