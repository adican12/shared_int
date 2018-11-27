package exercise2;

import java.util.ArrayList;

public class CycBuf {
    ArrayList<Integer> bufer;
    int head,tail,size;

    public void addToCycbuf(int x){
        bufer.set(tail++,x);
    }

    public int getCycTail(){
        return bufer.get(tail--);
    }

    public CycBuf(int size) {
        this.size = size;
    }

    public ArrayList<Integer> getBufer() {
        return bufer;
    }

    public void setBufer(ArrayList<Integer> bufer) {
        this.bufer = bufer;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CycBuf() {
        head=0;
        tail=0;
        size=0;
    }
}
