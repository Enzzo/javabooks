package tacos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Taco")
public class Taco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date createdAt;
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;	
	
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	@NotNull(message = "You must choose at least 1 ingredient")
	@ManyToMany(targetEntity = Ingredient.class)
	private List<Ingredient> ingredients = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, targetEntity = TacoOrder.class)
	private List<TacoOrder> orders = new ArrayList<>();
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
}