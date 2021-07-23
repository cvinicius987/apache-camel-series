package bootcamelactivemq.queue.receiver;

import bootcamelactivemq.queue.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class UpdateDatabaseOrder {

    private Logger log = LoggerFactory.getLogger(UpdateDatabaseOrder.class);

    public void process(Order order)
            throws Exception {

        log.info("Aqui Update do Pedido: {} - Valor: {}", order.getId(), order.getValue());
    }
}
