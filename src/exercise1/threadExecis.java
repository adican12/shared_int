package exercise1;

public class threadExecis {


    public static class incrementThread extends Thread{
        sharedX sharedX;

        public incrementThread(sharedX x) {
            this.sharedX = x;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    sharedX.increment();
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class decramentThread extends Thread {
        sharedX sharedX;

        public decramentThread(sharedX x) {
            this.sharedX =x;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    sharedX.decrement();
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        sharedX s=new sharedX(3);

        decramentThread de=new decramentThread(s);
        incrementThread in=new incrementThread(s);

        de.start();
        in.start();
        try {
            de.join();
            in.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sharedX= " + s.getX() );
    }
}

