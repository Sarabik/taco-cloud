package sia.tacocloud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sia.tacocloud.model.TacoOrder;
import sia.tacocloud.repository.OrderRepository;

@Service
@AllArgsConstructor
public class JdbcOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final TacoService tacoService;

    @Override
    public TacoOrder save(TacoOrder order) {
        orderRepository.save(order);
        tacoService.saveTacos(order.getTacos(), order.getId());
        return order;
    }
}
