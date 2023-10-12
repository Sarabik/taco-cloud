package sia.tacocloud.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sia.tacocloud.model.IngredientRef;

@Repository
@AllArgsConstructor
public class JdbcIngredientRefRepository implements IngredientRefRepository {

    private  final JdbcTemplate jdbcTemplate;

    @Override
    public void save(IngredientRef ingredientRef, Long tacoId, int tacoKey) {
        jdbcTemplate.update(
                "insert into Ingredient_Ref (ingredient, taco, taco_key) "
                        + "values (?, ?, ?)",
                ingredientRef.getIngredient(),
                tacoId,
                tacoKey
        );
    }
}
