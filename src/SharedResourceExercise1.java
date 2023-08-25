public class SharedResource1 {
    private int counter = 0;
    private final Object lock = new Object();

    public void increment () {
        synchronized (lock) {
            counter++;
        }
    }

    public void decrement () {
        synchronized (lock) {
            counter --;
        }
    }

    public int getCounter(){
        return counter;
    }

    public String toString () {
        return "Counter " + this.counter;
    }


}
