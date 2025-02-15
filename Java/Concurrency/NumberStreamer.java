import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public final class NumberStreamer implements Runnable {
    private final int maxCount;
    private final int sleepDurationInMs;
    private static final int DEFAULT_SLEEP_DURATION_IN_MS = 1000;
    private CyclicBarrier cyclicBarrier;
    public NumberStreamer(final int maxCount, final int sleepDurationInMs, final CyclicBarrier cyclicBarrier) {
        this.maxCount = maxCount;
        this.sleepDurationInMs = sleepDurationInMs;
        this.cyclicBarrier = cyclicBarrier;
    }

    public NumberStreamer(final int maxCount) {
        this.maxCount = maxCount;
        this.sleepDurationInMs = DEFAULT_SLEEP_DURATION_IN_MS;
    }

    @Override
    public void run() {
            IntStream.range(0, maxCount)
                .forEach(i -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId()+
                    ":"+i);
                    Thread.sleep(this.sleepDurationInMs);
                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
            this.handleCyclicBarrier();
    }

    private void handleCyclicBarrier() {
        if (cyclicBarrier == null) {
            return;
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
