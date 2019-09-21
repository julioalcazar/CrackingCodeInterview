package datastructures;

public class HashTable<K,V> {

    private Table<K,V>[] table;
    private int capacity;
    private float loadFactor;

    public HashTable() {
        this.capacity = 11;
        this.loadFactor = 0.75f;

        table = (Table<K,V>[]) new Table[capacity];
        for (int i = 0; i < capacity ; i++) {
            table[i] = new Table();
        }
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    public V get(K key){
        return table[hash(key)].get(key);
    }

    public void put(K key, V value){
        table[hash(key)].put(key, value);
    }

    public void delete(K key){
        table[hash(key)].delete(key);
    }

    public void keys(){

    }
}

class Table<K,V>{

    private Node first;

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public V get(K key){
        for(Node tmp=first; tmp != null; tmp = tmp.next)
            if(key.equals(tmp.key))
                return tmp.value;
        return null;
    }

    public void put(K key, V value){
        for(Node tmp=first; tmp != null; tmp = tmp.next)
            if(key.equals(tmp.key)){
                tmp.value = value;
            }
         first = new Node(key, value, first);
    }

    public void delete(K key){
        if (first==null)
            return;
        Node tmp = first;
        for (Node x = tmp.next; x!=null ; x=x.next) {
            if (key.equals(x.key)){
                tmp.next = x.next;
                return;
            }
            tmp = x;
        }
    }
}

