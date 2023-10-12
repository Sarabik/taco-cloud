package sia.tacocloud.repository;

import sia.tacocloud.model.Taco;

public interface TacoRepository {
    long save(Long orderId, int orderKey, Taco taco);
}
