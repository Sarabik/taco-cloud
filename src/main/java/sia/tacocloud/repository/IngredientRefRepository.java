package sia.tacocloud.repository;

import sia.tacocloud.model.IngredientRef;

public interface IngredientRefRepository {
    void save(IngredientRef ingredientRef, Long tacoId, int tacoKey);
}
