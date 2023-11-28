package sia.tacocloud.service;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import sia.tacocloud.model.TacoOrder;
import sia.tacocloud.repository.OrderRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public TacoOrder save(TacoOrder order) {
        order.setPlacedAt(new Date());
        return orderRepository.save(order);
    }

    @Override
    public List<TacoOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
