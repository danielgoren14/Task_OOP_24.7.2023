import java.util.List;

public class IncrementValueThread <T extends List<String>> extends Thread {
    private T keys;
    private SharedResource sharedResource;

    public IncrementValueThread (T keys, SharedResource sharedResource) {
        this.keys = keys;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
            this.keys.forEach(key -> {
                synchronized (this.sharedResource) {
                    int value = this.sharedResource.getValue(key);
//                    System.out.println("value :" +value);
                    this.sharedResource.incrementValue(key,value);
                }
            });
    }
}
