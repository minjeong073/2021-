import java.util.NoSuchElementException;
public class ArrayList <E> { 
    private E a[]; // 항목 저장할 배열
    private int size; // 항목 수
    public ArrayList() { //생성자
        a = (E[]) new Object[1];
        size = 0;
    }

    //삽입(마지막에 / 원하는 곳에)(return할 필요가 없어)
    //마지막에
    public void insertLast(E newItem) {
        //크기 조정(빈공간 없으면 2배로 늘리기)
        if (size == a.length) {
            resize(2*a.length);
        }
        a[size++] = newItem;
    }
    //원하는 곳에
    public void insert(int index, E newItem) {
        //크기 조정
        if (size == a.length) {
            resize(2*a.length);
        }
        //원하는 index 뒤쪽은 한칸씩 미룸
        for (int i=size-1; i>=index; i--) {
            a[i+1] = a[i];
        }
        a[index] = newItem;
        size++;
    }
    //탐색 (index 넣으면 값 출력 / 값 넣으면 index 출력)
    //1st
    public E peek(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return a[index];
    }
    //2nd
    public int peekInt(E value) {
        for (int i=0; i<size; i++) {
            if (value.equals(a[i])) {
                return i;
            }
        }
        //없을 경우
        return -1;
    }
    //크기 조정 (새로운 배열에 넣은 후 다시 원래 배열로 바꾸기)
    public void resize(int newSize) {
        Object[] n = new Object[newSize];
        for (int i=0; i<size; i++) {
            n[i] = a[i];
        }
        a = (E[]) n;
    }
    //삭제 (index 입력 받고 삭제한 값 출력)
    public E delete(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E del = a[index];
        for (int i=index; i<size; i++) {
            a[i] = a[i+1];
        }
        size--;
        //배열이 1/4만 차있을 때 크기 줄이기
        if (size>0 && size == a.length/4) {
            resize(a.length/2);
        }
        return del;
    }

    


}