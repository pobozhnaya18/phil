
import java.util.ArrayList;

public class MainThread {
    int amountPhilosopher, count;
    ArrayList<Philosopher> philosopherList = new ArrayList<Philosopher>();
    ArrayList<Fork> forkList = new ArrayList<Fork>();

    public MainThread(int amount) {
        count = 0;
        amountPhilosopher = amount;
        for(int i=0; i<amountPhilosopher; i++) {
            forkList.add(new Fork());
        }
    }

    public void CreatePhilosopher() {
        int i = 0;
        for(; i<amountPhilosopher; i++) {
            if(i != amountPhilosopher-1) {
                philosopherList.add(new Philosopher(i,forkList.get(i),forkList.get(i+1)));
            }else {
                philosopherList.add(new Philosopher(i,forkList.get(i),forkList.get(0)));
            }
            System.out.println("Философ добавлен "+(i+1));//++
        }

        for(i=0; i<amountPhilosopher; i++) {
            try {
                philosopherList.get(i).thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Философы пообедали");
    }

    String returnNotification() {
        return "Философы пообедали";
    }
}