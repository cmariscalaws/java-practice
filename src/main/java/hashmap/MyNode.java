package main.java.hashmap;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyNode {

    private int hash;
    private HashKey key;
    private int value;
    private MyNode next;

}
