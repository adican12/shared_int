package exercise4;

public class filterLock {

    int[] level;  // level[i] for thread i
    int[] victim; // victim[L] for level L
    private int n;
    public filterLock(int n) {
        this.n=n;
        level  = new int[n];
        victim = new int[n];
        for (int i = 1; i < n; i++) {
            level[i] = 0;
        }
    }

    public void lock(int threadID){

        for (int L = 1; L < n; L++) {
            level[threadID]  = L;
            victim[L] = threadID;
            while ((L != threadID) && (level[L] >= threadID ) && (victim[L] == threadID ) )
            {
                // spin wait
            }
        }
    }

    public void unlock(int threadID){
        level[threadID] = 0;
    }
}
