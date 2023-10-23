import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;
    public SinglyLinkedList() {
        super();
    }
    public int size() {

        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    public boolean isEmpty() {
        if(this.head == null){
            return true;
        }else{
            return false;
        }

    }
    public E first() {
        if(isEmpty()){
            throw  new NoSuchElementException("Danh sach trong");
        }
        return this.head.getData();
    }
    public E last() {
        if(isEmpty()){
            throw  new NoSuchElementException("Danh sach trong");
        }
        return this.tail.getData();
    }
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if(this.head == null && this.tail == null){
            this.head = newNode;
        }else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

    }
    public E removeFirst() {
        if(this.head == null){
            return null;
        }
        Node<E> temp = this.head;
        this.head = this.head.getNext();
        return temp.getData();
    }
    public E removeLast() {
        if(this.tail == null){
            return null;
        }
        Node<E> temp = this.head;
        while(temp.getNext() != this.tail){
            temp = temp.getNext();
        }
        Node<E> temp1 = this.tail;
        this.tail = temp;
        return temp1.getData();
    }
}
