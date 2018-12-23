package exercise4;

public class lock_test {

    public static class incrementThread extends Thread{
        sharedX sharedX;
//        Petersons_lock lock;
//        bakeryLock lock;
        filterLock lock;
        int threadID =1;
        public incrementThread(sharedX x, filterLock lock) {this.sharedX = x;this.lock=lock;}
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
//        Petersons_lock lock;
//        bakeryLock lock;
        filterLock lock;
        int threadID=0;
        public decramentThread(sharedX x, filterLock lock) { this.sharedX =x; this.lock=lock;}

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


    public static void main(String[] args) {
        sharedX s=new sharedX(3);
//        Petersons_lock lock=new Petersons_lock();
//        bakeryLock lock=new bakeryLock(2);
        filterLock lock=new filterLock(2);
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