package datastructures;

import java.util.Arrays;
import java.util.Objects;

public class Arraylist<E> {

    private Object[] elements;

    private int size;

    public E get(int index){
        Objects.checkIndex(index, size);
        return (E) elements[index];
    }

    public void add(E value){
        if(elements.length == size)
            increaseCapacity();
        elements[size] = value;
        size++;
    }

    public E remove(int index){
        Objects.checkIndex(index, size);
        E value = get(index);
        for(int i = index +1; i<size ; i++)
            elements[i--] = elements[i];
        elements[--size] = null;
        return value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void increaseCapacity(){
       elements = Arrays.copyOf(elements, elements.length*2);
    }

}
