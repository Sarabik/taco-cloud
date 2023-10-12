package sia.tacocloud.service;

import sia.tacocloud.model.TacoOrder;

import java.util.List;

public interface OrderService {

    TacoOrder save(TacoOrder order);

    List<TacoOrder> findAll();

}
