package sia.tacocloud.service;

import sia.tacocloud.model.Taco;

import java.util.List;

public interface TacoService {

    void saveTacos(List<Taco> tacos, long orderId);

}
