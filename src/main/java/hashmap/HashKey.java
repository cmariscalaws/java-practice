package main.java.hashmap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashKey {

    private String key;

    HashKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode()
    {
        return (int) key.charAt(0);
    }

    @Override
    public boolean equals(Object object) {
        return  key.equals((String) object);
    }

}
