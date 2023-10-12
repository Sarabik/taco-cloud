package sia.tacocloud.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import sia.tacocloud.model.Taco;
import sia.tacocloud.repository.TacoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class JdbcTacoService implements TacoService {

    private IngredientRefService ingredientRefService;
    private TacoRepository tacoRepository;

    @Override
    public void saveTacos(List<Taco> tacos, long orderId) {
        int i = 0;
        for (Taco taco : tacos) {
            long tacoId = tacoRepository.save(orderId, i++, taco);
            ingredientRefService.saveIngredientRefs(tacoId, taco.getIngredients());
        }
    }
}
