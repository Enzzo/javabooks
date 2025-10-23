package tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.data.repository.IngredientRepository;
import tacos.model.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{

	private IngredientRepository ingredientRepo;
	
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@Override
	public Ingredient convert(String id) {		
		return ingredientRepo.findById(id).orElse(null); // Не следует возвращать null.
	}
}