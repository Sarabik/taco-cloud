package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.model.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    @Override
    List<Ingredient> findAll();
}
