package main.java.hashmap;

public class MyHashMap {

    private static final int HASH_ARRAY_SIZE = 16;

    private MyNode[] hashArray = new MyNode[HASH_ARRAY_SIZE];
    private int size = 0;

    public int get(String key) {

        HashKey keyObj = new HashKey(key);
        MyNode firstNode = hashArray[index(keyObj)];

        MyNode matchingNode = findMatchingNode(firstNode, keyObj);

        if(matchingNode != null) {
            return matchingNode.getValue();
        }
        else {
            return -1;
        }
    }

    public void put(String key, int value) {

        HashKey keyObj = new HashKey(key);

        MyNode newNode = new MyNode();
        newNode.setHash(keyObj.hashCode());
        newNode.setKey(keyObj);
        newNode.setValue(value);

        int index = index(keyObj);
        MyNode existingNode = hashArray[index];

        if(existingNode == null) {
            hashArray[index] = newNode;
            size++;
        }
        else {
            handleCollision(existingNode, newNode);
        }
    }

    public int size() {
        return size;
    }

    /**
     * This method calculates the index for the hash array where the key should be stored.
     * It uses the bitwise AND operator (&) to perform the calculation.
     * The hashCode of the key is ANDed with the result of (HASH_ARRAY_SIZE - 1).
     * This operation ensures that the index will always be within the bounds of the hash array.
     *
     * @param key The key for which the index needs to be calculated.
     * @return The calculated index in the hash array.
     */
    private int index(HashKey key) {
        return key.hashCode() & (HASH_ARRAY_SIZE - 1);
    }

    /**
     * This method finds a node in the hash map that matches the provided key.
     * It uses recursion to traverse through the linked list of nodes at a particular index in the hash array.
     *
     * @param currentNode The node from which the search should start.
     * @param key The key of the node that needs to be found.
     * @return The node that matches the key. If no matching node is found, it returns null.
     */
    private MyNode findMatchingNode(MyNode currentNode, HashKey key) {

        // If the hash of the current node and the key are equal and their keys are also equal,
        // it means we have found the matching node. In this case, we return the current node.
        if(currentNode.getHash() == key.hashCode() && currentNode.getKey().equals(key.getKey())) {
            return currentNode;
        }

        // If the next node of the current node is not null, it means we have not yet reached the end of the chain.
        // We make a recursive call to findMatchingNode with the next node of the current node and the key.
        if(currentNode.getNext() != null) {
            return findMatchingNode(currentNode.getNext(), key) ;
        }
        // If the next node of the current node is null, it means we have reached the end of the chain and the key was not found.
        // In this case, we return null.
        else {
            return null;
        }
    }

    /**
     * This method handles collisions in the hash map. When two different keys have the same hash,
     * this method ensures that both keys can still be stored and retrieved correctly.
     *
     * @param currentNode The node in the hash map where the collision occurred.
     * @param newNode The new node that is being inserted, which caused the collision.
     * @return The node that was handled. If the keys are equal, it returns the updated current node.
     * If the keys are not equal, it returns the result of the recursive call to handleCollision.
     */
    private MyNode handleCollision (MyNode currentNode, MyNode newNode) {

        // If the hash of the current node and the new node are equal and their keys are also equal,
        // it means we are trying to insert a duplicate key. In this case, we update the value of the current node
        // with the value of the new node and return the current node.
        if(currentNode.getHash() == newNode.getHash() && currentNode.getKey().equals(newNode.getKey().getKey())) {
            //replace existing value
            currentNode.setValue(newNode.getValue());
            return currentNode;
        }

        // If the next node of the current node is null, it means we have reached the end of the chain for this hash.
        // We add the new node at the end of the chain and return the current node.
        if(currentNode.getNext() == null) {
            currentNode.setNext(newNode);
            size++;
            return currentNode;
        }
        // If the next node of the current node is not null, it means we have not yet reached the end of the chain.
        // We make a recursive call to handleCollision with the next node of the current node and the new node.
        else {
            return handleCollision(currentNode.getNext(), newNode);
        }
    }
}
