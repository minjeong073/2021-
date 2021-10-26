import java.util.NoSuchElementException;

class Node <E> {
    private E item;
    private Node<E> next;
    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }

    public E getItem() { return item; }
    public Node<E> getNext() { return next; }
    public void setItem(E newItem) { item = newItem;}
    public void setNext(Node<E> newNext) { next = newNext;}
}

class SList <E> {
    protected Node head;
    private int size;
    public SList() {
        head = null;
        size = 0;
    }

    //탐색
    public int search(E target) {
        Node p = head;
        for (int k=0; k<size; k++) {
            if (target == p.getItem())
            return k;
            p = p.getNext();
        }
        //탐색 실패한 경우
        return -1;
    }
    
    //맨 앞에 삽입
    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }

    //노드 p 다음에 삽입
    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    //맨 앞 노드 삭제
    public void deleteFront() {
        if (size == 0) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    //노드 p가 가리키는 노드의 다음 노드 삭제
    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    //출력
    public void print() {
        System.out.println("***");
        Node p = head;
        for (int i=0 ; i< size; i++){
            System.out.print(p.getItem() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    //size
    public int size() {
        return size;
    }

}

public class SLinkedList {
    public static void main(String[] args) {
        SList<String> s = new SList<String>();
        s.insertFront("b");
        s.insertFront("aa");
        s.insertAfter("^^", s.head.getNext());
        s.print();
        System.out.println("s의 길이 : "+ s.size());
        System.out.println();
        s.deleteAfter(s.head);
        s.print();
        System.out.println("s의 길이 : "+ s.size());
        System.out.println();
        s.deleteFront();
        s.print();
    }
}
