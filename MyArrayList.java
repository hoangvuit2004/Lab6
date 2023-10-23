import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    public void growSize() {
        int newCapacity = elements.length * 2;
        E[] newData = (E[]) new Object[newCapacity];


        for (int i = 0; i < size; i++) {
            newData[i] = elements[i];
        }
        elements = newData;


    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        return elements[i];

    }
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }

        E oldValue = elements[i];
        elements[i] = e;

        return oldValue;
    }
    public boolean add(E e) {
      if(size == elements.length){
          growSize();
      }
      elements[size] = e;
      size++;
      return true;
    }
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        if(size == size()){
            growSize();
        }
        for (int j = size; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = e;
        size++;

    }
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        E temp = elements[i];
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;

        size--;
        return temp ;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    public int lastIndexOf(Object o) {
        for (int i = size-1; i >= 0  ; i--) {
            if(elements[i] == o){
                return i;
            }
        }
        return -1;
    }
    public E[]  toArray() {
        E[] array = (E[]) new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }

        return array;
    }
    public MyArrayList<E> clone() {
        MyArrayList<E> clonedList = new MyArrayList<>(size);
        clonedList.size = this.size;
        for (int i = 0; i < size; i++) {
            clonedList.elements[i] = this.elements[i];
        }
        return clonedList;
    }
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if(elements[i] == o){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o) {
        for (int i = 0; i < size(); i++) {
            if(elements[i] == o){
                return i;
            }
        }
        return -1;
    }
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[i].equals(e)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }



    public void sort(Comparator<E> c)   {
        E[] tempArray = Arrays.copyOf(elements,size);
        Arrays.sort(tempArray,c);
        for (int i = 0; i < size; i++) {
            elements[i] = tempArray[i];
        }
    }



}
