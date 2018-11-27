package exercise1;

public class sharedX {
    public int x;

    public sharedX() {
        this.x = 5;
    }

    public sharedX(int x){
        this.x=x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void increment() {
        x++;
    }

    public void decrement() {
        x--;
    }

    public void getValue() {
        getX();
    }
}