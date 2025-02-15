

import org.junit.Test;

public class E1CyclicBarrierTest {
    @Test()
    public void test() throws InterruptedException {
        E1CyclicBarrier e1CyclicBarrier = new E1CyclicBarrier();
        e1CyclicBarrier.runCyclicBarrier();
        Thread.sleep(5000);
    }
}