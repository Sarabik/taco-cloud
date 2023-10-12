package sia.tacocloud.service;

import sia.tacocloud.model.Ingredient;

import java.util.List;

public interface IngredientRefService {

    void saveIngredientRefs(long tacoId, List<Ingredient> ingredientRefs);

}
