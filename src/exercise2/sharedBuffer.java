package exercise2;

public class sharedBuffer {

    public static class ProducerThread extends Thread {
        CycBuf cycBuf;
        int x;
        public ProducerThread(CycBuf c){
            cycBuf=c;
            x=1;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    cycBuf.addToCycbuf(x++);
                    System.out.println("producer: " +x);
                    sleep(500);
                    }
                }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ConsumerThread extends Thread {
        CycBuf cycBuf;
        int temp=0;
        public ConsumerThread(CycBuf c){
            cycBuf=c;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    temp=cycBuf.getCycTail();
                    if(temp== -1){
                        System.out.println("ERROR" );
//                        return;
                    }else {
                        System.out.println("consumer: " +temp);
                        sleep(500);
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CycBuf cycBuf=new CycBuf();

        ProducerThread Producer=new ProducerThread(cycBuf);
        ConsumerThread Consumer=new ConsumerThread(cycBuf);

        Producer.start();
        Consumer.start();
        try {
            Producer.join();
            Consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end exercise 2");
    }
}