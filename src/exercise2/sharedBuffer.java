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
            cycBuf.addToCycbuf(x++);
        }
    }

    public static class ConsumerThread extends Thread {
        CycBuf cycBuf;

        public ConsumerThread(CycBuf c){
            cycBuf=c;
        }

        @Override
        public void run() {
            System.out.println("consumer: "+ cycBuf.getCycTail() );
        }
    }

    public static void main(String[] args) {
        CycBuf cycBuf=new CycBuf(10);

        ProducerThread Producer=new ProducerThread(cycBuf);
        ConsumerThread consumer=new ConsumerThread(cycBuf);

        Producer.start();
        consumer.start();
        try {
            Producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end exercise 2");
    }
}