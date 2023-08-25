public class Resource {
    private int value;
    public synchronized void increment () {
//        System.out.println(value);
        value ++;
        if (value == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();

    }

    public synchronized void decrement () {
//        System.out.println(value);
        while (value < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value --;
        notifyAll();
    }

    public synchronized int getValue () {
        return value;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "value=" + value +
                '}';
    }
}
