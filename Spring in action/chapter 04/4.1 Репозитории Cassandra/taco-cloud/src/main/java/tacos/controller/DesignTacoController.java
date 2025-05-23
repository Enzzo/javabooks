package tacos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.model.Ingredient;
import tacos.model.Ingredient.Type;
import tacos.model.Taco;
import tacos.model.TacoOrder;
import tacos.model.udt.TacoUDT;
import tacos.repository.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	private final IngredientRepository ingredientRepository;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		
		List<Ingredient> ingredients = (List)ingredientRepository.findAll();
		
		Type[] types = Ingredient.Type.values();
		for(Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}
	
	@ModelAttribute("tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}
	
	@ModelAttribute("taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processTaco(@Valid TacoUDT taco,
			Errors errors,
			@ModelAttribute TacoOrder tacoOrder) {
		
		if(errors.hasErrors()) {
			return "design";
		}
		
		tacoOrder.addTaco(taco);
		log.info("Processing taco: {}", taco);
		return "redirect:/orders/current";
	}
	
	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
		return ingredients.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
}