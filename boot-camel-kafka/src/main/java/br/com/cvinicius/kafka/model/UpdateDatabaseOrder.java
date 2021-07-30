package br.com.cvinicius.kafka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UpdateDatabaseOrder {

    private Logger log = LoggerFactory.getLogger(UpdateDatabaseOrder.class);

    public void process(Order order)
            throws Exception {

        log.info("Aqui Update do Pedido: {} - Valor: {}", order.getId(), order.getValue());
    }
}
