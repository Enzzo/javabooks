package tacos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tacos.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
	List<Ingredient> findAll();
}