package tacos.repository;

import java.util.List;
import java.util.Optional;

import tacos.model.Ingredient;

public interface IngredientRepository {
	List<Ingredient> findAll();
	Optional<Ingredient> findById(String id);
	Ingredient save(Ingredient ingredient);
}