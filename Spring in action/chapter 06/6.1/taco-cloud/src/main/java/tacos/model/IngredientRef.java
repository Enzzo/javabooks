package tacos.model;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Ingredient_ref")
public class IngredientRef {
	private final String ingredient;
}