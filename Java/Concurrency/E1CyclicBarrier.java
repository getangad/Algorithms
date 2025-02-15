import java.util.concurrent.CyclicBarrier;

public class E1CyclicBarrier {
    
    public E1CyclicBarrier() {

    }
    public static void main(String[] args) {
        E1CyclicBarrier e1CyclicBarrier = new E1CyclicBarrier();
        e1CyclicBarrier.runCyclicBarrier();
    }

    public void runCyclicBarrier() {
        CyclicBarrier barrier=new CyclicBarrier(3, ()-> {
            System.out.println("All completed");
        });
        new Thread(new NumberStreamer(10, 500, barrier)).start();
        new Thread(new NumberStreamer(20, 500, barrier)).start();
        new Thread(new NumberStreamer(20, 500, barrier)).start();
        
        System.out.println("All Started waiting:"+barrier.getParties());
        System.out.println("End of Main");
    }


}