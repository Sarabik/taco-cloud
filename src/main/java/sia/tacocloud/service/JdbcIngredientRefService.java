package sia.tacocloud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sia.tacocloud.model.Ingredient;
import sia.tacocloud.model.IngredientRef;
import sia.tacocloud.repository.IngredientRefRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class JdbcIngredientRefService implements IngredientRefService {

    private final IngredientRefRepository ingredientRefRepository;

    @Override
    public void saveIngredientRefs(long tacoId, List<Ingredient> ingredients) {
        int key = 0;
        for (Ingredient ingredient : ingredients) {
            ingredientRefRepository.save(new IngredientRef(ingredient.getId()), tacoId, key++);
        }
    }
}
