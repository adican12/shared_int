package exercise4;

public class bakeryLock {

    boolean[] flag;
    int[] label;
    private int n;

    public bakeryLock(int n) {
        this.n=n;
        flag = new boolean[n];
        label = new int[n];

        for (int i = 0; i < n; i++) {
            flag[i] = false;
            label[i] = 0;
        }
    }

    public void lock(int threadID){
        flag[threadID]= true;
        label[threadID]= findMaximumElement(label) + 1;
        for (int k = 0; k < n; k++) {
            while ((k != threadID) && flag[k] && ((label[k] < label[threadID])) || ((label[k] == label[threadID]) && k < threadID)) {
                //spin wait
            }
        }
    }

    public void unlock(int threadID){
        flag[threadID]= false;
    }

    private int findMaximumElement(int[] elementArray) {
        int maxValue = Integer.MIN_VALUE;
        for (int element : elementArray) {
            if (element > maxValue) {
                maxValue = element;
            }
        }
        return maxValue;
    }
}
