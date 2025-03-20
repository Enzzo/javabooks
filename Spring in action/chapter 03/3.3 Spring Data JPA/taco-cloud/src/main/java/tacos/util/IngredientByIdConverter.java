package tacos.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tacos.model.Ingredient;
import tacos.repository.IngredientRepository;

@Slf4j
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	private final IngredientRepository ingredientRepo;
	
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
	}	
}