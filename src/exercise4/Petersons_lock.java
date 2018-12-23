package exercise4;

public class Petersons_lock {

    public static class incrementThread extends Thread{
        sharedX sharedX;
        PetersonAlgorithm lock;
        int threadID =1;
        public incrementThread(sharedX x,PetersonAlgorithm lock) {this.sharedX = x;this.lock=lock;}
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    lock.lock(this.threadID);
                    sharedX.increment();
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock(this.threadID);
            }
        }
    }


    public static class decramentThread extends Thread {
        sharedX sharedX;
        PetersonAlgorithm lock;
        int threadID=0;
        public decramentThread(sharedX x,PetersonAlgorithm lock) { this.sharedX =x; this.lock=lock;}

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    lock.lock(this.threadID);
                    sharedX.decrement();
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock(this.threadID);
            }
        }
    }

    public static class PetersonAlgorithm {

        private volatile boolean flag[] = {false, false};
        private volatile int victim = 1;
        PetersonAlgorithm(){};

        public void lock(int i) {
            flag[i] = true;
            int j = 1 - i;
            victim  = i;
            while (flag[j] && victim == i) {};
        }
        public void unlock(int i) {
            flag[i] = false;
        }

    }

    public static void main(String[] args) {
        sharedX s=new sharedX(3);
        PetersonAlgorithm lock=new PetersonAlgorithm();
        decramentThread de = new decramentThread(s,lock);
        incrementThread in = new incrementThread(s,lock);

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
