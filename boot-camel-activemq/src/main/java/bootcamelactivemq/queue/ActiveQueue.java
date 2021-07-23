package bootcamelactivemq.queue;

public enum ActiveQueue {

    QUEUE("order-queue");

    private String queue;

    private ActiveQueue(String queue){
        this.queue = queue;
    }

    public String getQueue(){
        return queue;
    }
}
