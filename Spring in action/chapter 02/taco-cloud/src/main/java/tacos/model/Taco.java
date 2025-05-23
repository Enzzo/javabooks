package tacos.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Taco {
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;
	
	public Taco() {
		log.info("Taco created");
	}
}