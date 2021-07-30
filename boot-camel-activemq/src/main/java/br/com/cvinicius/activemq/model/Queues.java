package br.com.cvinicius.activemq.model;

public enum Queues {

    JSON("json-order"),
    XML("xml-order");

    private String queue;

    Queues(String queue){
        this.queue = queue;
    }

    public String getQueue(){
        return queue;
    }
}
