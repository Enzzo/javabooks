package tacos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String>{
	List<Ingredient> findAll();
	Optional<Ingredient> findById(String id);
	Ingredient save(Ingredient ingredient);
}