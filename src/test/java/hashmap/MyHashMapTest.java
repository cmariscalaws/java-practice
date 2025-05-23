package test.java.hashmap;

import main.java.hashmap.MyHashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyHashMapTest {

    @Test
    public void myHashMap() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("vishal", 20);
        assertEquals(1, myHashMap.size());

        myHashMap.put("sachin", 30);
        assertEquals(2, myHashMap.size());

        myHashMap.put("vaibhav", 40);
        assertEquals(3, myHashMap.size());

        myHashMap.put("vishnu", 50);
        assertEquals(4, myHashMap.size());

        myHashMap.put("venkat", 60);
        assertEquals(5, myHashMap.size());

        myHashMap.put("vishnu", 100);
        assertEquals(5, myHashMap.size());

        int val = myHashMap.get("sachin");
        assertEquals(30, val);

        val = myHashMap.get("vaibhav");
        assertEquals(40, val);

        val = myHashMap.get("vishnu");
        assertEquals(100, val);

        val = myHashMap.get("venkat");
        assertEquals(60, val);

    }
}
