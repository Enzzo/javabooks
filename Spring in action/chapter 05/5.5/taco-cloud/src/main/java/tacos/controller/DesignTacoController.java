package tacos.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import tacos.model.User;
import tacos.repository.IngredientRepository;
import tacos.repository.UserRepository;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	
	private final IngredientRepository ingredientRepo;
	private final UserRepository userRepo;
	
	public DesignTacoController(IngredientRepository ingredientRepo, UserRepository userRepo) {
		this.ingredientRepo = ingredientRepo;
		this.userRepo = userRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		Iterable<Ingredient> ingredients = ingredientRepo.findAll();
		
		Type[] types = Ingredient.Type.values();
		for(Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}
	
	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm() {
		log.debug("GET /design");
		return "design";
	}
	
//	I. Principal principal
//	@PostMapping
//	public String processTaco(@Valid Taco taco, 
//			Errors errors, 
//			@ModelAttribute TacoOrder tacoOrder, 
//			Principal principal) {
//		
//		log.debug("POST /design");
//		log.debug("TACO: {}", taco);
//		
//		if(errors.hasErrors()) {
//			return "design";
//		}
	
//		User user = userRepo.findByUsername(principal.getName());
	
//		tacoOrder.addTaco(taco);
//		tacoOrder.setUser(user);
//		
//		log.info("Processing taco {}", taco);
//		return "redirect:/orders/current";
//	}
	
	// II. Authentication authentication
//	@PostMapping
//	public String processTaco(@Valid Taco taco, 
//			Errors errors, 
//			@ModelAttribute TacoOrder tacoOrder, 
//			Authentication authentication) {
//		
//		log.debug("POST /design");
//		log.debug("TACO: {}", taco);
//		
//		if(errors.hasErrors()) {
//			return "design";
//		}
//		
//		User user = (User)authentication.getPrincipal();
//		
//		tacoOrder.addTaco(taco);
//		tacoOrder.setUser(user);
//		
//		log.info("Processing taco {}", taco);
//		return "redirect:/orders/current";
//	}
	
	// III. @AuthenticationPrincipal User user
	@PostMapping
	public String processTaco(@Valid Taco taco, 
			Errors errors, 
			@ModelAttribute TacoOrder tacoOrder, 
			@AuthenticationPrincipal User user) {
		
		log.debug("POST /design");
		log.debug("TACO: {}", taco);
		
		if(errors.hasErrors()) {
			return "design";
		}
				
		tacoOrder.addTaco(taco);
		tacoOrder.setUser(user);
		
		log.info("Processing taco {}", taco);
		return "redirect:/orders/current";
	}
	
	private List<Ingredient> filterByType(
		Iterable<Ingredient> ingredients,
		Type type)
	{
		if(ingredients == null || type == null) {
			return List.of();
		}
		return StreamSupport.stream(ingredients.spliterator(), false)
				.filter(ing -> ing.getType().equals(type))
				.toList();
	}
}