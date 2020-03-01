package lesson2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SingleTon {

    private static AtomicReference<SingleTon> INSTANCE  =  new AtomicReference<SingleTon>();
    final int id;
    private static final AtomicInteger counter =  new AtomicInteger( 0);

    private SingleTon( int id) {
        this.id =  id;
    }

    public int getId() {
        return id;
    }

    public static SingleTon getSingleTon(){
        INSTANCE.compareAndSet(null, new SingleTon(counter.getAndIncrement()));
        return INSTANCE.get();
    }
}
