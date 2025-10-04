package tacos.utils;

import lombok.extern.slf4j.Slf4j;
import tacos.model.Ingredient;
import tacos.model.IngredientUDT;
import tacos.model.Taco;
import tacos.model.TacoUDT;

@Slf4j
public class TacoUDTUtils {
	public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
		return new IngredientUDT(ingredient.getName(), ingredient.getType());
	}
	public static TacoUDT toTacoUDT(Taco taco) {
		return new TacoUDT(taco.getName(), taco.getIngredients());
	}
}