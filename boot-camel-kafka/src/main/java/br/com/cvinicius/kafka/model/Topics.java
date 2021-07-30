package br.com.cvinicius.kafka.model;

public enum Topics {

    JSON("json-order"),
    XML("xml-order");

    private String topic;

    Topics(String topic){
        this.topic = topic;
    }

    public String getTopic(){
        return topic;
    }
}
