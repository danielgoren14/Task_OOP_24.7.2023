import java.util.HashMap;
import java.util.Map;

public class SharedResource {
    private Map<String,Integer> data;

    public SharedResource() {
        this.data = new HashMap<>();
    }

    public synchronized void incrementValue (String key, int value) {
        this.data.put(key,value + 1);
    }

    public synchronized int getValue (String key) {
        return this.data.get(key) == null ? 0 : this.data.get(key);
    }

    @Override
    public String toString() {
        return "SharedResource{" +
                "data=" + data +
                '}';
    }
}
