package main.java.search;

public class BinarySearch {

    //divide by 2, log N

    public int search(int[] haystack, int needle) {

        System.out.println("looking for needle=" + needle);

        int low = 0;
        int high = haystack.length;
        int iteration = 1;

        do {

            System.out.println("interation=" + iteration);

            int mid = (int) Math.floor(low + (high - low) / 2);
            int value = haystack[mid];

            System.out.println("value=" + value + " using midpoint=" + mid);

            if(value == needle) {
                System.out.println("found needle at index=" + mid);
                return mid;
            }
            else if (needle > value) {
                low = mid + 1;
                System.out.println("needle=" + needle + " is greater than " + value + ", new low is " + low);
            }
            else {
                high = mid;
                System.out.println("needle=" + needle + " is less than " + value + ", new high is " + high);
            }

            iteration++;

        } while (low < high);


        System.out.println("needle=" + needle + " was not found in haystack. Returning -1");
        return -1;
    }
}
