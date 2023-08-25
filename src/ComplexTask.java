public class ComplexTask implements Runnable{
    private Resource resource;
    private boolean isIncrement;

    public ComplexTask (Resource resource, boolean isIncrement) {
        this.resource = resource;
        this.isIncrement = isIncrement;
    }

    @Override
    public void run() {
        if (isIncrement) {
            for (int i = 0; i < 10; i++) {
                resource.increment();
            }
        } else {
            for (int i = 0; i < 10; i++) {
                resource.decrement();
            }
        }

    }
    public static void main (String[] args) {
        Resource sharedResource = new Resource();

        Thread incrementThread = new Thread(new ComplexTask(sharedResource,true));
        Thread decrementThread = new Thread(new ComplexTask(sharedResource,false));

        incrementThread.start();
        decrementThread.start();
        System.out.println(sharedResource.toString());
    }
}
