package tacos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table(name = "Ingredient")
public class Ingredient{

	@Id
	private final String id;
	private final String name;
	
	@Enumerated(EnumType.STRING)
	private final Type type;

	public enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

}