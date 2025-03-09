package tacos.model;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
//@Entity
public class Taco {
	private static final long serialVersionUID = 1L;
		
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
//	@ManyToMany
	private List<Ingredient> ingredients;
	
	private Date createdAt = new Date();
	
	public Taco() {
		log.info("Taco created");
	}
}