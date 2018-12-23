package exercise4;

public class Petersons_lock{

        private volatile boolean flag[] = {false, false};
        private volatile int victim = 1;
        Petersons_lock (){};

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
