package exercise2;

import java.util.LinkedList;
import java.util.Queue;

public class CycBuf {
    Queue<Integer> bufer = new LinkedList<>();

    public void addToCycbuf(int x){
        bufer.add(x);
    }

    public int getCycTail(){
        if (bufer.isEmpty() ){
            return -1;
        }else {
            return bufer.poll();
        }
    }

    public CycBuf() {}

}
