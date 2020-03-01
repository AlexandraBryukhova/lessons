package lesson2

import lesson2.SingleTon
import org.junit.Test;
import java.util.concurrent.ConcurrentSkipListSet;
import static org.junit.Assert.*;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class SingletonTest {

    private static final int nTreads = 100;

    @Test
    public void getSingleTon() {
        ConcurrentSkipListSet<Integer> listSet = new ConcurrentSkipListSet<Integer>();
        CountDownLatch startCdl = new CountDownLatch(nTreads);
        CountDownLatch endCdl = new CountDownLatch(nTreads);
        Executor executor = Executors.newFixedThreadPool(nTreads);
        for (int i = 0; i < nTreads; i++) {
            executor.execute(() -> {
                startCdl.countDown();
                try {
                    startCdl.await();
                } catch (InterruptedException e) {
                    fail();
                }
                SingleTon singleTon = SingleTon.getSingleTon();
                listSet.add(singleTon.getId());
                endCdl.countDown();
            });
        }
        try {
            endCdl.await();
        } catch (InterruptedException e) {
            fail();
        }

        assertEquals(1, listSet.size());
    }

}
