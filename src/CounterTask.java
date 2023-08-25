public class CounterTask implements Runnable {
    private static int counter = 0;
//    static Object lock = new Object();
    @Override
    public void run() {
//        synchronized (lock) {
            counter ++;
            System.out.println(counter);
            counter --;
//        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new CounterTask());
        Thread t2 = new Thread(new CounterTask());
        Thread t3 = new Thread(new CounterTask());
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(counter);
    }

}
