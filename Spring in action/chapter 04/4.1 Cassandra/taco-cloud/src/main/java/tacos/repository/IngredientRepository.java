package tacos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tacos.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
	List<Ingredient> findAll();
	Optional<Ingredient> findById(String id);
	Ingredient save(Ingredient ingredient);
}