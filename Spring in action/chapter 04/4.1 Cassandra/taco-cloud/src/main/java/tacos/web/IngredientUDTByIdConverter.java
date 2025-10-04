package tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.model.Ingredient;
import tacos.model.IngredientUDT;
import tacos.repository.IngredientRepository;
import tacos.utils.TacoUDTUtils;

@Component
public class IngredientUDTByIdConverter implements Converter<String, IngredientUDT>{
	
	IngredientRepository ingredientRepo;
	
	public IngredientUDTByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@Override
	public IngredientUDT convert(String id) {
		Ingredient ingredient = ingredientRepo.findById(id).orElse(null); 
		return TacoUDTUtils.toIngredientUDT(ingredient);
	}
	
}