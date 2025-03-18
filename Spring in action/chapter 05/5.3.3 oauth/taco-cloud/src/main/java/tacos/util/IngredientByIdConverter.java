package tacos.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.model.Ingredient;
import tacos.repository.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	private final IngredientRepository ingredientRepo;
	
//	private Map<String, Ingredient> ingredientMap = new HashMap<>();

	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
	}
	

//	public IngredientByIdConverter() {
//		this.ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//		this.ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//		this.ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//		this.ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//		this.ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
//		this.ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//		this.ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
//		this.ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//		this.ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
//		this.ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//	}
}